package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PassiveHealthBoost extends PassiveTrait {
    @Override
    public String getName() {
        return "PassiveHealthBoost";
    }

    @Override
    public int getPoints() {
        return 50;
    }

    @Override
    public String getType() {
        return "PassiveHealthBoost";
    }

    @Override
    public String getDescription() {
        return "Gives you more hearts.";
    }
    
    @Override
    public void onAdd(Player pl) {
    	pl.setMaxHealth(40);
    }
    
    @Override
    public void onRemove(Player pl) {
    	pl.setMaxHealth(20);
    }
}
