package bpcservercore.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BPCServerCore extends JavaPlugin{

	int[] pluginversion = {0, 0 ,1};
	String MinecraftVersion = Bukkit.getBukkitVersion();
			
	public void onDisable(){

		System.out.println("[BPC Server Core] BPC Server Core v" + pluginversion[0] + "." + pluginversion[1] + "." + pluginversion[2] + " Has Been Disabled.");

	}
	
	public void onEnable(){

		System.out.println("[BPC Server Core] BPC Server Core v" + pluginversion[0] + "." + pluginversion[1] + "." + pluginversion[2] + " Is Running.");
		System.out.println("[BPC Server Core] **** THIS IS A DEVELOPMENT BUILD USE WITH CAUTION ****");
		System.out.println("[BPC Server Core] This Version Is To Be Used With Minecraft Version " + MinecraftVersion);
		 
	}
	
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			
		  if(cmd.getName().equalsIgnoreCase("confine")){
				if(sender instanceof Player){
					Player player = (Player) sender;
					Location loc = player.getLocation();
					
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null){
					
					// UP DOWN GEN // 
						target.getLocation().subtract(0, 1, 0).getBlock().setType(Material.BEDROCK);
					target.getLocation().subtract(0, -2, 0).getBlock().setType(Material.BEDROCK);
					
					// RIGHT GEN // 
					target.getLocation().subtract(1, 0, 0).getBlock().setType(Material.BEDROCK);
					target.getLocation().subtract(1, -1, 0).getBlock().setType(Material.BEDROCK);
					
					// LEFT GEN //
					target.getLocation().subtract(-1, 0, 0).getBlock().setType(Material.BEDROCK);
					target.getLocation().subtract(-1, -1, 0).getBlock().setType(Material.BEDROCK);
					
					// FRONT GEN //
					target.getLocation().subtract(0, 0, -1).getBlock().setType(Material.BEDROCK);
					target.getLocation().subtract(0, -1, -1).getBlock().setType(Material.BEDROCK);
					
					// BACK GEN //
					target.getLocation().subtract(0, 0, 1).getBlock().setType(Material.BEDROCK);
					target.getLocation().subtract(0, -1, 1).getBlock().setType(Material.BEDROCK);
					
					sender.sendMessage("[Safe Guard] You have Confined " + target.getName());
					
					target.sendMessage("[Safe Guard] You Have Been Confined By " + sender.getName());
					
					}else{
					
						sender.sendMessage("[Safe Guard] Player Is Not Online");
						
						
					}
					
				}
				
				return true;
			}
		return false;
	 }
	
}