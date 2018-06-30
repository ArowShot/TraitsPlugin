package com.reynixpvp.traitsplugin.traits;

public enum Traits {
    //// Positive
    //Holy
    
    //Weapon strengths
    
    //Potion effects
    NIGHT_VISION(new NightVisionTrait()),
    WATER_BREATHING(new WaterBreathingTrait()),
    HASTE(new HasteTrait()),
    JUMP(new JumpTrait()),
    SPEED(new SpeedTrait()),
    HEALTH_BOOST(new HealthBoostTrait()),
    ABSORPTION(new AbsorptionTrait()),
    ABSORPTION2(new Absorption2Trait()),
    HASTE2(new Haste2Trait()),
    JUMP2(new Jump2Trait()),
    SPEED2(new Speed2Trait()),
    HEALTH_BOOST2(new HealthBoostTrait()),
    
    //Abilities
    
    //Strike and revenge
    
    //Immunity
    FALL_IMMUNE(new FallImmune()),
    
    //Foodstuffs
    
    //Fly
    
    //Truce
    
    //Feed and heal
    FEED_ALWAYS(new FeedAlways()),
    
    PASSIVE_HEALTH_BOOST(new PassiveHealthBoost()),
    //// Negative
    //Unholy
    
    //Weapon weaknesses
    
    //Potion effects
    MINING_FATIGUE(new MiningFatigueTrait()),
    SLOW(new SlowTrait()),
    BLIND(new BlindTrait());
    //Foodstuffs
    
    //Starve and harm
    
    
    Trait trait;
    Traits(Trait trait) {
        this.trait = trait;
    }
    public Trait getTrait() {
        return this.trait;
    }
}
