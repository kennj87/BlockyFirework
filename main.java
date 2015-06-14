package firework.blockynights;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.FireworkEffect.Type;


public class main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	
	}
	
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.isOp() && args.length == 1) {
		   Player p = (Player) sender.getServer().getPlayer(args[0]);
		   int i = 0;
		   int cirkle = 0;
		   runnable(p,i,cirkle);
		}
		   return true;
	} 
	
	private void runnable(Player p, int amount,int cirkle) {
		final Player p1 = p;
		final int amount1 = amount;
		final int cirkle1 = cirkle;
        this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
            	createFirework(p1,amount1,cirkle1);
            }
        }, 2L);
	}
	
	private void createFirework(Player p,int amount,int cirkle) {
		int max = 100;
		Location loc = p.getLocation();
		if (cirkle == 0) { cirkle = 1; }
		if (cirkle == 9) { cirkle = 1; }
		if (cirkle == 8) { cirkle = 9;  loc.add(7,0,-7); }
		if (cirkle == 7) { cirkle = 8;  loc.add(0,0,-7); }
		if (cirkle == 6) { cirkle = 7;  loc.add(-7,0,-7); }
		if (cirkle == 5) { cirkle = 6;  loc.add(-7,0,0); }
		if (cirkle == 4) { cirkle = 5;  loc.add(-7,0,7); }
		if (cirkle == 3) { cirkle = 4;  loc.add(0,0,7); }
		if (cirkle == 2) { cirkle = 3;  loc.add(7,0,7); }
		if (cirkle == 1) { cirkle = 2;  loc.add(7,0,0); }
		if (amount < max) {
        Firework fw = (Firework) p.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        Random r = new Random();  
        int rt = r.nextInt(5) + 1;
        Type type = Type.BALL;      
        if (rt == 1) type = Type.BALL;
        if (rt == 2) type = Type.BALL_LARGE;
        if (rt == 3) type = Type.BURST;
        if (rt == 4) type = Type.CREEPER;
        if (rt == 5) type = Type.STAR;
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);
        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
        fwm.addEffect(effect);
        int rp = r.nextInt(2) + 1;
        fwm.setPower(rp);
        fw.setFireworkMeta(fwm);
        amount++;
        runnable(p,amount,cirkle);
		}
	}
	
	
	private Color getColor(int i) {
		Color c = null;
		if(i==1){
		c=Color.AQUA;
		}
		if(i==2){
		c=Color.BLACK;
		}
		if(i==3){
		c=Color.BLUE;
		}
		if(i==4){
		c=Color.FUCHSIA;
		}
		if(i==5){
		c=Color.GRAY;
		}
		if(i==6){
		c=Color.GREEN;
		}
		if(i==7){
		c=Color.LIME;
		}
		if(i==8){
		c=Color.MAROON;
		}
		if(i==9){
		c=Color.NAVY;
		}
		if(i==10){
		c=Color.OLIVE;
		}
		if(i==11){
		c=Color.ORANGE;
		}
		if(i==12){
		c=Color.PURPLE;
		}
		if(i==13){
		c=Color.RED;
		}
		if(i==14){
		c=Color.SILVER;
		}
		if(i==15){
		c=Color.TEAL;
		}
		if(i==16){
		c=Color.WHITE;
		}
		if(i==17){
		c=Color.YELLOW;
		}
		 
		return c;
		}
}
