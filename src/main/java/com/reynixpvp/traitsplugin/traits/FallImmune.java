package com.reynixpvp.traitsplugin.traits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.reynixpvp.traitsplugin.TraitList;

public class FallImmune extends PassiveTrait {    
    @Override
    public String getName() {
        return "FallImmune";
    }

    @Override
    public int getPoints() {
        return 30;
    }

    @Override
    public String getType() {
        return "FallImmune";
    }

    @Override
    public String getDescription() {
        return "Makes you immune to fall damage";
    }
    
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        TraitList t = tp.getTraitList((Player) e.getEntity());
        if(e.getCause().equals(DamageCause.FALL) && t.getTraits().containsKey(this) && t.getTraits().get(this)){
            e.setCancelled(true);
        }
    }
}
