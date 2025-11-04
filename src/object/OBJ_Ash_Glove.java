package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ash_Glove extends Entity {

	public static final String objName = "Ash Glove";
	
	public OBJ_Ash_Glove(GamePanel gp) {
		super(gp);
		type = type_ash_glove;
		name = objName;
		down1 = setUp("/objects/Ash_Glove", gp.tileSize, gp.tileSize);
		attackValue = 2;
		attackArea.width = 38;
		attackArea.height = 38;
		description = "[" + name + "]\nA glove used to\ndestroy burned trees.";
		price = 100;
		knockBackPower = 10;
		motion1_duration = 10;
		motion2_duration = 25;
	}

}
