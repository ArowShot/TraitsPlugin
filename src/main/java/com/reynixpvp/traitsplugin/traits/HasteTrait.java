package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.FAST_DIGGING, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Haste";
    }

    @Override
    public int getPoints() {
        return 50;
    }

    @Override
    public String getType() {
        return "Haste";
    }

    @Override
    public String getDescription() {
        return "Lets you mine faster.";
    }
}
