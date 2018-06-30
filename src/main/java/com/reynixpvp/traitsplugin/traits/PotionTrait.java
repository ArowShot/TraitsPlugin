package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import com.reynixpvp.traitsplugin.TraitList;

public class PotionTrait extends ActiveTrait {
    
    public PotionEffect getPotionEffect() {
        return null;
    }
    
    @Override
    public void run() {
        for(Player pl:tp.getServer().getOnlinePlayers()) {
            TraitList t = tp.getTraitList(pl);
            if(t.getTraits().containsKey(this) && t.getTraits().get(this)) {
                pl.addPotionEffect(getPotionEffect(), true);
            }
        }
    }

    @Override
    public long getLoopTime() {
        return 10*20;
    }

    @Override
    public String getName() {
        return "Potion";
    }

    @Override
    public int getPoints() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "You shouldn't see this, this is a template.";
    }

    @Override
    public String getType() {
        return "PotionTemplate";
    }

    @Override
    public void onAdd(Player pl) {
        pl.addPotionEffect(getPotionEffect(), true);
    }

    @Override
    public void onRemove(Player pl) {
        pl.removePotionEffect(getPotionEffect().getType());
    }
}
