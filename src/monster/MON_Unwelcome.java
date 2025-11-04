package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;
import object.OBJ_Moonball;

public class MON_Unwelcome extends Entity{

	GamePanel gp;
	
	public MON_Unwelcome(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Unwelcome";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 15; 
		life = maxLife;
		attack = 4;
		defense = 0;
		exp = 5;
		
		solidArea.x = 2;
		solidArea.y = 5;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		up1 = setUp("/monster/Monster3_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/monster/Monster3_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/monster/Monster3_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/monster/Monster3_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/monster/Monster3_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/monster/Monster3_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/monster/Monster3_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/monster/Monster3_Down_2",gp.tileSize,gp.tileSize);
	}

	public void setAction() {
		if (onPath) {
			// CHECK CHASING
			checkStopChasing(gp.player, 15, 100);
			// FOLLOW PLAYER
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
			
		} else {
			checkStartChasing(gp.player, 5, 100);
			getRandomDirection(200);
		}
	}
	
	public void damageReaction() {
		actionLockCounter = 0;
	 // direction = gp.player.direction;
		onPath = true;
	}
	
	public void checkDrop() {
		dropItem(new OBJ_Heart(gp));
	}
}
