package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Moon_Coin extends Entity {

	GamePanel gp;
	public static final String objName = "Moon Coin";
	
	public OBJ_Moon_Coin(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickup_only;
		name = objName;
		value = 50;
		down1 = setUp("/objects/Moon_Coin", gp.tileSize, gp.tileSize);
	}

	public boolean use(Entity user) {
		gp.playerSE(1);
		gp.ui.showMessage("Coin + " + value);
		gp.player.coin += value;
		return true;
	}
	
}
