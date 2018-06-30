package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;

public abstract class ActiveTrait extends Trait implements Runnable {
    public boolean isActive() {
        return true;
    }
    public abstract long getLoopTime();
    
    public void onAdd(Player pl){}
    
    public void onRemove(Player pl){}
}
