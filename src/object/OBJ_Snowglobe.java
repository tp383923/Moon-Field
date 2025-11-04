package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Snowglobe extends Entity {

	GamePanel gp;
	public static final String objName = "Snow Globe";
	
	public OBJ_Snowglobe(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickup_only;
		name = objName;
		down1 = setUp("/objects/Snowglobe", gp.tileSize, gp.tileSize);
		
		setDialogue();
		
	}
	
	public void setDialogue() {
		dialogues[0][0] = "It's a snowglobe. Inside it is your house.";
		dialogues[0][1] = "You realize. Today has held many unexplainable events \nthat further spark your curiosity,\nbut you are done seeking more.";
		dialogues[0][2] = "You are ready to go home.";
	}
	
	public boolean use (Entity entity) {
		gp.gameState = gp.cutsceneState;
		gp.csManager.sceneNum = gp.csManager.ending;
		return true;
	}

}
