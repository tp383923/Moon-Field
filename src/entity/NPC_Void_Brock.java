package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Void_Brock extends Entity {
	
	
	public NPC_Void_Brock(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Hey Emoji Guy!";
		dialogues[0][1] = "Where are we? This place looks eerily...\nfamiliar. I don't like it.";
		dialogues[0][2] = "Was this, thing, some sort of church?\nIt looks like this place is unfinished.";
		dialogues[0][3] = "That or it was never meant to exist in the first place.";
		
		dialogues[1][0] = "EG, I'm starting to lose my train of thought.\nWhat's happening?";
		dialogues[1][1] = "This place must not be fit for intelligent life.\nYou should either go back or go through\nthe portal past the church.";
		
		dialogues[2][0] = "I miss her.";
	}
	
	public void setAction() {
		
//		actionLockCounter++;
//		
//		if(actionLockCounter == 120) {
//			Random random = new Random();
//			int i = random.nextInt(100) + 1; //pick a number 1-100
//			if(i <= 25) {
//				direction = "up";
//			}
//			if(i > 25 && i <= 50) {
//				direction = "down";
//			}
//			if(i > 50 & i <= 75) {
//				direction = "left";
//			}
//			if(i > 75 & i <= 100) {
//				direction = "right";
//			}
//			actionLockCounter = 0;
//		}
//		

	}
	
	public void speak() {
		//do this character specific stuff
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		if (dialogues[dialogueSet][0] == null) {
			dialogueSet = 2;
		}
		
		// SPECIAL DIALOGUE IF LOW HEALTH
//		if (gp.player.life < gp.player.maxLife/3) {
//			dialogueSet = 1;
//		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Brock_Up_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Brock_Up_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Brock_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Brock_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Brock_Right_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Brock_Right_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Brock_Left_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Brock_Left_2",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   