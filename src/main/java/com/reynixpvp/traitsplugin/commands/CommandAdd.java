package com.reynixpvp.traitsplugin.commands;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitList;
import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;
import com.reynixpvp.traitsplugin.traits.Traits;

public class CommandAdd extends Command {
    @Override
    public String getLabel() {
        return "add";
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
            if(tm.containsKey(foundTrait)) {
                pl.sendMessage(ChatColor.DARK_RED+"You already have trait "+foundTrait.getDisplayName());
                return false;
            }
            int pointsAfter = foundTrait.getPoints();
            for(Trait t:tm.keySet()) {
                if(t.getType().equalsIgnoreCase(foundTrait.getType())) {
                    pl.sendMessage(ChatColor.DARK_RED+"Trait "+foundTrait.getDisplayName()+ChatColor.DARK_RED+" is incompatable with "+t.getDisplayName());
                    return false;
                }
                pointsAfter+=t.getPoints();
            }
            if(pointsAfter>150) {
                pl.sendMessage(ChatColor.DARK_RED+"You need another "+ChatColor.RED+(pointsAfter-150)+ChatColor.DARK_RED+" points to add "+foundTrait.getDisplayName());
                return false;
            }
            tm.put(foundTrait, true);
            p.setTraitList(pl, new TraitList(tm));
            foundTrait.onAdd(pl);
            pl.sendMessage(ChatColor.BLUE+"Added trait "+foundTrait.getDisplayName());
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
        return "Add a trait.";
    }
}
