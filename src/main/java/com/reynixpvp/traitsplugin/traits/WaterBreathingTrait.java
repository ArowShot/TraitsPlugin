package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WaterBreathingTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.WATER_BREATHING, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "WaterBreathing";
    }

    @Override
    public int getPoints() {
        return 40;
    }

    @Override
    public String getType() {
        return "WaterBreathing";
    }

    @Override
    public String getDescription() {
        return "Lets you breathe under water.";
    }
}
