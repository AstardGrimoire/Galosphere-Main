package net.orcinus.galosphere.network.handler;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.orcinus.galosphere.network.BarometerPacket;
import net.orcinus.galosphere.network.PlayCooldownSoundPacket;
import net.orcinus.galosphere.network.SendParticlesPacket;
import net.orcinus.galosphere.network.SendPerspectivePacket;

public class ServerEventsHandler {

    public static void handleSendParticles(SendParticlesPacket packet, IPayloadContext ctx) {
    }

    public static void sendBarometerInfo(BarometerPacket packet, IPayloadContext ctx) {
    }

    public static void sendPerspective(SendPerspectivePacket packet, IPayloadContext ctx) {
    }

    public static void playCooldownSound(PlayCooldownSoundPacket packet, IPayloadContext ctx) {
    }
}
