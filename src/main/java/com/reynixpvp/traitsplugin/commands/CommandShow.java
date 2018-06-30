package com.reynixpvp.traitsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;
import com.reynixpvp.traitsplugin.traits.Traits;

public class CommandShow extends Command {
    @Override
    public String getLabel() {
        return "show";
    }
    
    @Override
    public boolean perform(Player pl, String[] args, TraitsPlugin p) {
        if(args.length==2) {
            Trait foundTrait = null;
            for(Traits t:Traits.values()) {
                String trn = t.getTrait().getName().toLowerCase();
                if(trn.startsWith(args[1].toLowerCase())) {
                    foundTrait = t.getTrait();
                    break;
                }
            }
            if(foundTrait==null) {
                pl.sendMessage(ChatColor.DARK_RED+"Couldn't find trait \""+ChatColor.RED+args[1]+ChatColor.DARK_RED+"\"");
                return false;
            }
            pl.sendMessage(ChatColor.BLUE+"----- "+ChatColor.AQUA+"Trait "+foundTrait.getDisplayName()+ChatColor.BLUE+" -----");
            pl.sendMessage(ChatColor.BLUE+"Toggleable: "+ChatColor.AQUA+(foundTrait.getPoints()>0?"Yes":"No"));
            pl.sendMessage(ChatColor.BLUE+"Description: "+ChatColor.AQUA+foundTrait.getDescription());
            return true;
        }
        pl.sendMessage(ChatColor.DARK_RED+"Error in syntax, try "+ChatColor.RED+"/trait "+getLabel()+getArgs());
        return false;
    }

    @Override
    public String getArgs() {
        return " <trait>";
    }

    @Override
    public String getDescription() {
        return "Show information about a trait.";
    }
}
