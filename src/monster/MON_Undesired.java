package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;
import object.OBJ_Moonball;

public class MON_Undesired extends Entity{

	GamePanel gp;
	
	public MON_Undesired(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Undesired";
		defaultSpeed = 2;
		speed = defaultSpeed;
		maxLife = 20; 
		life = maxLife;
		attack = 7;
		defense = 2;
		exp = 10;
		
		solidArea.x = 2;
		solidArea.y = 5;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		up1 = setUp("/monster/Monster4_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/monster/Monster4_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/monster/Monster4_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/monster/Monster4_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/monster/Monster4_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/monster/Monster4_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/monster/Monster4_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/monster/Monster4_Down_2",gp.tileSize,gp.tileSize);
	}

	public void setAction() {
		getRandomDirection(10);
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
