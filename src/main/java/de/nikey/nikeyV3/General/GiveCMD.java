package de.nikey.nikeyV3.General;

import de.nikey.nikeyV3.ElementArmor.ElementArmorItems;
import de.nikey.nikeyV3.Upgrading.UpgradingItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GiveCMD implements CommandExecutor, TabCompleter
{
    public boolean onCommand( final CommandSender sender,  final Command command,  final String label,  final String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }
        if (args.length != 1) {
            return false;
        }
        final String arg = args[0];
        if (arg.equalsIgnoreCase("UncommonElementArmor")) {
            ItemStack[] stacks = new ItemStack[4];
            stacks[0] = ElementArmorItems.uncommonElementBoots();
            stacks[1] = ElementArmorItems.uncommonElementLeggings();
            stacks[2] = ElementArmorItems.uncommonElementChestplate();
            stacks[3] = ElementArmorItems.uncommonElementHelmet();
            player.getInventory().addItem(stacks);
            player.sendMessage("§aDone!");
            return true;
        }else if (arg.equalsIgnoreCase("UpgradeTerminal")) {
            ItemStack stack = UpgradingItems.upgradeTerminal();
            player.getInventory().addItem(stack);
            player.sendMessage("§aDone!");
            return true;
        }else if (arg.equalsIgnoreCase("Shards")) {
            ItemStack[] stacks = new ItemStack[10];
            stacks[0] = UpgradingItems.HeartUpgradeShard();
            stacks[1] = UpgradingItems.ShieldUpgradeShard();
            stacks[2] = UpgradingItems.CleansingUpgradeShard();
            stacks[3] = UpgradingItems.ProtectionUpgradeShard();
            player.getInventory().addItem(stacks);
            player.sendMessage("§aDone!");
            return true;
        }else if (arg.equalsIgnoreCase("RareElementArmor")) {
            ItemStack[] stacks = new ItemStack[4];
            stacks[0] = ElementArmorItems.rareElementHelmet();
            stacks[1] = ElementArmorItems.rareElementLeggings();
            stacks[2] = ElementArmorItems.rareElementChestplate();
            stacks[3] = ElementArmorItems.rareElementBoots();
            player.getInventory().addItem(stacks);
            player.sendMessage("§aDone!");
        }
        return false;
    }

    public List<String> onTabComplete(final CommandSender sender,  final Command command,  final String label,  final String[] args) {
        final List<String> completions = new ArrayList<>();
        final List<String> commands = new ArrayList<>();
        commands.add("UncommonElementArmor");
        commands.add("RareElementArmor");
        commands.add("UpgradeTerminal");
        commands.add("Shards");
        StringUtil.copyPartialMatches(args[0], commands, completions);
        return completions;
    }
}
