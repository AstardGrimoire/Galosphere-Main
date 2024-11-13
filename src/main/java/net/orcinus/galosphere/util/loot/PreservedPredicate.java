package net.orcinus.galosphere.util.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.orcinus.galosphere.entities.Preserved;
import org.jetbrains.annotations.Nullable;

public class PreservedPredicate implements EntitySubPredicate {
    public static final MapCodec<PreservedPredicate> CODEC = MapCodec.unit(PreservedPredicate::new);

    @Override
    public MapCodec<? extends EntitySubPredicate> codec() {
        return CODEC;
    }

    @Override
    public boolean matches(Entity entity, ServerLevel serverLevel, @Nullable Vec3 vec3) {
        return entity instanceof Preserved preserved && preserved.isFromChamber();
    }
}
