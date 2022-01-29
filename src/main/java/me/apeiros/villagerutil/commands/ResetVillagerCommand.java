package me.apeiros.villagerutil.commands;

import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import me.apeiros.villagerutil.VillagerUtil;
import me.apeiros.villagerutil.items.wands.TradeWand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;

public class ResetVillagerCommand implements CommandExecutor {

    // Pattern used to check if a string is a number
    Pattern numPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    // Constructor which initializes the command
    public ResetVillagerCommand(VillagerUtil p) {
        p.getCommand("resetvillager").setExecutor(this);
    }

    // Triggers when the command is run
    // Uses command number to check if command was run
    // using a Villager Trade Wand
    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, String[] args) {
        // Check if the sender is a player
        if (sender instanceof Player) {
            Player p = (Player) sender;
            int commandNumber;

            // Try to parse command number, if it's not a number set it to -1
            if (numPattern.matcher(args[0]).matches()) {
                commandNumber = Integer.parseInt(args[0]);
            } else {
                commandNumber = -1;
            }

            // Check if the command number if correct
            if (commandNumber == VillagerUtil.getCommandNumber()) {
                // Reset villager's trades
                TradeWand.resetLockedTrades(p);
            } else {
                p.sendMessage(ChatColors.color("&c无效指令!"));
            }
        } else {
            sender.sendMessage(ChatColors.color("&c只有玩家可以执行该指令!"));
        }

        return true;
    }

}