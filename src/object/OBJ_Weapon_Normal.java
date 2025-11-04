package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Weapon_Normal extends Entity {

	public static final String objName = "Fist";
	
	public OBJ_Weapon_Normal(GamePanel gp) {
		super(gp);
		type = type_fist;
		name = objName;
		down1 = setUp("/objects/Fist", gp.tileSize, gp.tileSize);
		attackValue = 1;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\nThe thing at the end\nof your arm.";
		knockBackPower = 7;
		motion1_duration = 5;
		motion2_duration = 25;
	}

}
