package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.NIGHT_VISION, 60*20, 0);
    }
    
    @Override
    public String getName() {
        return "NightVision";
    }

    @Override
    public int getPoints() {
        return 20;
    }

    @Override
    public String getType() {
        return "NightVision";
    }

    @Override
    public String getDescription() {
        return "Lets you see in the dark.";
    }
}
