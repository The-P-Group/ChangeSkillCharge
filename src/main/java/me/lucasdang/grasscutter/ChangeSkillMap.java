package me.lucasdang.grasscutter;

import emu.grasscutter.plugin.Plugin;
import emu.grasscutter.server.event.EventHandler;
import emu.grasscutter.server.event.HandlerPriority;
import emu.grasscutter.server.event.game.ReceivePacketEvent;
import emu.grasscutter.server.event.game.SendPacketEvent;

public class ChangeSkillMap extends Plugin {
    private static ChangeSkillMap instance;

    public static ChangeSkillMap getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        // Set the plugin instance.
        instance = this;
    }

    @Override
    public void onEnable() {
        // Register event listener
        new EventHandler<>(SendPacketEvent.class)
                .priority(HandlerPriority.LOW)
                .listener(EventListeners::onReceivePacket)
                .register(this);

        // Register commands.
        this.getHandle().registerCommand(new me.lucasdang.grasscutter.commands.changeSkillMapCommand());

        // Log a plugin status message.
        this.getLogger().info("ChangeSkillMap By Lucas");
    }

    @Override
    public void onDisable() {
        // Log a plugin status message.
        this.getLogger().info("How could you do this to me... changeSkillMap has been disabled.");
    }
}