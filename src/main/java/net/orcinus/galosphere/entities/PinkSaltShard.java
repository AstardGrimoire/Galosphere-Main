package net.orcinus.galosphere.entities;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.orcinus.galosphere.init.GBlocks;
import net.orcinus.galosphere.init.GEntityTypes;
import net.orcinus.galosphere.init.GSoundEvents;
import net.orcinus.galosphere.mixin.access.AbstractArrowAccessor;
import net.orcinus.galosphere.mixin.access.ProjectileAccessor;

public class PinkSaltShard extends AbstractArrow {
    private final int maxTicks = 600;
    private int ticks = 0;

    public PinkSaltShard(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public PinkSaltShard(LivingEntity livingEntity, Level level) {
        super(GEntityTypes.PINK_SALT_SHARD, level);
        this.setOwner(livingEntity);
        this.setBaseDamage(4.0F);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        AbstractArrowAccessor accessor = (AbstractArrowAccessor) this;
        ProjectileAccessor projectileAccessor = (ProjectileAccessor) this;
        if (projectileAccessor.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", projectileAccessor.getOwnerUUID());
        }
        if (projectileAccessor.isLeftOwner()) {
            compoundTag.putBoolean("LeftOwner", true);
        }
        compoundTag.putBoolean("HasBeenShot", projectileAccessor.isHasBeenShot());
        compoundTag.putShort("life", (short)accessor.getLife());
        if (accessor.getLastState() != null) {
            compoundTag.put("inBlockState", NbtUtils.writeBlockState(accessor.getLastState()));
        }
        compoundTag.putByte("shake", (byte)this.shakeTime);
        compoundTag.putBoolean("inGround", this.inGround);
        compoundTag.putByte("pickup", (byte)this.pickup.ordinal());
        compoundTag.putDouble("damage", this.getBaseDamage());
        compoundTag.putBoolean("crit", this.isCritArrow());
        compoundTag.putByte("PierceLevel", this.getPierceLevel());
        compoundTag.putString("SoundEvent", BuiltInRegistries.SOUND_EVENT.getKey(this.getHitGroundSoundEvent()).toString());
        compoundTag.putBoolean("ShotFromCrossbow", this.shotFromCrossbow());
    }

    @Override
    public void tick() {
        if (this.ticks++ > this.maxTicks) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
        super.tick();
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        this.level().broadcastEntityEvent(this, (byte) 3);
        this.discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        boolean flag = entity == this.getOwner() || this.getOwner() != null && this.getOwner().isAlliedTo(entity);
        if (!flag) {
            super.onHitEntity(entityHitResult);
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return GSoundEvents.PINK_SALT_SHARD_LAND;
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 3) {
            ParticleOptions particleOptions = new BlockParticleOption(ParticleTypes.BLOCK, GBlocks.PINK_SALT.defaultBlockState());
            for (int i = 0; i < 8; i++) {
                this.level().addParticle(particleOptions, this.getX(), this.getY() + 1.0D, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }
}
