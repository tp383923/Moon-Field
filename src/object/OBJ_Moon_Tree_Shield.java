package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Moon_Tree_Shield extends Entity {

	public static final String objName = "Moon Tree Shield";
	
	public OBJ_Moon_Tree_Shield(GamePanel gp) {
		super(gp);
		type = type_moon_shield;
		name = objName;
		down1 = setUp("/objects/Moon_Tree_Shield", gp.tileSize, gp.tileSize);
		defenseValue = 2;
		description = "[" + name + "]\nAn ornate shield made\nfrom moon field trees.";
		price = 100;
	}

}
