package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;
import object.OBJ_Moonball;

public class MON_Batter extends Entity {
	GamePanel gp;
	
	public MON_Batter(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Batter";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 7; 
		life = maxLife;
		attack = 3;
		defense = 2;
		exp = 10;
		motion1_duration = 40;
		motion2_duration = 85;
		knockBackPower = 2;
		
		solidArea.x = 4;
		solidArea.y = 4;
		solidArea.width = 40;
		solidArea.height = 44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		attackArea.height = 48;
		attackArea.width = 48;
		
		getImage();
		getAttackImage();
	}
	
	public void getImage() {
		up1 = setUp("/monster/Monster2_Up_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/monster/Monster2_Up_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/monster/Monster2_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/monster/Monster2_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/monster/Monster2_Right_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/monster/Monster2_Right_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/monster/Monster2_Left_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/monster/Monster2_Left_2",gp.tileSize,gp.tileSize);
	}
	
	public void getAttackImage () {
		attackUp1 = setUp("/monster/Monster2_Attack_Up_1",gp.tileSize,gp.tileSize*2); 
		attackUp2 = setUp("/monster/Monster2_Attack_Up_2",gp.tileSize,gp.tileSize*2); 
		attackDown1 = setUp("/monster/Monster2_Attack_Down_1",gp.tileSize,gp.tileSize*2); 
		attackDown2 = setUp("/monster/Monster2_Attack_Down_2",gp.tileSize,gp.tileSize*2); 
		attackLeft1 = setUp("/monster/Monster2_Attack_Right_1",gp.tileSize*2,gp.tileSize); 
		attackLeft2 = setUp("/monster/Monster2_Attack_Right_2",gp.tileSize*2,gp.tileSize); 
		attackRight1 = setUp("/monster/Monster2_Attack_Left_1",gp.tileSize*2,gp.tileSize); 
		attackRight2 = setUp("/monster/Monster2_Attack_Left_2",gp.tileSize*2,gp.tileSize); 

	}

	public void setAction() {
		if (onPath) {
			// CHECK CHASING
			checkStopChasing(gp.player, 15, 100);
			// FOLLOW PLAYER
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
			
		} else {
			checkStartChasing(gp.player, 5, 100);
			getRandomDirection(100);
		}
		
		// CHECK IF IT ATTACKS
		if (!attacking) {
			checkAttack(30, gp.tileSize*4, gp.tileSize);
		}
	}
	
	public void damageReaction() {
		actionLockCounter = 0;
	 // direction = gp.player.direction;
		onPath = true;
	}
	
	public void checkDrop() {
		// ROLL A DIE
		int i = new Random().nextInt(100) + 1;
		
		// SET MONSTER DROP
		if(i < 50) {
			dropItem(new OBJ_Moon_Coin(gp));
		}
		if (i >= 50 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		} 
		if (i >= 75 && i < 100) {
			dropItem(new OBJ_Energy(gp));
		}
	}	
}
