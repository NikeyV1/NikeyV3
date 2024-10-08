package de.nikey.nikeyV3.Upgrading;

import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class UpgradingItems {
    public static ItemStack upgradeTerminal() {
        TextComponent name = Component.text().content("Upgrade Terminal").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC,false).build();
        ItemStack terminal = new ItemStack(Material.ANVIL);
        ItemMeta itemMeta = terminal.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeTerminal"), PersistentDataType.BOOLEAN ,true);
        terminal.setItemMeta(itemMeta);

        return terminal;
    }

    public static ItemStack HeartUpgradeShard() {
        TextComponent name = Component.text().content("Heart Upgrade Shard").color(TextColor.fromHexString("#d94545")).decoration(TextDecoration.ITALIC,false).build();
        ItemStack shard = new ItemStack(Material.HEART_POTTERY_SHERD);
        ItemMeta itemMeta = shard.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeShard.Heart"), PersistentDataType.BOOLEAN,true);
        shard.setItemMeta(itemMeta);

        return shard;
    }

    public static ItemStack ShieldUpgradeShard() {
        TextComponent name = Component.text().content("Shield Upgrade Shard").color(TextColor.fromHexString("#227b7d")).decoration(TextDecoration.ITALIC,false).build();
        ItemStack shard = new ItemStack(Material.HEARTBREAK_POTTERY_SHERD);
        ItemMeta itemMeta = shard.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeShard.Shield"), PersistentDataType.BOOLEAN,true);
        shard.setItemMeta(itemMeta);

        return shard;
    }

    public static ItemStack CleansingUpgradeShard() {
        TextComponent name = Component.text().content("Cleansing Upgrade Shard").color(TextColor.fromHexString("#881e96")).decoration(TextDecoration.ITALIC,false).build();
        ItemStack shard = new ItemStack(Material.BREWER_POTTERY_SHERD);
        ItemMeta itemMeta = shard.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeShard.Cleansing"), PersistentDataType.BOOLEAN,true);
        shard.setItemMeta(itemMeta);

        return shard;
    }

    public static ItemStack ProtectionUpgradeShard() {
        TextComponent name = Component.text().content("Protection Upgrade Shard").color(TextColor.fromHexString("#2A5ADB")).decoration(TextDecoration.ITALIC,false).build();
        ItemStack shard = new ItemStack(Material.EXPLORER_POTTERY_SHERD);
        ItemMeta itemMeta = shard.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeShard.Protection"), PersistentDataType.BOOLEAN,true);
        shard.setItemMeta(itemMeta);

        return shard;
    }

    public static ItemStack SpeedUpgradeShard() {
        TextComponent name = Component.text().content("Speed Upgrade Shard").color(TextColor.fromHexString("#ecf01a")).decoration(TextDecoration.ITALIC,false).build();
        ItemStack shard = new ItemStack(Material.ARMS_UP_POTTERY_SHERD);
        ItemMeta itemMeta = shard.getItemMeta();
        itemMeta.displayName(name);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"UpgradeShard.Speed"), PersistentDataType.BOOLEAN,true);
        shard.setItemMeta(itemMeta);

        return shard;
    }

}
