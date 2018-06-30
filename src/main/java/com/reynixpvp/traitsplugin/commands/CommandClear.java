package com.reynixpvp.traitsplugin.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitList;
import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;

public class CommandClear extends Command {
    @Override
    public String getLabel() {
        return "clear";
    }
    
    @Override
    public boolean perform(Player pl, String[] args, TraitsPlugin p) {
        if(args.length==1) {
            if(!p.tryToModify(pl))
                return false;
            p.setTraitList(pl, new TraitList(new HashMap<Trait, Boolean>()));
            pl.sendMessage(ChatColor.BLUE+"Cleared all traits.");
            return true;
        }
        pl.sendMessage(ChatColor.DARK_RED+"Error in syntax, try "+ChatColor.RED+"/trait "+getLabel()+getArgs());
        return false;
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Clears your traits.";
    }
}
