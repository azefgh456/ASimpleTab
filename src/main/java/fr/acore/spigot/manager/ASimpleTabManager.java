package fr.acore.spigot.manager;

import fr.acore.spigot.listener.ASimpleTabListener;
import fr.acore.spigot.module.AManager;
import fr.acore.spigot.module.AModule;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



public class ASimpleTabManager extends AManager {

	private String header;
	public String getHeader() { return this.header;}
	
	private String footer;
	public String getFooter() { return this.footer;}
	
	public ASimpleTabManager(AModule plugin) {
		super(plugin, true);
		registerListener(new ASimpleTabListener(this));
	}
	
	@Override
	public void setup(FileConfiguration config) {
		header = convertColor(config.getString("header"));
		footer = convertColor(config.getString("footer"));
	}

	public String format(Player player, String message) {
		int ping = getCorePlayer(player).getPing();
		message = replace(message, "%ping%", String.valueOf(ping));
		message = replace(message, "%onlinePlayer%", String.valueOf(Bukkit.getOnlinePlayers().size()));
		message = replace(message, "%pingColor%", String.valueOf(getPingColor(ping)));
		return message;
	}
	
	
	public ChatColor getPingColor(int ping) {
		if(ping >= 60){
			return ChatColor.RED;
		}else if(ping >= 30){
			return ChatColor.DARK_GREEN;
		}else if(ping <= 30){
			return ChatColor.GREEN;
		}else {
			return ChatColor.GREEN;
		}
	}

}
