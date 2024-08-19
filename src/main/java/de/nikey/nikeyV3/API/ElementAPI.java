package de.nikey.nikeyV3.API;

import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;


public class ElementAPI {
    public static final Component defaultEmoji = Component.text("[۞]").color(NamedTextColor.DARK_GRAY).decoration(TextDecoration.ITALIC, false);
    public static final Component heartEmoji = Component.text("[❤]").color(TextColor.fromHexString("#d94545")).decoration(TextDecoration.ITALIC, false);
    public static final Component shieldEmoji = Component.text("[🛡]").color(TextColor.fromHexString("#227b7d")).decoration(TextDecoration.ITALIC, false);
    public static final Component cleansingEmoji = Component.text("[✚]").color(TextColor.fromHexString("#881e96")).decoration(TextDecoration.ITALIC, false);

    public static String getItemRarity(ItemStack item) {
        if (item.lore().contains((Component.text("Uncommon").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)))) {
            return "Uncommon";
        }else if (item.lore().contains((Component.text("Rare").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)))) {
            return "Rare";
        } else {
            return "";
        }
    }

    public static boolean isUpgradeShardType(ItemStack item, String shardType) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            Boolean isShard = meta.getPersistentDataContainer().get(new NamespacedKey(NikeyV3.getPlugin(), "UpgradeShard." + shardType), PersistentDataType.BOOLEAN);
            return isShard != null && isShard;
        }
        return false;
    }

    public static boolean isShard(ItemStack item) {
        if (isUpgradeShardType(item, "Heart")) {
            return true;
        } else if (isUpgradeShardType(item, "Shield")) {
            return true;
        }else if (isUpgradeShardType(item, "Cleansing")) {
            return true;
        }else {
            return false;
        }
    }

    public static String getShardType(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
            // Überprüfen, ob das Item eine Shard ist
            for (NamespacedKey key : dataContainer.getKeys()) {
                if (key.getKey().startsWith("upgradeshard.")) {
                    // Gibt den Shard-Typ zurück, z.B. "Heart" oder "Shield"
                    return key.getKey().substring(13);
                }
            }
        }
        // Rückgabe von null, falls kein Shard-Typ gefunden wird
        return null;
    }

    public static boolean isElementItem(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null && meta.hasLore()) {
            if (meta.isUnbreakable()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFreeUpgradeSlot(ItemMeta meta) {
        for (NamespacedKey key : getArmorSlotKeys()) {
            Integer freeSlots = meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
            if (freeSlots != null && freeSlots > 0) {
                return true;
            }
        }
        return false;
    }

    public static int getFreeUpgradeSlots(ItemMeta meta) {
        int totalFreeSlots = 0;
        for (NamespacedKey key : getArmorSlotKeys()) {
            Integer freeSlots = meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
            if (freeSlots != null && freeSlots > 0) {
                totalFreeSlots += freeSlots;
            }
        }
        return totalFreeSlots;
    }

    public static NamespacedKey[] getArmorSlotKeys() {
        return new NamespacedKey[]{
                new NamespacedKey(NikeyV3.getPlugin(), "freeslots.feet.uncommon"),
                new NamespacedKey(NikeyV3.getPlugin(), "freeslots.legs.uncommon"),
                new NamespacedKey(NikeyV3.getPlugin(), "freeslots.chest.uncommon"),
                new NamespacedKey(NikeyV3.getPlugin(), "freeslots.head.uncommon")
        };
    }

    public static void reduceFreeSlots(ItemMeta meta) {
        for (NamespacedKey key : getArmorSlotKeys()) {
            Integer freeSlots = meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
            if (freeSlots != null && freeSlots > 0) {
                meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, freeSlots - 1);
            }
        }
    }

    public static void increaseFreeSlots(ItemStack item) {
        for (NamespacedKey key : getArmorSlotKeys()) {
            Integer freeSlots = item.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
            if (freeSlots != null && freeSlots > 0) {
                if (getItemRarity(item).equalsIgnoreCase("Uncommon") || getItemRarity(item).equalsIgnoreCase("Rare")) {
                    freeSlots+=1;
                    if (!(freeSlots >1)) {
                        item.getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.INTEGER, freeSlots + 1);
                    }
                }
            }
        }
    }

    public static String getUpgradesFromItem(ItemStack item) {
        if (!item.getItemMeta().hasLore())return "";
        List<Component> lore = item.lore();
        String rarity = getItemRarity(item);
        if (rarity.equalsIgnoreCase("Uncommon")) {
            Component component = lore.get(2);

            if (component.equals(heartEmoji)) {
                return "heart";
            }else if (component.equals(shieldEmoji)) {
                return "shield";
            }else if (component.equals(cleansingEmoji)) {
                return "cleansing";
            }
        }else if (rarity.equalsIgnoreCase("Rare")) {
            Component component = lore.get(3);

            if (component.equals(heartEmoji)) {
                return "heart";
            }else if (component.equals(shieldEmoji)) {
                return "shield";
            }else if (component.equals(cleansingEmoji)) {
                return "cleansing";
            }
        }
        return "";
    }

}
