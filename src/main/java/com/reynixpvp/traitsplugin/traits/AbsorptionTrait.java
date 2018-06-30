package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AbsorptionTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.ABSORPTION, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Absorption";
    }

    @Override
    public int getPoints() {
        return 50;
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
