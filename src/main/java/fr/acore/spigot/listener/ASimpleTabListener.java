package fr.acore.spigot.listener;

import fr.acore.spigot.api.player.impl.CorePlayer;
import fr.acore.spigot.event.events.player.PlayerTabRefreshEvent;
import fr.acore.spigot.manager.ASimpleTabManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;



public class ASimpleTabListener implements Listener {

	private ASimpleTabManager tabM;
	
	public ASimpleTabListener(ASimpleTabManager tabM) {
		this.tabM = tabM;
	}
	
	@EventHandler
	public void onTabRefresh(PlayerTabRefreshEvent event) {
		Player player = event.getPlayer();
		CorePlayer<?> cp = tabM.getCorePlayer(player);
		cp.sendPacketPlayOutPlayerListHeaderFooter(tabM.format(player, tabM.getHeader()), tabM.format(player, tabM.getFooter()));
	}
	
}
