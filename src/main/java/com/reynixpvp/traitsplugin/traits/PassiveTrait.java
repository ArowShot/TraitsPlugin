package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public abstract class PassiveTrait extends Trait implements Listener {
    public boolean isActive() {
        return false;
    }

    @Override
    public void onAdd(Player pl) {}

    @Override
    public void onRemove(Player pl) {}
}
