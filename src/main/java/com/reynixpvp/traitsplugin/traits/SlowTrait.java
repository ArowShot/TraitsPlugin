package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.SLOW, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Slow";
    }

    @Override
    public int getPoints() {
        return -50;
    }

    @Override
    public String getType() {
        return "Speed";
    }

    @Override
    public String getDescription() {
        return "Makes you move slower.";
    }
}
