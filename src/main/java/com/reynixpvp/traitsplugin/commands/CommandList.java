package com.reynixpvp.traitsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;
import com.reynixpvp.traitsplugin.traits.Traits;

public class CommandList extends Command {
    @Override
    public String getLabel() {
        return "list";
    }

    @Override
    public boolean perform(Player pl, String[] args, TraitsPlugin p) {
        int page = 1;
        int pages = (int) Math.ceil(((double)Traits.values().length)/18D);
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
        pl.sendMessage(ChatColor.BLUE+"----- "+ChatColor.AQUA+Traits.values().length+ChatColor.BLUE+" available traits, page "+ChatColor.AQUA+page+"/"+pages+ChatColor.BLUE+" -----");
        for(int i = (page*18)-17; i<=(page*18);) {
            String sendStr = "";
            for(int i2 = i+3;i<i2;i++){
                if(Traits.values().length>i-1&&Traits.values()[i-1]!=null) {
                    Trait tr = Traits.values()[i-1].getTrait();
                    sendStr+=tr.getDisplayName()+ChatColor.AQUA+", ";
                } else {}
            }
            if(sendStr!="") {
                sendStr=sendStr.substring(0, sendStr.length()-2);
                pl.sendMessage(sendStr);
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
        return "List available traits.";
    }
}
