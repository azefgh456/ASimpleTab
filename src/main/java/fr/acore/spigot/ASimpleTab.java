package fr.acore.spigot;


import fr.acore.spigot.manager.ASimpleTabManager;
import fr.acore.spigot.module.AModule;

public class ASimpleTab extends AModule {
	
	@Override
	public void onEnable() {
		super.onEnable();
		registerManager(new ASimpleTabManager(this));
		log("ASimpleTab Enabled");
	}

}
