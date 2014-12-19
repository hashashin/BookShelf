package me.MitchT.BookShelf.Commands;

import me.MitchT.BookShelf.BookShelfPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BSC_Edit extends BSCommand
{
    
    public BSC_Edit(BookShelfPlugin plugin)
    {
        super(plugin);
    }

    @Override
    public void onPlayerCommand(Player sender, Command command, String[] args)
    {
        if(BookShelfPlugin.editingPlayers.contains(sender))
        {
            BookShelfPlugin.editingPlayers.remove(sender);
            sender.sendMessage("You are no longer in shelf editing mode!");
        }
        else
        {
            BookShelfPlugin.editingPlayers.add(sender);
            sender.sendMessage("You are now in shelf editing mode!");
        }
    }
    
    @Override
    public void onConsoleCommand(ConsoleCommandSender sender, Command command,
            String[] args)
    {
        sender.sendMessage("This command may only be used by players.");
    }
    
    @Override
    public void onCommandBlockCommand(CommandSender sender, Command command,
            String[] args)
    {
        sender.sendMessage("This command may only be used by players.");
    }
    
}
