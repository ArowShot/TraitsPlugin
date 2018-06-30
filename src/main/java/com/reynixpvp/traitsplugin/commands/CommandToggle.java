package com.reynixpvp.traitsplugin.commands;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitList;
import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;
import com.reynixpvp.traitsplugin.traits.Traits;

public class CommandToggle extends Command {
    @Override
    public String getLabel() {
        return "toggle";
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
            if(!p.tryToModify(pl))
                return false;
            if(foundTrait==null) {
                pl.sendMessage(ChatColor.DARK_RED+"Couldn't find trait \""+ChatColor.RED+args[1]+ChatColor.DARK_RED+"\"");
                return false;
            }
            TraitList tl = p.getTraitList(pl);
            Map<Trait, Boolean> tm = tl.getTraits();
            if(!tm.containsKey(foundTrait)) {
                pl.sendMessage(ChatColor.DARK_RED+"You don't have trait "+foundTrait.getDisplayName());
                return false;
            }
            if(foundTrait.getPoints()<0) {
                pl.sendMessage(foundTrait.getDisplayName() + ChatColor.DARK_RED+" can not be toggled.");
                return false;
            }
            tm.put(foundTrait, !tm.get(foundTrait));
            p.setTraitList(pl, new TraitList(tm));
            pl.sendMessage(ChatColor.BLUE+(!tm.get(foundTrait)?"Disabled":"Enabled")+" trait "+foundTrait.getDisplayName());
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
        return "Toggle a trait.";
    }
}
