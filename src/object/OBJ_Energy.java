package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Energy extends Entity {

	GamePanel gp;
	public static final String objName = "Energy Orb";
	
	public OBJ_Energy(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickup_only;
		name = objName;
		value = 1;
		down1 = setUp("/objects/Energy_Full", gp.tileSize, gp.tileSize);
		image = setUp("/objects/Energy_Full", gp.tileSize, gp.tileSize);
		image2 = setUp("/objects/Energy_Empty", gp.tileSize, gp.tileSize);
	}
	
	public boolean use(Entity entity) {
		gp.playerSE(2);
		gp.ui.showMessage("Energy +" + value);
		entity.energy += value;
		return true;
	}

}
