package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed2Trait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.SPEED, 11*20, 1);
    }
    
    @Override
    public String getName() {
        return "Speed2";
    }

    @Override
    public int getPoints() {
        return 100;
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
