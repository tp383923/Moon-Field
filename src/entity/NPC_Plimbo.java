package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Plimbo extends Entity {
	
	
	public NPC_Plimbo(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Howdy. I'm Plimbo.\nWelcome to the Moon Field.";
		dialogues[0][1] = "What is this game about? I dunno.\nIs this even a game?";
		dialogues[0][2] = "Games are supposed to entertain. Are you entertained?\nCome to think, this game isn't even finished.";
		dialogues[0][3] = "Well, maybe it doesn't matter anymore. You're here now,\nand that's what counts.";
		dialogues[0][4] = "Make sure to kill monsters and get keys to\nopen doors, that's how you survive here.\nExplore enough and you"
				+ "'ll reach a dungeon.";
		dialogues[0][5] = "Once there, you can progress to find the boss."
				+ "\nKill it, get your ending, and leave this place.";
		dialogues[0][6] = "What did it do to deserve such a fate? Does it matter?\nIt was born to fall at your hand.";
		dialogues[0][7] = "This world is a meaningless, unfinished mess.\nA game for game's sake.\nTruly dangerous, and truly terrifying.";
		dialogues[0][8] = "Or maybe that's just the ramblings of a small bear.\nEither way, it doesn't matter. Anyways...";
		dialogues[0][9] = "Good luck Mr. Stick Figure dude, stay chillin.";
		
		
		dialogues[1][0] = "Sorry mate, I'm not repeating what I said.\nWhy? The same reason I'm not animated like everyone\nelse, that's way too much effort.";
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
			dialogueSet = 1;
		}
		
		// SPECIAL DIALOGUE IF LOW HEALTH
//		if (gp.player.life < gp.player.maxLife/3) {
//			dialogueSet = 1;
//		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Plimbo",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   