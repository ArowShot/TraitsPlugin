package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitList;

public class FeedAlways extends ActiveTrait {
    @Override
    public void run() {
        for(Player pl:tp.getServer().getOnlinePlayers()) {
            TraitList t = tp.getTraitList(pl);
            if(t.getTraits().containsKey(this) && t.getTraits().get(this)) {
                pl.setFoodLevel(pl.getFoodLevel()+1);
                pl.setSaturation(pl.getSaturation()+1);
            }
        }
    }

    @Override
    public long getLoopTime() {
        return 3*20;
    }

    @Override
    public String getName() {
        return "FeedAlways";
    }

    @Override
    public int getPoints() {
        return 100;
    }

    @Override
    public String getType() {
        return "FeedAlways";
    }

    @Override
    public String getDescription() {
        return "Regenerate 1 hunger bar every 3 seconds.";
    }
}
