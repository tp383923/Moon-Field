package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Jonco extends Entity {
	
	
	public NPC_Jonco(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		
		getImage();	
		setDialogue();
		
		dialogueSet = -1;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "GREETINGS GREAT HERO, WHO HATH FALLEN FROM THE STARS.\nYOUR BLAZE OF GLORY WILL NOT SOON BE FORGOTTEN.\nAS A HUMBLE SERVANT, I PRESENT YOUR QUEST!";
		dialogues[0][1] = "THIS WORLD HAS FALLEN INTO CHAOS! IT IS AN APPALLING AMALGAM\nOF WORLDS SMASHED TOGETHER.\nIN ORDER TO GIVE MORE POWER TO THE SCOURGE OF THIS LAND.";
		dialogues[0][2] = "YOU MUST COLLECT THE THREE KEYS FROM THE THREE REALMS\nIN ORDER TO REACH THE SCOURGE THAT LIES\nBEYOND A GLITCHY HELLSCAPE.";
		dialogues[0][3] = "LOOK FOR STRANGE ANOMALIES IN THE GRASS.\nTHOSE ARE THE PORTALS TO OTHER REALMS.";
		dialogues[0][4] = "THAT IS YOUR QUEST HERO. DO US PROUD.";
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
		
		up1 = setUp("/npc/Jonco_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Jonco_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Jonco_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Jonco_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Jonco_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Jonco_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Jonco_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Jonco_Down_2",gp.tileSize,gp.tileSize);
		
	}
	
	
}
   