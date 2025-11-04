package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Brock extends Entity {
	
	
	public NPC_Brock(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Hey Emoji Guy!";
		dialogues[0][1] = "How are you doing man? Make sure to [SAVE] at\nthe little pond up north if you're hurt,\nand press [ESC] to change your settings.";
		dialogues[0][2] = "It looks like we are on a moon of\nsome sort. Watch out, there's some\nweird monster-things lurking around.";
		
		dialogues[1][0] = "What are you doing here anyway?\nCome to think, you don't seem like\nthe Emoji Guy I know.\nYou seem a bit... colder.";
		dialogues[1][1] = "Oh well, maybe I'm just\nbeing paranoid. Stay safe EG.";
		
		dialogues[2][0] = "Hey EG, back to talk more? I just came\nto this place to catch my breath.\nOffice work is getting crazy again.";
		
		dialogues[3][0] = "Have you ever noticed how the edges\nof this world seem to melt off into nothingness?\nMaybe it's just me.";
		dialogues[3][1] = "I don't have much else to say,\nsorry man. I'm just gonna loop\nmy dialogue.";		
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
			dialogueSet = 0;
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
   