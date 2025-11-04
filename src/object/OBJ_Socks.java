package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Socks extends Entity {

	public static final String objName = "Socks";
	
	public OBJ_Socks(GamePanel gp) {
		super(gp);
		type = type_socks;
		name = objName;
		down1 = setUp("/objects/Socks", gp.tileSize, gp.tileSize);
		attackValue = 3;
		attackArea.width = 40;
		attackArea.height = 40;
		description = "[" + name + "]\nWear them on\nyour hands.";
		price = 200;
		knockBackPower = 5;
		motion1_duration = 10;
		motion2_duration = 20;
	}

}
