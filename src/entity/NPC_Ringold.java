package entity;


import java.util.Random;

import data.Progress;
import main.GamePanel;


public class NPC_Ringold extends Entity {
	
	
	public NPC_Ringold(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Greetings Alien. I am called Ringold.\nI have heard of your escapades. \nYou are a wanted criminal are you not?";
		dialogues[0][1]	= "Rumor has it that you have wandered\ntime and space, causing mischief.";
		dialogues[0][2] = "And for what purpose? Are you bored? Are you lonely?\nAre you looking for something that's gone missing,\nin turn losing more of yourself?"
				+ "\nWell it doesn't matter too much.";
		dialogues[0][3] = "Sinner or saint, you are trapped here with no way out.";
		dialogues[0][4] = "Pardon me for being cynical.\nThis place tends to have that affect.\nThank you for humoring an old soul for a bit. Have a day.";
		
		dialogues[1][0] = "I would say your days are numbered,\n"
				+ "but with all your spacetime shenanigans,\nyou may never be held accountable.\nUnless you willingly stop running, and go home.";
		
		dialogues[2][0] = "So you have defeated the scourge of this land. As expected.\n"
				+ "Yet, you are still here. Is your search poetic? Or are you delusional?";
		dialogues[2][1]	= "Surely you would know by now, this world has nothing left for you.\nNeither the next world either. You know what must be done.";
	}
	
	public void setAction() {
	}
	
	public void speak() {
		//do this character specific stuff
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		if (dialogueSet == 2) {
			dialogueSet = 1;
		}
		
		// SPECIAL DIALOGUE IF BOSS DEFEATED
		if (Progress.forgetMeNautDefeated) {
			dialogueSet = 2;
		}
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Ringold_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Ringold_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Ringold_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Ringold_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Ringold_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Ringold_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Ringold_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Ringold_Down_2",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   