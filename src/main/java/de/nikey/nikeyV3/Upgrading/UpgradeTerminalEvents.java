package de.nikey.nikeyV3.Upgrading;

import de.nikey.nikeyV3.API.ElementAPI;
import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.List;
import java.util.Objects;

import static de.nikey.nikeyV3.API.ElementAPI.*;

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
    private static final int TARGET_SLOT = 31;

    @EventHandler()
    public void onInvClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (event.getView().getTitle().equalsIgnoreCase("§6Upgrade Terminal") ) {
            int slot = event.getRawSlot();

            // Verhindere das Herausnehmen von Items aus allen Slots außer Slot 12 und 14
            if (slot >= 0 && slot < inventory.getSize() && slot != 12 && slot != 14) {
                event.setCancelled(true);
            }
        }else if (event.getView().getTitle().equalsIgnoreCase("§6Slot Upgrades")) {
            int slot = event.getRawSlot();

            // Verhindere das Herausnehmen von Items aus allen Slots außer Slot 12 und 14
            if (slot >= 0 && slot < inventory.getSize() && slot != 13 ) {
                event.setCancelled(true);
            }
        }else if (event.getView().getTitle().equalsIgnoreCase("§6Slot Upgrading")) {
            int slot = event.getRawSlot();

            if (inventory.getItem(28).getType() == Material.GRAY_STAINED_GLASS_PANE) {
                if (slot >= 0 && slot < inventory.getSize() &&slot != 13) {
                    event.setCancelled(true);
                }
            }else if (inventory.getItem(34).getType() == Material.GRAY_STAINED_GLASS_PANE) {
                if (slot >= 0 && slot < inventory.getSize() && slot != 31 && slot != 28) {
                    event.setCancelled(true);
                }
            }else if (slot >= 0 && slot < inventory.getSize() && slot != 31 && slot != 28 && slot != 34){
                event.setCancelled(true);
            }

        }
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.getType() == Material.OAK_SIGN) {
            if (event.getView().title().equals(Component.text("Upgrade Terminal").color(NamedTextColor.GOLD))) {
                event.setCancelled(true);
                player.openInventory(createUpgradeInventory());
            } else if (event.getView().title().equals(Component.text("Slot Upgrades").color(NamedTextColor.GOLD))) {
                event.setCancelled(true);
                player.openInventory(createCustomEnderChest());
            }
        }

        if (event.getView().title().equals(Component.text("Slot Upgrades").color(NamedTextColor.GOLD))) {
            // Überprüfen, ob der erste Slot eine Armor mit einem freien Upgrade-Slot enthält
            ItemStack item = event.getInventory().getItem(13); // Slot 10

            ItemStack anvil = new ItemStack(Material.ANVIL);
            ItemMeta anvilMeta = anvil.getItemMeta();
            anvilMeta.displayName(Component.text("Upgrade").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false));
            anvil.setItemMeta(anvilMeta);

            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().isSimilar(anvil)) {
                    if (item == null)return;
                    if (ElementAPI.isElementArmor(item)) {
                        inventory.setItem(13, null);
                        Inventory inv = createUpgradeInventory(item);
                        player.closeInventory();
                        player.openInventory(inv);
                    }
                }
            }
        }

        //Slot Upgrading
        if (event.getView().title().equals(Component.text("Slot Upgrading").color(NamedTextColor.GOLD))) {
            ItemStack item = event.getInventory().getItem(13); // Slot 10

            ItemStack anvil = new ItemStack(Material.ANVIL);
            ItemMeta anvilMeta = anvil.getItemMeta();
            anvilMeta.displayName(Component.text("Upgrade").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false));
            anvil.setItemMeta(anvilMeta);

            if (event.getClick() == ClickType.DOUBLE_CLICK){
                event.setCancelled(true);
                return;
            }
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().isSimilar(anvil)) {
                    event.setCancelled(true);
                    player.playSound(player.getLocation(),Sound.BLOCK_ANVIL_USE,0.8F,0.8F);
                    player.closeInventory();
                }
                if (item == null){
                    player.closeInventory();
                    return;
                }

                String rarity = ElementAPI.getItemRarity(item);

                if (rarity.equalsIgnoreCase("Uncommon") || rarity.equalsIgnoreCase("Rare")) {
                    if (Objects.equals(event.getClickedInventory(), event.getView().getTopInventory()) && event.getSlot() == 31) {
                        if (clickedItem.getType() == Material.MAGENTA_STAINED_GLASS_PANE) {
                            if (ElementAPI.isShard(event.getCursor())) {
                                event.setCurrentItem(event.getCursor());

                                String shardType = getShardType(event.getCursor());
                                applyUpgrade(item, shardType);

                                event.setCursor(null);
                            }
                            event.setCancelled(true);
                        }else if (ElementAPI.isShard(clickedItem)) {
                            if (event.getCursor().getType() == Material.AIR) {
                                event.getView().setCursor(clickedItem);

                                applyUpgrade(item, null);
                                event.getInventory().setItem(31,new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE));
                            }
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }


        // Überprüfe, ob es das benutzerdefinierte Ender Chest-Inventar ist
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("§6Upgrade Terminal") ){
            Inventory inventory = event.getInventory();
            for (ItemStack contents : inventory.getContents()){
                if(contents == null || contents.getType() == Material.AIR || contents.getType() == Material.GRAY_STAINED_GLASS_PANE || contents.getType() == Material.ANVIL || contents.getType() == Material.OAK_SIGN) continue;
                org.bukkit.entity.Player player = (org.bukkit.entity.Player) event.getPlayer();
                int i = player.getInventory().firstEmpty();
                if (i == -1) {
                    player.getWorld().dropItem(player.getLocation(),contents);
                }else {
                    player.getInventory().addItem(contents);
                }
                inventory.clear();
            }
        }else if (event.getView().getTitle().equalsIgnoreCase("§6Slot Upgrading")) {
            Inventory inventory = event.getInventory();
            if (inventory.getItem(13) != null && inventory.getItem(13).getType() != Material.AIR) {
                int i = event.getPlayer().getInventory().firstEmpty();
                if (i == -1) {
                    event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(),inventory.getItem(13));
                }else {
                    event.getPlayer().getInventory().addItem(inventory.getItem(13));
                }
            }
            inventory.clear();
        }else if (event.getView().getTitle().equalsIgnoreCase("§6Slot Upgrades")) {
            Inventory inventory = event.getInventory();
            if (inventory.getItem(13) != null && inventory.getItem(13).getType() != Material.AIR) {
                int i = event.getPlayer().getInventory().firstEmpty();
                if (i == -1) {
                    event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(),inventory.getItem(13));
                }else {
                    event.getPlayer().getInventory().addItem(inventory.getItem(13));
                }
            }
            inventory.clear();
        }
    }


    public Inventory createCustomEnderChest() {
        // Erstelle ein neues Inventar mit 27 Slots (Größe eines Ender Chest)
        Inventory enderChest = Bukkit.createInventory(null, 27, Component.text("Upgrade Terminal").color(NamedTextColor.GOLD));

        // Erstelle Items für das Inventar
        ItemStack switcherSign = new ItemStack(Material.OAK_SIGN);
        ItemMeta signMeta = switcherSign.getItemMeta();
        signMeta.displayName(Component.text("Switch").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false));
        switcherSign.setItemMeta(signMeta);
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta itemMeta = anvil.getItemMeta();
        TextComponent name = Component.text().content("Upgrade").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.ITALIC,false).build();
        itemMeta.displayName(name);
        anvil.setItemMeta(itemMeta);


        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        enderChest.setItem(4, switcherSign);
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

    public Inventory createUpgradeInventory() {
        // Erstelle ein neues Inventar mit einem freien Slot für das Item und den Schaltflächen
        Inventory upgradeInventory = Bukkit.createInventory(null, 27, Component.text("Slot Upgrades").color(NamedTextColor.GOLD));

        ItemStack switcherSign = new ItemStack(Material.OAK_SIGN);
        ItemMeta signMeta = switcherSign.getItemMeta();
        signMeta.displayName(Component.text("Switch").color(NamedTextColor.AQUA).decoration(TextDecoration.ITALIC, false));
        switcherSign.setItemMeta(signMeta);

        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.displayName(Component.text("Upgrade").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false));
        anvil.setItemMeta(anvilMeta);


        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        upgradeInventory.setItem(4, switcherSign);
        upgradeInventory.setItem(14,anvil);

        // Fülle die restlichen Slots mit Glasscheiben
        for (int i = 0; i < upgradeInventory.getSize(); i++) {
            if (upgradeInventory.getItem(i) == null && i != 13 ) { // Lasse den mittleren Slot frei
                upgradeInventory.setItem(i, glassPane);
            }
        }

        return upgradeInventory;
    }

    public Inventory createUpgradeInventory(ItemStack item) {
        // Erstelle ein neues Inventar mit einem freien Slot für das Item und den Schaltflächen
        Inventory upgradeInventory = Bukkit.createInventory(null, 36, Component.text("Slot Upgrading").color(NamedTextColor.GOLD));



        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemStack magenta = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.displayName(Component.text("Upgrade").color(NamedTextColor.GOLD).decoration(TextDecoration.ITALIC, false));
        anvil.setItemMeta(anvilMeta);

        // Fülle die restlichen Slots mit Glasscheiben
        upgradeInventory.setItem(13, item);
        upgradeInventory.setItem(14, anvil);

        upgradeInventory.setItem(31,magenta);

        String rarity = ElementAPI.getItemRarity(item);
        if (rarity.equalsIgnoreCase("Uncommon") || rarity.equalsIgnoreCase("Rare")) {
            for (int i = 0; i < upgradeInventory.getSize(); i++) {
                if (upgradeInventory.getItem(i) == null && i != 13 && i != 31) { // Lasse den mittleren Slot frei
                    upgradeInventory.setItem(i, glassPane);
                    upgradeInventory.setItem(31,magenta);
                }
            }
        }else if (rarity.equalsIgnoreCase("Epic")) {
            for (int i = 0; i < upgradeInventory.getSize(); i++) {
                if (upgradeInventory.getItem(i) == null && i != 13 && i != 31 && i != 28) { // Lasse Slot frei
                    upgradeInventory.setItem(i, glassPane);
                    upgradeInventory.setItem(31,magenta);
                    upgradeInventory.setItem(28,magenta);
                }
            }
        }else if (rarity.equalsIgnoreCase("Mythic")) {
            for (int i = 0; i < upgradeInventory.getSize(); i++) {
                if (upgradeInventory.getItem(i) == null && i != 13 && i != 31 && i != 28 && i != 34) { // Lasse Slot frei
                    upgradeInventory.setItem(i, glassPane);
                    upgradeInventory.setItem(31,magenta);
                    upgradeInventory.setItem(28,magenta);
                    upgradeInventory.setItem(34,magenta);
                }
            }
        }


        if (ElementAPI.isElementItem(item)) {
            List<String> upgrades = getUpgradesFromItem(item);
            if (rarity.equalsIgnoreCase("Uncommon") || rarity.equalsIgnoreCase("Rare")) {
                if (upgrades.getFirst().equalsIgnoreCase("Heart")) {
                    upgradeInventory.setItem(31,UpgradingItems.HeartUpgradeShard());
                }else if (upgrades.getFirst().equalsIgnoreCase("Shield")) {
                    upgradeInventory.setItem(31,UpgradingItems.ShieldUpgradeShard());
                }else if (upgrades.getFirst().equalsIgnoreCase("Cleansing")) {
                    upgradeInventory.setItem(31,UpgradingItems.CleansingUpgradeShard());
                }else if (upgrades.getFirst().equalsIgnoreCase("Protection")) {
                    upgradeInventory.setItem(31,UpgradingItems.ProtectionUpgradeShard());
                }
            }
        }

        return upgradeInventory;
    }

    private boolean isArmor(ItemStack item) {
        ArmorMeta meta = (ArmorMeta) item.getItemMeta();
        if (meta != null && meta.hasLore()) {
            return meta.isUnbreakable() ;
        }
        return false;
    }




    private void applyUpgrade(ItemStack item, String type) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null && meta.hasLore()) {
            List<Component> lore = meta.lore();
            for (int i = 0; i < lore.size(); i++) {
                Component loreComponent = lore.get(i);
                if (loreComponent.equals(ElementAPI.defaultEmoji) || loreComponent.equals(ElementAPI.shieldEmoji) || loreComponent.equals(ElementAPI.heartEmoji)
                        || loreComponent.equals(cleansingEmoji) || loreComponent.equals(protectionEmoji)) {
                    
                    if (type == null) {
                        lore.set(i, ElementAPI.defaultEmoji); // Ersetze den Upgrade-Slot mit dem Herz-Emoji
                        meta.lore(lore);
                        increaseFreeSlots(item);
                        item.setItemMeta(meta);
                        break;
                    }
                    
                    if (type.equalsIgnoreCase("Heart")) {
                        lore.set(i, ElementAPI.heartEmoji); // Ersetze den Upgrade-Slot mit dem Herz-Emoji
                        meta.lore(lore);
                        reduceFreeSlots(meta);
                        item.setItemMeta(meta);
                        break;
                    }else if (type.equalsIgnoreCase("Shield")){
                        lore.set(i, ElementAPI.shieldEmoji); // Ersetze den Upgrade-Slot mit dem Herz-Emoji
                        meta.lore(lore);
                        reduceFreeSlots(meta);
                        item.setItemMeta(meta);
                        break;
                    }else if (type.equalsIgnoreCase("Cleansing")){
                        lore.set(i, cleansingEmoji); // Ersetze den Upgrade-Slot mit dem Herz-Emoji
                        meta.lore(lore);
                        reduceFreeSlots(meta);
                        item.setItemMeta(meta);
                        break;
                    }else if (type.equalsIgnoreCase("Protection")){
                        lore.set(i, protectionEmoji); // Ersetze den Upgrade-Slot mit dem Herz-Emoji
                        meta.lore(lore);
                        reduceFreeSlots(meta);
                        item.setItemMeta(meta);
                        break;
                    }
                }
            }
        }
    }


}