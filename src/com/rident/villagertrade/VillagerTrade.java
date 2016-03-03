	package com.rident.villagertrade;

	import java.util.logging.Logger;

	import org.bukkit.event.EventHandler;
	import org.bukkit.event.EventPriority;
	import org.bukkit.event.Listener;
	import org.bukkit.event.inventory.InventoryOpenEvent;
	import org.bukkit.event.inventory.InventoryType;
	import org.bukkit.plugin.PluginDescriptionFile;
	import org.bukkit.plugin.PluginManager;
	import org.bukkit.plugin.java.JavaPlugin;

	public class VillagerTrade extends JavaPlugin implements Listener {
		public static VillagerTrade plugin;
		public Logger log;

	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);

		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().info(pdfFile.getName() + " has been enabled!");
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().info(pdfFile.getName() + " has been disabled.");
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onInventoryOpen(InventoryOpenEvent event) {
		if (event.getInventory().getType() == InventoryType.MERCHANT) {
					event.setCancelled(true);
		}
	}
}