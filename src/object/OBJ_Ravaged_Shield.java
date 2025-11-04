package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ravaged_Shield extends Entity {

	public static final String objName = "Ravaged Shield";
	
	public OBJ_Ravaged_Shield(GamePanel gp) {
		super(gp);
		type = type_ravaged_shield;
		name = objName;
		down1 = setUp("/objects/Metal_Shield", gp.tileSize, gp.tileSize);
		defenseValue = 4;
		description = "[" + name + "]\nA tough metal shield\nthat outlasts all.";
		price = 300;
	}

}
