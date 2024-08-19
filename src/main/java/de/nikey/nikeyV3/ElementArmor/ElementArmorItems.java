package de.nikey.nikeyV3.ElementArmor;

import de.nikey.nikeyV3.NikeyV3;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class ElementArmorItems {

    public static ItemStack uncommonElementBoots() {
        TextComponent name = Component.text().content("Element Boots").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.EMERALD, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.feet.uncommon"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Uncommon").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack uncommonElementLeggings() {
        TextComponent name = Component.text().content("Element Leggings").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_LEGGINGS);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.EMERALD, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.legs.uncommon"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Uncommon").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack uncommonElementChestplate() {
        TextComponent name = Component.text().content("Element Chestplate").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.EMERALD, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.chest.uncommon"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Uncommon").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack uncommonElementHelmet() {
        TextComponent name = Component.text().content("Element Helmet").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_HELMET);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.EMERALD, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.head.uncommon"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Uncommon").color(NamedTextColor.DARK_GREEN).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));

        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }



    public static ItemStack rareElementBoots() {
        TextComponent name = Component.text().content("Element Boots").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.LAPIS, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.feet.rare"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Extra Armor: ").color(NamedTextColor.GRAY)).append(Component.text("+1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Rare").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor.feet.rare"), 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor_toughness.feet.rare"), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET));
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.knockback_resistance.feet.rare"), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack rareElementLeggings() {
        TextComponent name = Component.text().content("Element Leggings").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_LEGGINGS);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.LAPIS, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.legs.rare"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Extra Armor: ").color(NamedTextColor.GRAY)).append(Component.text("+1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Rare").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor.legs.rare"), 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor_toughness.legs.rare"), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS));
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.knockback_resistance.legs.rare"), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack rareElementChestplate() {
        TextComponent name = Component.text().content("Element Chestplate").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.LAPIS, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.chest.rare"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Extra Armor: ").color(NamedTextColor.GRAY)).append(Component.text("+1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Rare").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor.chest.rare"), 9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor_toughness.chest.rare"), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST));
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.knockback_resistance.chest.rare"), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }

    public static ItemStack rareElementHelmet() {
        TextComponent name = Component.text().content("Element Helmet").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).build();
        ItemStack boots = new ItemStack(Material.NETHERITE_HELMET);
        ArmorMeta itemMeta = (ArmorMeta)boots.getItemMeta();
        itemMeta.displayName(name);
        ArmorTrim trim = new ArmorTrim(TrimMaterial.LAPIS, TrimPattern.SILENCE);
        itemMeta.setTrim(trim);
        itemMeta.setUnbreakable(true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(NikeyV3.getPlugin(),"freeslots.head.rare"), PersistentDataType.INTEGER ,1);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add((Component.text("Extra Armor: ").color(NamedTextColor.GRAY)).append(Component.text("+1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("Upgrade Slot: ").color(NamedTextColor.GRAY)).append(Component.text("1", NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC,false));
        lore.add((Component.text("[۞]").color(NamedTextColor.DARK_GRAY)).decoration(TextDecoration.ITALIC,false));
        lore.add(Component.text(""));
        lore.add((Component.text("Rare").color(NamedTextColor.BLUE).decoration(TextDecoration.ITALIC,false).decoration(TextDecoration.BOLD,true)));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor.head.rare"), 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.armor_toughness.head.rare"), 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));
        itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE,new AttributeModifier(new NamespacedKey(NikeyV3.getPlugin() , "extra.knockback_resistance.head.rare"), 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD));


        boots.setItemMeta(itemMeta);
        boots.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        boots.lore(lore);
        return boots;
    }
}
