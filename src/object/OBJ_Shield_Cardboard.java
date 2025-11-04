package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Cardboard extends Entity {

	public static final String objName = "Cardboard Shield";
	
	public OBJ_Shield_Cardboard(GamePanel gp) {
		super(gp);
		type = type_shield;
		name = objName;
		down1 = setUp("/objects/Cardboard_Shield", gp.tileSize, gp.tileSize);
		defenseValue = 1; 
		description = "[" + name + "]\nA shield made of \ncardboard. A bit flimsy.";
		price = 50;
	}

}
