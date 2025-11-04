package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Rose extends Entity {
	
	
	public NPC_Rose(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "It's a rose. It stands out as the only\nthing of beauty, of reality, on this island.\nEverything else is plain.";
		dialogues[0][1] = "It is mighty, but all alone.\n"
				+ "You wonder how long it took the rose to travel here.\n"
				+ "You wonder if the rose once had a life.\n"
				+ "You wonder if it misses what it once had.";
		dialogues[1][0] = "You don't want to look at the rose anymore.";
 	}
	
	public void setAction() {
	}
	
	public void speak() {
		//do this character specific stuff
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		if (dialogues[dialogueSet][0] == null) {
			dialogueSet = 1;
		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Rose_Down_1",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   