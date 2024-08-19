package de.nikey.nikeyV3.ElementArmor;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import de.nikey.nikeyV3.API.ElementAPI;
import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ElementArmorEvents implements Listener {



    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        updatePlayerHealth(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        resetPlayerHealth(event.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                updatePlayerHealth(event.getPlayer());
            }
        }.runTaskLater(NikeyV3.getPlugin(), 1L); // Delay to ensure health is applied after respawn
    }

    @EventHandler
    public void onPlayerArmorChange(PlayerArmorChangeEvent event) {
        updatePlayerHealth(event.getPlayer());
    }

    private void updatePlayerHealth(Player player) {
        int extraHearts = 0;
        ItemStack[] armorContents = player.getInventory().getArmorContents();

        for (ItemStack item : armorContents) {
            if (item == null)continue;
            if (ElementAPI.isElementItem(item)) {
                if (ElementAPI.getUpgradesFromItem(item).equalsIgnoreCase("Heart")) {
                    extraHearts += 4;
                }
            }
        }

        AttributeInstance healthAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (healthAttribute != null) {
            healthAttribute.setBaseValue(20.0 + extraHearts);
        }

        if (player.getHealth() > healthAttribute.getBaseValue()) {
            player.setHealth(healthAttribute.getBaseValue());
        }
    }

    private void resetPlayerHealth(Player player) {
        AttributeInstance healthAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (healthAttribute != null) {
            healthAttribute.setBaseValue(20.0);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player) {
            int extraShield = 0;
            ItemStack[] armorContents = player.getInventory().getArmorContents();

            for (ItemStack item : armorContents) {
                if (item == null)continue;
                if (ElementAPI.isElementItem(item)) {
                    if (ElementAPI.getUpgradesFromItem(item).equalsIgnoreCase("Shield")) {
                        extraShield += 1;
                    }
                }
            }
            if (extraShield == 0)return;
            double maxDamage;
            switch (extraShield) {
                case 1:
                    maxDamage = 90;
                    break;
                case 2:
                    maxDamage = 80;
                    break;
                case 3:
                    maxDamage = 70;
                    break;
                case 4:
                    maxDamage = 60;
                    break;
                default:
                    maxDamage = 10000;
                    break;
            }

            // Der tatsächlich erlittene Schaden kann nicht höher sein als der maximale Schaden
            if (event.getDamage() > maxDamage) {
                event.setDamage(maxDamage);
            }
        }
    }


    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player player) {
            int extraCleansing = 0;
            ItemStack[] armorContents = player.getInventory().getArmorContents();

            for (ItemStack item : armorContents) {
                if (item == null)continue;
                if (ElementAPI.isElementItem(item)) {
                    if (ElementAPI.getUpgradesFromItem(item).equalsIgnoreCase("Cleansing")) {
                        extraCleansing += 1;
                    }
                }
            }
            List<PotionEffectType> effects = new ArrayList<>();
            if (extraCleansing == 0)return;

            switch (extraCleansing) {
                case 1:
                    effects.add(PotionEffectType.POISON);
                    effects.add(PotionEffectType.WEAKNESS);
                    effects.add(PotionEffectType.HUNGER);
                    break;
                case 2:
                    effects.add(PotionEffectType.POISON);
                    effects.add(PotionEffectType.WEAKNESS);
                    effects.add(PotionEffectType.SLOWNESS);
                    effects.add(PotionEffectType.INSTANT_DAMAGE);
                    effects.add(PotionEffectType.NAUSEA);
                    break;
                case 3:
                    effects.add(PotionEffectType.POISON);
                    effects.add(PotionEffectType.WEAKNESS);
                    effects.add(PotionEffectType.SLOWNESS);
                    effects.add(PotionEffectType.INSTANT_DAMAGE);
                    effects.add(PotionEffectType.WITHER);
                    effects.add(PotionEffectType.LEVITATION);
                    effects.add(PotionEffectType.NAUSEA);
                    effects.add(PotionEffectType.HUNGER);
                    break;
                case 4:
                    effects.add(PotionEffectType.POISON);
                    effects.add(PotionEffectType.WEAKNESS);
                    effects.add(PotionEffectType.SLOWNESS);
                    effects.add(PotionEffectType.INSTANT_DAMAGE);
                    effects.add(PotionEffectType.WITHER);
                    effects.add(PotionEffectType.LEVITATION);
                    effects.add(PotionEffectType.NAUSEA);
                    effects.add(PotionEffectType.HUNGER);
                    effects.add(PotionEffectType.DARKNESS);
                    effects.add(PotionEffectType.WIND_CHARGED);
                    effects.add(PotionEffectType.WEAVING);
                    effects.add(PotionEffectType.OOZING);
                    effects.add(PotionEffectType.INFESTED);
                    break;
                default:
                    break;
            }

            if (effects.contains(event.getNewEffect().getType())) {
                event.setCancelled(true);
                player.removePotionEffect(event.getNewEffect().getType());
            }
        }
    }
}
