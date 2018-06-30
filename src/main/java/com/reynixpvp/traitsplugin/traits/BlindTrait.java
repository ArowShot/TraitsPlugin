package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.BLINDNESS, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Blind";
    }

    @Override
    public int getPoints() {
        return -60;
    }

    @Override
    public String getType() {
        return "Blind";
    }

    @Override
    public String getDescription() {
        return "Prevents you from seeing. (What's even the point of this?)";
    }
}
