package com.reynixpvp.traitsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;

public class CommandVersion extends Command {
    @Override
    public String getLabel() {
        return "version";
    }
    
    @Override
    public boolean perform(Player pl, String[] args, TraitsPlugin p) {
        pl.sendMessage(ChatColor.BLUE+"----- Traits plugin -----");
        pl.sendMessage(ChatColor.BLUE+"Description: "+ChatColor.AQUA+"A traits plugin based off of MassiveTraits developed for slimecole.");
        pl.sendMessage(ChatColor.BLUE+"Version: "+ChatColor.AQUA+"1.3.4b");
        pl.sendMessage(ChatColor.BLUE+"Developer: "+ChatColor.AQUA+"ArowShot");
        return false;
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Version information.";
    }
}
