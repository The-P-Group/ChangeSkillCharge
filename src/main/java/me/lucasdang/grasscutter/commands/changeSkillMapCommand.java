package me.lucasdang.grasscutter.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketAvatarSkillMaxChargeCountNotify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(label = "skillMap", aliases = "skill", usage = "[skillId] [change]")
public class changeSkillMapCommand implements CommandHandler {
    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
//        if (args.size() < 2) {
//            this.sendUsageMessage(sender);
//            return;
//        }

//        int skillId = Integer.parseInt(args.get(0));
//        int change = Integer.parseInt(args.get(1));

        Map<Integer, Integer> skillMap = new HashMap<>();

        skillMap.put(10262, 100);

        Avatar currentAvatar = targetPlayer.getTeamManager().getCurrentAvatarEntity().getAvatar();

        var packet = new PacketAvatarSkillMaxChargeCountNotify(currentAvatar, 10262, 100);

        targetPlayer.sendPacket(packet);

        CommandHandler.sendMessage(sender, "SENDED");
    }

}
