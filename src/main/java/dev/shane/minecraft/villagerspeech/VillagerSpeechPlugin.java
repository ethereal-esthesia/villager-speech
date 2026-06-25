// SPDX-License-Identifier: GPL-3.0-only

package dev.shane.minecraft.villagerspeech;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class VillagerSpeechPlugin extends JavaPlugin implements Listener {

    private static final List<String> LINES = List.of(
            "Fresh bread, fair prices, no refunds.",
            "The crops have opinions today.",
            "Emeralds do not grow on trees, but I keep checking.",
            "A quiet village is a lucky village.",
            "If the bell rings twice, walk briskly."
    );

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Enabled. Villagers will answer player interactions with short lines.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled.");
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Villager)) {
            return;
        }

        String line = LINES.get(ThreadLocalRandom.current().nextInt(LINES.size()));
        event.getPlayer().sendMessage(Component.text("<Villager> " + line));
    }
}
