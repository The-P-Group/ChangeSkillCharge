package me.lucasdang.grasscutter.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import me.lucasdang.grasscutter.services.HandleChangeSkillMap;

import java.util.List;

@Command(label = "skillMap", aliases = "skill", usage = "[change]")
public class changeSkillMapCommand implements CommandHandler {
    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 1) {
            this.sendUsageMessage(sender);
            return;
        }

        // Get change number from input
        int change = Integer.parseInt(args.get(0));

        if (change <= 0) {
            CommandHandler.sendMessage(sender, "Change number must be greater than 0");
            return;
        }

        Avatar currentAvatar = targetPlayer.getTeamManager().getCurrentAvatarEntity().getAvatar();

        AvatarSkillDepotData skillDepotData = currentAvatar.getSkillDepot();

        if (skillDepotData == null) {
            CommandHandler.sendMessage(sender, "Skill depot not found!");
            return;
        }

        // Get E skill
        int skillId = skillDepotData.getSkills().get(1);

        HandleChangeSkillMap.addPlayerSkillMap(targetPlayer.getUid(), currentAvatar, skillId, change);
        HandleChangeSkillMap.sendNotify(targetPlayer);

        CommandHandler.sendMessage(sender, "Change skill success");
    }

}
