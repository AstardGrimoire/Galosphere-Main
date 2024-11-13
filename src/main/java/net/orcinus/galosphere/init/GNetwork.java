package net.orcinus.galosphere.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.orcinus.galosphere.network.BarometerPacket;
import net.orcinus.galosphere.network.PlayCooldownSoundPacket;
import net.orcinus.galosphere.network.SendParticlesPacket;
import net.orcinus.galosphere.network.SendPerspectivePacket;

public class GNetwork {

    @Environment(EnvType.CLIENT)
    public static void init() {
        PayloadTypeRegistry.playS2C().register(SendParticlesPacket.TYPE, SendParticlesPacket.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(SendParticlesPacket.TYPE, SendParticlesPacket::receive);

        PayloadTypeRegistry.playS2C().register(SendPerspectivePacket.TYPE, SendPerspectivePacket.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(SendPerspectivePacket.TYPE, SendPerspectivePacket::receive);

        PayloadTypeRegistry.playS2C().register(BarometerPacket.TYPE, BarometerPacket.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(BarometerPacket.TYPE, BarometerPacket::receive);

        PayloadTypeRegistry.playS2C().register(PlayCooldownSoundPacket.TYPE, PlayCooldownSoundPacket.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(PlayCooldownSoundPacket.TYPE, PlayCooldownSoundPacket::receive);
    }

}
