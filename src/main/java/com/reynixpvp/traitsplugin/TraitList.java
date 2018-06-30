package com.reynixpvp.traitsplugin;

import java.util.Map;

import com.reynixpvp.traitsplugin.traits.Trait;

public class TraitList {
    
    public TraitList(Map<Trait, Boolean> traits) {
        traitList = traits;
    }
    
    Map<Trait, Boolean> traitList;

    public Map<Trait, Boolean> getTraits() {
        return traitList;
    }
}
