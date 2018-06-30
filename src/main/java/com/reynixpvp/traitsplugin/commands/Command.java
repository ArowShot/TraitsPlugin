package com.reynixpvp.traitsplugin.commands;

import org.bukkit.entity.Player;

import com.reynixpvp.traitsplugin.TraitsPlugin;

public abstract class Command {
    public abstract boolean perform(Player pl, String[] args, TraitsPlugin p);
    public abstract String getLabel();
    public abstract String getArgs();
    public abstract String getDescription();
}
