package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Tent extends Entity {

	GamePanel gp;
	public static final String objName = "Tent";
	
	public OBJ_Tent(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 = setUp("/objects/Tent", gp.tileSize, gp.tileSize);
		description = "[Tent]\nUse this to sleep\nthrough night.";
		price = 200;
		stackable = true;
	}

	public boolean use(Entity entity) {
		gp.gameState = gp.sleepState;
		gp.playerSE(14);
		gp.player.life = gp.player.maxLife;
		gp.player.energy = gp.player.maxEnergy;
		gp.player.getSleepingImage(down1);
		return true;
	}
	
}
