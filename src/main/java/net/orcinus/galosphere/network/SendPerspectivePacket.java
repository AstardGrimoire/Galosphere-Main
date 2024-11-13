package net.orcinus.galosphere.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.level.Level;
import net.orcinus.galosphere.Galosphere;

import java.util.Optional;
import java.util.UUID;

public record SendPerspectivePacket(UUID uuid, int id) implements CustomPacketPayload {
    public static final Type<SendPerspectivePacket> TYPE = new Type<>(Galosphere.id("send_perspective"));
    public static final StreamCodec<FriendlyByteBuf, SendPerspectivePacket> STREAM_CODEC = CustomPacketPayload.codec(SendPerspectivePacket::write, SendPerspectivePacket::new);

    private SendPerspectivePacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readInt());
    }

    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.uuid);
        friendlyByteBuf.writeInt(this.id);
    }

    public void receive(ClientPlayNetworking.Context context) {
        Minecraft client = context.client();
        client.execute(() -> {
            Level world = client.level;
            if (world != null) {
                Optional.ofNullable(world.getPlayerByUUID(uuid)).filter(player -> player.equals(client.player)).flatMap(player -> Optional.ofNullable(client.level.getEntity(id))).ifPresent(entity -> {
                    client.setCameraEntity(entity);
                    if (!client.options.getCameraType().isFirstPerson()) {
                        client.options.setCameraType(CameraType.FIRST_PERSON);
                    }
                });
            }
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
