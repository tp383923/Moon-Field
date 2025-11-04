package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Mini_Moon extends Entity {

	public static final String objName = "Mini Moon";
	
	public OBJ_Mini_Moon(GamePanel gp) {
		super(gp);
		
		type = type_light;
		name = objName;
		down1 = setUp("/objects/Mini_Moon", gp.tileSize, gp.tileSize);
		description = "[Mini Moon]\nA chunk of moon that\nlights your way.";
		price = 100; 
		lightRadius = 350;
	}

}
