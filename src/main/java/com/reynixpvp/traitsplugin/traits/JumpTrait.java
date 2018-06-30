package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.JUMP, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "Jump";
    }

    @Override
    public int getPoints() {
        return 50;
    }

    @Override
    public String getType() {
        return "Jump";
    }

    @Override
    public String getDescription() {
        return "Lets you jump higher.";
    }
}
