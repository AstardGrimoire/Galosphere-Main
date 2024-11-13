package net.orcinus.galosphere.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.init.GSoundEvents;

public record SendParticlesPacket(BlockPos blockPos) implements CustomPacketPayload {
    public static final Type<SendParticlesPacket> TYPE = new Type<>(Galosphere.id("send_particles"));
    public static final StreamCodec<FriendlyByteBuf, SendParticlesPacket> STREAM_CODEC = CustomPacketPayload.codec(SendParticlesPacket::write, SendParticlesPacket::new);

    private SendParticlesPacket(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBlockPos());
    }

    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos);
    }

    public void receive(ClientPlayNetworking.Context context) {
        Minecraft client = context.client();
        BlockPos blockPos = this.blockPos();
        client.execute(() -> {
            ClientLevel world = client.level;
            if (world == null) return;
            RandomSource random = world.getRandom();
            world.playLocalSound(blockPos, GSoundEvents.GLOW_FLARE_SPREAD, SoundSource.BLOCKS, 1, 1, false);
            boolean flag = world.getBlockState(blockPos).isCollisionShapeFullBlock(world, blockPos);
            int l2 = flag ? 40 : 20;
            float f9 = flag ? 0.45F : 0.25F;
            for (int k3 = 0; k3 < l2; ++k3) {
                float f12 = 2 * random.nextFloat() - 1;
                float f14 = 2 * random.nextFloat() - 1;
                float f15 = 2 * random.nextFloat() - 1;
                world.addParticle(ParticleTypes.GLOW, (double) blockPos.getX() + 0.5D + (double) (f12 * f9), (double) blockPos.getY() + 0.5D + (double) (f14 * f9), (double) blockPos.getZ() + 0.5D + (double) (f15 * f9), (double) (f12 * 0.07F), (double) (f14 * 0.07F), (double) (f15 * 0.07F));
            }
            world.playLocalSound(blockPos, GSoundEvents.GLOW_FLARE_SPREAD, SoundSource.BLOCKS, 1, 1, false);
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}