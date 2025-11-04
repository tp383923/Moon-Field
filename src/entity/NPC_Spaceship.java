package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Spaceship extends Entity {
	
	
	public NPC_Spaceship(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "It's your (destroyed) spaceship. You boot up the flight logs:";
		dialogues[0][1] = "ENGINE STATUS: Offline\nCONNECTION: Disconnected\nSHIELDING SYSTEMS: Offline\nLAST DESTINATION: Far Far Away";		
		dialogues[0][2] = "Looks like you're going to be here for a while.";
	}
	
	public void setAction() {

	}
	
	public void speak() {
		//do this character specific stuff
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		if (dialogues[dialogueSet][0] == null) {
			dialogueSet = 0;
		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Spaceship_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Spaceship_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Spaceship_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Spaceship_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Spaceship_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Spaceship_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Spaceship_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Spaceship_Down_2",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   