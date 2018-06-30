package com.reynixpvp.traitsplugin.traits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiningFatigueTrait extends PotionTrait {
    @Override
    public PotionEffect getPotionEffect() {
        return new PotionEffect(PotionEffectType.SLOW_DIGGING, 11*20, 0);
    }
    
    @Override
    public String getName() {
        return "MiningFatigue";
    }

    @Override
    public int getPoints() {
        return -50;
    }

    @Override
    public String getType() {
        return "Haste";
    }

    @Override
    public String getDescription() {
        return "Makes you mine slower.";
    }
}
