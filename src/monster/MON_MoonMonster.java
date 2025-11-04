package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;
import object.OBJ_Moonball;

public class MON_MoonMonster extends Entity{

	GamePanel gp;
	
	public MON_MoonMonster(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Moon Monster";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 5; 
		life = maxLife;
		attack = 3;
		defense = 0;
		exp = 2;
		projectile = new OBJ_Moonball(gp);
		
		solidArea.x = 2;
		solidArea.y = 5;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		up1 = setUp("/monster/Monster1_down1",gp.tileSize,gp.tileSize);
		up2 = setUp("/monster/Monster1_down2",gp.tileSize,gp.tileSize);
		down1 = setUp("/monster/Monster1_down1",gp.tileSize,gp.tileSize);
		down2 = setUp("/monster/Monster1_down2",gp.tileSize,gp.tileSize);
		left1 = setUp("/monster/Monster1_down1",gp.tileSize,gp.tileSize);
		left2 = setUp("/monster/Monster1_down2",gp.tileSize,gp.tileSize);
		right1 = setUp("/monster/Monster1_down1",gp.tileSize,gp.tileSize);
		right2 = setUp("/monster/Monster1_down2",gp.tileSize,gp.tileSize);
	}

	public void setAction() {
		if (onPath) {
			// CHECK CHASING
			checkStopChasing(gp.player, 15, 100);
			// FOLLOW PLAYER
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
			// CHECK SHOOTING
			checkShoot(200, 30); 
			
		} else {
			checkStartChasing(gp.player, 5, 100);
			getRandomDirection(120);
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
