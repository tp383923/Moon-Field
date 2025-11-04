package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Boxing_Glove extends Entity {

	public static final String objName = "Boxing Glove";
	
	public OBJ_Boxing_Glove(GamePanel gp) {
		super(gp);
		type = type_boxing_glove;
		name = objName;
		down1 = setUp("/objects/Boxing_Glove", gp.tileSize, gp.tileSize);
		attackValue = 4;
		attackArea.width = 38;
		attackArea.height = 38;
		description = "[" + name + "]\nA fighter's glove.\nCan destroy old bricks.";
		price = 100;
		knockBackPower = 12;
		motion1_duration = 5;
		motion2_duration = 25;
	}

}
