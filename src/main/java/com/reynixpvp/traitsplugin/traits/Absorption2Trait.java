package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Absorption2Trait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.ABSORPTION, 11*20, 1);
    }
    
    @Override
    public String getName() {
        return "Absorption2";
    }

    @Override
    public int getPoints() {
        return 75;
    }

    @Override
    public String getType() {
        return "Absorption";
    }

    @Override
    public String getDescription() {
        return "Gives you the absorption effect.";
    }
}
