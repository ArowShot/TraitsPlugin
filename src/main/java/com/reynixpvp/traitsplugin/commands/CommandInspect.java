package com.reynixpvp.traitsplugin.commands;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;
import com.reynixpvp.traitsplugin.traits.Trait;

public class CommandInspect extends Command {
    @Override
    public String getLabel() {
        return "inspect";
    }

    @Override
    public boolean perform(Player opl, String[] args, TraitsPlugin p) {
        Player pl = opl;
        if(args.length>1) {
            if(opl.hasPermission("traits.inspectothers")) {
                pl = p.getServer().getPlayer(args[1]);
                if(pl==null) {
                    pl=opl;
                    opl.sendMessage(ChatColor.DARK_RED+"Could not find player \""+ChatColor.RED+args[1]+ChatColor.DARK_RED+"\"");
                    return false;
                }
            } else {
                opl.sendMessage(ChatColor.DARK_RED+"You don't have permission to inspect other players!");
                return false;
            }
        }
        opl.sendMessage(ChatColor.BLUE+"----- Traits for "+ChatColor.AQUA+pl.getName()+ChatColor.BLUE+" -----");
        int pointsUsed = 0;
        for(Trait t:p.getTraitList(pl).getTraits().keySet()) {
            pointsUsed+=t.getPoints();
        }
        opl.sendMessage(ChatColor.BLUE+"Points used: "+ChatColor.AQUA+pointsUsed+"/150");
        opl.sendMessage(ChatColor.BLUE+"Slots used: "+ChatColor.AQUA+p.getTraitList(pl).getTraits().size()+"/10");
        opl.sendMessage(" ");
        Map<Trait, Boolean> tm = p.getTraitList(pl).getTraits();
        for(Trait t:tm.keySet()) {
            if(tm.get(t)) {
                opl.sendMessage(t.getDisplayName());
            } else {
                opl.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+ChatColor.stripColor(t.getDisplayName())+" (disabled)");
            }
        }
        return true;
    }

    @Override
    public String getArgs() {
        return " [player]";
    }

    @Override
    public String getDescription() {
        return "View somebody's traits.";
    }
}
