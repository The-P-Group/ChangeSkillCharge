package me.lucasdang.grasscutter.services;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketAvatarSkillMaxChargeCountNotify;
import me.lucasdang.grasscutter.models.PlayerSkillMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleChangeSkillMap {
    private static final Map<Integer, List<PlayerSkillMap>> playerMaps = new HashMap<>();

    public static void addPlayerSkillMap(int playerId, Avatar currentAvatar, int skillId, int nou) {
        PlayerSkillMap psm = new PlayerSkillMap(currentAvatar, skillId, nou);

        var listMap = playerMaps.get(playerId);

        if (listMap != null) {
            listMap.add(psm);
        } else {
            List<PlayerSkillMap> newList = new ArrayList<>();
            newList.add(psm);

            playerMaps.put(playerId, newList);
        }
    }

    public static void sendNotify(Player targetPlayer) {
        try {
            List<PlayerSkillMap> psms = playerMaps.get(targetPlayer.getUid());

            if (psms == null) {
                return;
            }

            for (PlayerSkillMap psm : psms) {
                var packet = new PacketAvatarSkillMaxChargeCountNotify(psm.getAvatar(), psm.getSkillId(), psm.getNou());

                targetPlayer.sendPacket(packet);
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error(e.getMessage());
        }
    }
}
