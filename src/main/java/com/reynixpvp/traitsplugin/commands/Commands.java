package com.reynixpvp.traitsplugin.commands;

public enum Commands {
    HELP(new CommandHelp()),
    LIST(new CommandList()),
    INSPECT(new CommandInspect()),
    SHOW(new CommandShow()),
    ADD(new CommandAdd()),
    REMOVE(new CommandRemove()),
    CLEAR(new CommandClear()),
    TOGGLE(new CommandToggle()),
    VERSION(new CommandVersion());
    
    private Command command;
    
    Commands (Command command) {
        this.setCommand(command);
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
