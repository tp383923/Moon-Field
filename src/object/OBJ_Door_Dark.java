package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door_Dark extends Entity {

	GamePanel gp;
	public static final String objName = "Dark Door";
	
	public OBJ_Door_Dark(GamePanel gp) {
	
	super(gp);
	this.gp = gp;
		
	type = type_obstacle;
	name = objName;
	down1 = setUp("/objects/Dark_Door",gp.tileSize,gp.tileSize);
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
		dialogues[0][0] = "Not gonna open.";
	}

	public void interact() {
		startDialogue(this, 0);
	}
}
