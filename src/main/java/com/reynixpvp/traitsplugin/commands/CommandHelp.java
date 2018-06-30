package com.reynixpvp.traitsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;

public class CommandHelp extends Command {
    @Override
    public String getLabel() {
        return "help";
    }

    @Override
    public boolean perform(Player pl, String[] args, TraitsPlugin p) {
        int page = 1;
        int pages = (int) Math.ceil(((double)Commands.values().length)/9D);
        if(args.length>1) {
            try {
                page = Integer.parseInt(args[1]);
            } catch(Exception ex) {
                pl.sendMessage(ChatColor.DARK_RED+"Invalid page "+ChatColor.RED+args[1]);
            }
            if(pages<page) {
                page=pages;
            }
        }
        pl.sendMessage(ChatColor.BLUE+"----- Traits plugin help page "+ChatColor.AQUA+page+"/"+pages+ChatColor.BLUE+" -----");
        for(int i = (page*9)-8; i<=(page*9); i++) {
            if(Commands.values().length>i-1&&Commands.values()[i-1]!=null) {
                Command cmd = Commands.values()[i-1].getCommand();
                pl.sendMessage(ChatColor.AQUA + "/traits "+cmd.getLabel()+cmd.getArgs()+ChatColor.BLUE+" - "+cmd.getDescription());
            } else {
                //pl.sendMessage(" ");
            }
            
        }
        return true;
    }

    @Override
    public String getArgs() {
        return " [page]";
    }

    @Override
    public String getDescription() {
        return "Shows this help screen.";
    }
}
