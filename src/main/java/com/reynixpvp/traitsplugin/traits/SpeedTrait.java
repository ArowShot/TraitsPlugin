package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.SPEED, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Speed";
    }

    @Override
    public int getPoints() {
        return 50;
    }

    @Override
    public String getType() {
        return "Speed";
    }

    @Override
    public String getDescription() {
        return "Lets you move faster.";
    }
}
