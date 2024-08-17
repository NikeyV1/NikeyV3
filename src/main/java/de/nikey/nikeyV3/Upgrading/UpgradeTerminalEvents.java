package de.nikey.nikeyV3.Upgrading;

import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;

public class UpgradeTerminalEvents implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.ANVIL) {
            ItemStack item = event.getItemInHand();
            if (item.isSimilar(UpgradingItems.upgradeTerminal())) {
                block.setMetadata("UpgradeTerminal", new FixedMetadataValue(NikeyV3.getPlugin(), true));
            }
        }
    }


    @EventHandler
    public void onAnvilClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.ANVIL) {
            Block block = event.getClickedBlock();
            if (block.hasMetadata("UpgradeTerminal") && event.getAction() != Action.LEFT_CLICK_BLOCK) {
                Player player = event.getPlayer();
                event.setCancelled(true);
                Inventory ec = createCustomEnderChest();

                player.openInventory(ec);
            }
        }
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();

        // Überprüfe, ob es das benutzerdefinierte Ender Chest-Inventar ist
        if (event.getView().getTitle().equalsIgnoreCase("§6Upgrade Terminal")) {
            int slot = event.getRawSlot();

            // Verhindere das Herausnehmen von Items aus allen Slots außer Slot 12 und 14
            if (slot >= 0 && slot < inventory.getSize() && slot != 12 && slot != 14) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("§6Upgrade Terminal")){
            Inventory inventory = event.getInventory();
            for (ItemStack contents : inventory.getContents()){
                if(contents == null || contents.getType() == Material.AIR || contents.getType() == Material.GRAY_STAINED_GLASS_PANE || contents.getType() == Material.ANVIL) continue;
                org.bukkit.entity.Player player = (org.bukkit.entity.Player) event.getPlayer();
                int i = player.getInventory().firstEmpty();
                if (i == -1) {
                    player.getWorld().dropItem(player.getLocation(),contents);
                }else {
                    player.getInventory().addItem(contents);
                }
                inventory.clear();
            }
        }
    }


    public Inventory createCustomEnderChest() {
        // Erstelle ein neues Inventar mit 27 Slots (Größe eines Ender Chest)
        Inventory enderChest = Bukkit.createInventory(null, 27, Component.text("Upgrade Terminal").color(NamedTextColor.GOLD));

        // Erstelle Items für das Inventar
        ItemStack signItem = new ItemStack(Material.OAK_SIGN);
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta itemMeta = anvil.getItemMeta();
        TextComponent name = Component.text().content("Upgrade").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC,false).build();
        itemMeta.displayName(name);
        anvil.setItemMeta(itemMeta);


        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        enderChest.setItem(4, signItem);
        enderChest.setItem(13, anvil);


        // Fülle die restlichen Slots mit Glasscheiben
        for (int i = 0; i < enderChest.getSize(); i++) {
            if (enderChest.getItem(i) == null) {
                if (i != 12 && i != 14) {
                    enderChest.setItem(i, glassPane);
                }
            }
        }

        return enderChest;
    }
}