package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Haste2Trait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.FAST_DIGGING, 11*20, 1);
    }
    
    @Override
    public String getName() {
        return "Haste2";
    }

    @Override
    public int getPoints() {
        return 100;
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
