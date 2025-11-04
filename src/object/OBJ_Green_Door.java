package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Green_Door extends Entity {
	
	GamePanel gp;
	public static final String objName = "Green Door";
	
	public OBJ_Green_Door(GamePanel gp) {
	
	super(gp);
	this.gp = gp;
		
	type = type_obstacle;
	name = objName;
	down1 = setUp("/objects/Green_Door",gp.tileSize,gp.tileSize);
	collision = true; 
	
	solidArea.x = 0; 
	solidArea.y = 16;
	solidArea.width = 48;
	solidArea.height = 32; 
	solidAreaDefaultX = solidArea.x;
	solidAreaDefaultY = solidArea.y;
	setDialogue();
}

	public void setDialogue() {
		dialogues[0][0] = "You need a special key for this.";
	}

	public void interact() {
		startDialogue(this, 0);
	}
}
