package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealthBoostTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.HEALTH_BOOST, 21*20, 0);
    }
    
    @Override
    public String getName() {
        return "HealthBoost";
    }

    @Override
    public int getPoints() {
        return 50;
    }

    @Override
    public String getType() {
        return "HealthBoost";
    }

    @Override
    public String getDescription() {
        return "Gives you more hearts.";
    }
}
