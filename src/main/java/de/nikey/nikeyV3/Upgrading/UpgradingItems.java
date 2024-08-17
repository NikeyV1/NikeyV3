package de.nikey.nikeyV3.Upgrading;

import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
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
}
