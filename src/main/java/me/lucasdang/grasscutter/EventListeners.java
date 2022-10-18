package me.lucasdang.grasscutter;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.event.game.SendPacketEvent;
import emu.grasscutter.server.packet.send.PacketAvatarSkillMaxChargeCountNotify;
import me.lucasdang.grasscutter.services.HandleChangeSkillMap;

public class EventListeners {
    public static void onReceivePacket(SendPacketEvent event) {
        if (event.getPacket().getOpcode() == PacketOpcodes.EnterSceneDoneRsp) {
            Player currentPlayer = event.getGameSession().getPlayer();

            HandleChangeSkillMap.sendNotify(currentPlayer);

            Grasscutter.getLogger().info(String.format("Player %s enter new scene, sent reload skill", currentPlayer.getUid()));
        }
    }
}
