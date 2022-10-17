package me.lucasdang.grasscutter;

import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.event.game.SendPacketEvent;
import emu.grasscutter.server.packet.send.PacketAvatarSkillMaxChargeCountNotify;

public class EventListeners {
    public static void onReceivePacket(SendPacketEvent event) {
        if (event.getPacket().getOpcode() == PacketOpcodes.EnterSceneDoneRsp) {
            var avatar = event.getGameSession().getPlayer().getTeamManager().getCurrentAvatarEntity().getAvatar();

            event.getGameSession().getPlayer().sendPacket(new PacketAvatarSkillMaxChargeCountNotify(avatar, 10262, 100));

            CommandHandler.sendMessage(event.getGameSession().getPlayer(), "RELOAD SUCCESS");
        }
    }
}
