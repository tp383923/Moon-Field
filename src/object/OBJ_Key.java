package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	GamePanel gp;
	public static final String objName = "Key";
	
	public OBJ_Key(GamePanel gp) {
		super(gp); 
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 = setUp("/objects/Key",gp.tileSize,gp.tileSize);
		description = "[" + name + "]\nAn old key. \nMay unlock something.";
		price = 50;
		stackable = true;
		setDialogue();
	}
	
	public void setDialogue() {
		dialogues[0][0] =  "Used " + name + " to open the door.";
		
		dialogues[1][0] = "Quit messing around.";
	}
	
	public boolean use(Entity entity) {
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if (objIndex != 999) {
			startDialogue(this, 0);
			gp.playerSE(3);
			gp.obj[gp.currentMap][objIndex] = null;
			return true;
		} else {
			startDialogue(this, 1);
			return false;
		}
	}
}
