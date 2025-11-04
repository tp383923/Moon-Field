package monster;

import java.util.Random;

import data.Progress;
import entity.Entity;
import main.GamePanel;
import object.OBJ_Door_Dark;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;

public class MON_ForgetMeNaut extends Entity {
GamePanel gp;
public static final String monName = "Forget-Me-Naut";
	
	public MON_ForgetMeNaut(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		boss = true;
		name = monName;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 200; 
		life = maxLife;
		attack = 10;
		defense = 3;
		exp = 50;
		motion1_duration = 25;
		motion2_duration = 50;
		knockBackPower = 5;
		sleep = true;
		
		int size = gp.tileSize*5;
		solidArea.x = 48;
		solidArea.y = 48;
		solidArea.width = size - 48*2;
		solidArea.height = size - 48;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		attackArea.height = 170;
		attackArea.width = 170;
		
		getImage();
		getAttackImage();
		setDialogue();
	}
	
	public void getImage() {
		
		int i = 5;
		
		if (inRage) {
			up1 = setUp("/monster/ForgetMeNaut_Up_1",gp.tileSize*i,gp.tileSize*i);
			up2 = setUp("/monster/ForgetMeNaut_Up_2",gp.tileSize*i,gp.tileSize*i);
			down1 = setUp("/monster/ForgetMeNaut_Phase2_Down_1",gp.tileSize*i,gp.tileSize*i);
			down2 = setUp("/monster/ForgetMeNaut_Phase2_Down_2",gp.tileSize*i,gp.tileSize*i);
			left1 = setUp("/monster/ForgetMeNaut_Phase2_Right_1",gp.tileSize*i,gp.tileSize*i);
			left2 = setUp("/monster/ForgetMeNaut_Phase2_Right_2",gp.tileSize*i,gp.tileSize*i);
			right1 = setUp("/monster/ForgetMeNaut_Left_1",gp.tileSize*i,gp.tileSize*i);
			right2 = setUp("/monster/ForgetMeNaut_Left_2",gp.tileSize*i,gp.tileSize*i);	
		} else {
			up1 = setUp("/monster/ForgetMeNaut_Up_1",gp.tileSize*i,gp.tileSize*i);
			up2 = setUp("/monster/ForgetMeNaut_Up_2",gp.tileSize*i,gp.tileSize*i);
			down1 = setUp("/monster/ForgetMeNaut_Down_1",gp.tileSize*i,gp.tileSize*i);
			down2 = setUp("/monster/ForgetMeNaut_Down_2",gp.tileSize*i,gp.tileSize*i);
			left1 = setUp("/monster/ForgetMeNaut_Right_1",gp.tileSize*i,gp.tileSize*i);
			left2 = setUp("/monster/ForgetMeNaut_Right_2",gp.tileSize*i,gp.tileSize*i);
			right1 = setUp("/monster/ForgetMeNaut_Left_1",gp.tileSize*i,gp.tileSize*i);
			right2 = setUp("/monster/ForgetMeNaut_Left_2",gp.tileSize*i,gp.tileSize*i);
		}
	}
	
	public void getAttackImage () {
		
		int i = 5;
		
		if (inRage) {
			attackUp1 = setUp("/monster/ForgetMeNaut_Attack_Up_1",gp.tileSize*i,gp.tileSize*i*2); 
			attackUp2 = setUp("/monster/ForgetMeNaut_Attack_Up_2",gp.tileSize*i,gp.tileSize*i*2); 
			attackDown1 = setUp("/monster/ForgetMeNaut_Phase2_Attack_Down_1",gp.tileSize*i,gp.tileSize*i*2); 
			attackDown2 = setUp("/monster/ForgetMeNaut_Phase2_Attack_Down_2",gp.tileSize*i,gp.tileSize*i*2); 
			attackLeft1 = setUp("/monster/ForgetMeNaut_Phase2_Attack_Right_1",gp.tileSize*i*2,gp.tileSize*i); 
			attackLeft2 = setUp("/monster/ForgetMeNaut_Phase2_Attack_Right_2",gp.tileSize*i*2,gp.tileSize*i); 
			attackRight1 = setUp("/monster/ForgetMeNaut_Attack_Left_1",gp.tileSize*i*2,gp.tileSize*i); 
			attackRight2 = setUp("/monster/ForgetMeNaut_Attack_Left_2",gp.tileSize*i*2,gp.tileSize*i); 

		} else {
			attackUp1 = setUp("/monster/ForgetMeNaut_Attack_Up_1",gp.tileSize*i,gp.tileSize*i*2); 
			attackUp2 = setUp("/monster/ForgetMeNaut_Attack_Up_2",gp.tileSize*i,gp.tileSize*i*2); 
			attackDown1 = setUp("/monster/ForgetMeNaut_Attack_Down_1",gp.tileSize*i,gp.tileSize*i*2); 
			attackDown2 = setUp("/monster/ForgetMeNaut_Attack_Down_2",gp.tileSize*i,gp.tileSize*i*2); 
			attackLeft1 = setUp("/monster/ForgetMeNaut_Attack_Right_1",gp.tileSize*i*2,gp.tileSize*i); 
			attackLeft2 = setUp("/monster/ForgetMeNaut_Attack_Right_2",gp.tileSize*i*2,gp.tileSize*i); 
			attackRight1 = setUp("/monster/ForgetMeNaut_Attack_Left_1",gp.tileSize*i*2,gp.tileSize*i); 
			attackRight2 = setUp("/monster/ForgetMeNaut_Attack_Left_2",gp.tileSize*i*2,gp.tileSize*i); 
	
		}
	}

	public void setAction() {
		if (inRage == false && life < maxLife/2) {
			inRage = true;
			getImage();
			getAttackImage();
			defaultSpeed++;
			speed = defaultSpeed;
			attack *= 2;
		}
		
		if (getTileDistance(gp.player) < 10) {
			moveTowardPlayer(60);
		} else {
			getRandomDirection(120);
		}
		
		// CHECK IF IT ATTACKS
		if (!attacking) {
			checkAttack(60, gp.tileSize*7, gp.tileSize*5);
		}
	}
	
	public void damageReaction() {
		actionLockCounter = 0;
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Greetings, \"Hero\". I am the \"Scourge of this Land\".\nHave you come to kill me?";
		dialogues[0][1] = "Good. I was made to fight you. This whole world\nexists for no other purpose than your entertainment.\nI exist to be your final obstacle.";
		dialogues[0][2] = "Maybe I am a monster because I was meant to fight you.\nMaybe I was meant to fight you because I am a monster.";
		dialogues[0][3] = "Truth be told, I really don't care.\nI'll kill you regardless.\nAs many times as I have to.";
		dialogues[0][4] = "Just remember, when I end your life, that you did this to me.";
	}
	
	public void checkDrop() {
		gp.bossBattleOn = false;
		Progress.forgetMeNautDefeated = true;
		gp.stopMusic();
		gp.playMusic(18);
		for (int i = 0; i < gp.obj[1].length; i++) {
			if (gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Door_Dark.objName)) {
				gp.playerSE(20);
				gp.obj[gp.currentMap][i] = null;
			}
		}
		
	}	
}
