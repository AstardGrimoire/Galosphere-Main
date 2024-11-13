package net.orcinus.galosphere.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.orcinus.galosphere.Galosphere;
import net.orcinus.galosphere.init.GSoundEvents;

public record PlayCooldownSoundPacket() implements CustomPacketPayload {
    public static final Type<PlayCooldownSoundPacket> TYPE = new Type<>(Galosphere.id("play_cooldown_sound"));
    public static final StreamCodec<FriendlyByteBuf, PlayCooldownSoundPacket> STREAM_CODEC = CustomPacketPayload.codec(PlayCooldownSoundPacket::write, PlayCooldownSoundPacket::new);

    private PlayCooldownSoundPacket(FriendlyByteBuf buf) {
        this();
    }

    public void write(FriendlyByteBuf friendlyByteBuf) {
    }

    public void receive(ClientPlayNetworking.Context context) {
        Minecraft client = context.client();
        client.execute(() -> {
            if (client.player != null) client.getSoundManager().play(SimpleSoundInstance.forUI(GSoundEvents.SALTBOUND_TABLET_COOLDOWN_OVER, 1));
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
