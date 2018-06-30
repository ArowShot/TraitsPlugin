package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealthBoost2Trait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.HEALTH_BOOST, 11*20, 1);
    }
    
    @Override
    public String getName() {
        return "HealthBoost2";
    }

    @Override
    public int getPoints() {
        return 100;
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
