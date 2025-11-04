package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Spirit_Guy extends Entity {

	public NPC_Spirit_Guy(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;
		
		solidArea.x = 4;
		solidArea.y = 19;
		solidArea.width = 41;
		solidArea.height = 29;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Oh, it's you.";
		dialogues[1][0] = "You're still pursuing me?";
		dialogues[1][1] = "I didn't think you would still care.";
		dialogues[1][2] = "Do you remember me?\nDo you remember yourself?";
		dialogues[1][3] = "I am but a shade of you from the past,\nwhether I am real or not is up to you to decide.";
		dialogues[1][4] = "Search and destroy. That's your eternal mission.\nWhen will you stop running?\nWhen will you stop hurting?";
		dialogues[1][5] = "Whatever. Someday you will be the phantom of an evil\nfar greater than yourself.";
		

		
	}
	
	public void setAction() {
		if (onPath == true) {
			int goalCol = 23;
			int goalRow = 7;
			// FOLLOW PLAYER
			//int goalCol = (gp.player.worldX + gp.player.solidArea.x)/ gp.tileSize;
			//int goalRow = (gp.player.worldY + gp.player.solidArea.y)/ gp.tileSize;
			
			searchPath(goalCol, goalRow);
		} 
	}

	public void speak() {
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		onPath = true;
		if (dialogues[dialogueSet][0] == null) {
			dialogueSet = 0;
		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Spirit_Guy_Up_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Spirit_Guy_Up_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Spirit_Guy_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Spirit_Guy_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Spirit_Guy_Left_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Spirit_Guy_Left_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Spirit_Guy_Right_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Spirit_Guy_Right_2",gp.tileSize,gp.tileSize);
		
	}

}
