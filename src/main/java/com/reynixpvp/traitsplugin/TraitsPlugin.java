package com.reynixpvp.traitsplugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.google.gson.Gson;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.reynixpvp.traitsplugin.commands.Commands;
import com.reynixpvp.traitsplugin.traits.ActiveTrait;
import com.reynixpvp.traitsplugin.traits.PassiveTrait;
import com.reynixpvp.traitsplugin.traits.Trait;
import com.reynixpvp.traitsplugin.traits.Traits;

public class TraitsPlugin extends JavaPlugin implements Listener {
	public Plugin pl;
	public BukkitScheduler scheduler;
	public Gson gson;
	public Map<Player, Long> timeLastDamaged = new HashMap<Player, Long>();
    public Map<Player, Long> timeLastMoved = new HashMap<Player, Long>();
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player pl = e.getPlayer();
		if(!timeLastDamaged.containsKey(pl)) {
		    timeLastDamaged.put(pl, 0L);
		}
        if(!timeLastMoved.containsKey(pl)) {
            timeLastMoved.put(pl, 0L);
        }
		loadTraits(pl);
	}
	
	public boolean tryToModify(Player pl) {
	    return true;
	}
	
	public void loadTraits(Player pl) {
	    Map<Trait, Boolean> m = new HashMap<Trait, Boolean>();
	    List<String> t = new ArrayList<String>();
	    //load traits from file
	    //t.add("fallimmune:true");
	    try {
	        File dir = new File(getDataFolder()+"/traits/");
	        dir.mkdirs();
	        File f = new File(dir+"/"+pl.getUniqueId().toString());
            f.createNewFile();
            BufferedReader fr = new BufferedReader(new FileReader(f));
            String nextLine = fr.readLine();
            while(nextLine!=null) {
                t.add(nextLine);
                nextLine = fr.readLine();
            }
            fr.close();
        } catch (IOException e) {
            pl.sendMessage(ChatColor.DARK_RED+"Could not load traits!");
            e.printStackTrace();
        }
	    for(String str:t) {
	        String[] strs = str.split(":");
	        for(Traits tr:Traits.values()) {
	            if(tr.getTrait().getName().equalsIgnoreCase(strs[0])) {
	                m.put(tr.getTrait(), Boolean.valueOf(strs[1]));
	            }
	        }
	    }
	    TraitList tl = new TraitList(m);
	    setTraitList(pl, tl);
	}
	
	public void saveTraits(Player pl) {
	    TraitList t = getTraitList(pl);
        try {
            File dir = new File(getDataFolder()+"/traits/");
            dir.mkdirs();
            File f = new File(dir+"/"+pl.getUniqueId().toString());
            f.createNewFile();
            PrintWriter fr = new PrintWriter(f);
            for(Trait tr:t.getTraits().keySet()) {
                fr.println(tr.getName()+":"+t.getTraits().get(tr));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setTraitList(Player pl, TraitList list) {
	    pl.setMetadata("traits", new FixedMetadataValue(this, list));
        saveTraits(pl);
	}
	 
	public TraitList getTraitList(Player pl) {
	    List<MetadataValue> values = pl.getMetadata("traits");  
	    for (MetadataValue value : values) {
	        if (value.getOwningPlugin() == this) {
	            return (TraitList) value.value();
	        }
	    }
	    return null;
	}

    @Override
	public void onEnable() {
		this.pl = this;
        this.scheduler = getServer().getScheduler();
        this.gson = new Gson();
		getServer().getPluginManager().registerEvents(this, this);
		for(Traits ts:Traits.values()) {
		    Trait t = ts.getTrait();
		    t.setTP(this);
		    if(t.isActive()) {
		        ActiveTrait at = (ActiveTrait) t;
		        getServer().getScheduler().scheduleSyncRepeatingTask(this, at, 0L, at.getLoopTime());
		    } else {
		        PassiveTrait pt = (PassiveTrait) t;
		        getServer().getPluginManager().registerEvents(pt, this);
		    }
		}
		
		//Reload protection!
		for(Player pl:getServer().getOnlinePlayers()) {
		    PlayerJoinEvent event = new PlayerJoinEvent(pl, "");
		    getServer().getPluginManager().callEvent(event);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player pl = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("trait")) {
		    if(args.length==0) {
		        return Commands.HELP.getCommand().perform(pl, args, this);
		    } else {
		        com.reynixpvp.traitsplugin.commands.Command run = null;
		        for(Commands c:Commands.values()) {
		            if(c.getCommand().getLabel().toLowerCase().startsWith(args[0].toLowerCase())) {
		                run = c.getCommand();
		            }
		        }
		        if(run != null) {
		            return run.perform(pl, args, this);
		        } else {
		            pl.sendMessage(ChatColor.DARK_RED+"Could not find command \""+ChatColor.RED+args[0]+ChatColor.DARK_RED+"\" use \""+ChatColor.RED+"/traits help"+ChatColor.DARK_RED+"\" to view the commands.");
		        }
		    }
			//return true;
		}
		
		return false;
	}
}
