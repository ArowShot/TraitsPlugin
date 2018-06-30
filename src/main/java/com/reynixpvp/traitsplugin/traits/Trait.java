package com.reynixpvp.traitsplugin.traits;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;

public abstract class Trait {
    public abstract String getName();
    public abstract boolean isActive();
    public abstract int getPoints();
    public abstract String getType();
    public abstract String getDescription();
    public abstract void onAdd(Player pl);
    public abstract void onRemove(Player pl);
    
    TraitsPlugin tp;
    public void setTP(TraitsPlugin tp) {
        this.tp = tp;
    }
    public String getDisplayName() {
        ChatColor c = this.getPoints()<0?ChatColor.RED:ChatColor.GREEN;
        String pfx = this.getPoints()<0?"":"+";
        return c+pfx+this.getPoints()+" "+this.getName();
    }
}
