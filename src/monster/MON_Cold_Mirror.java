package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Blue_Key;
import object.OBJ_Chocolate;
import object.OBJ_Energy;
import object.OBJ_Heart;
import object.OBJ_Moon_Coin;
import object.OBJ_Moonball;

public class MON_Cold_Mirror extends Entity{

	GamePanel gp;
	
	public MON_Cold_Mirror(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Cold Mirror";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 20; 
		life = maxLife;
		attack = 5;
		defense = 5;
		exp = 12;
		
		int size = gp.tileSize * 2;
		solidArea.x = 48;
		solidArea.y = 48;
		solidArea.width = size - 48*2;
		solidArea.height = size - 48;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		
		int i = 2;
		up1 = setUp("/monster/Cold_Mirror_Down_1",gp.tileSize*i,gp.tileSize*i);
		up2 = setUp("/monster/Cold_Mirror_Down_2",gp.tileSize*i,gp.tileSize*i);
		down1 = setUp("/monster/Cold_Mirror_Down_1",gp.tileSize*i,gp.tileSize*i);
		down2 = setUp("/monster/Cold_Mirror_Down_2",gp.tileSize*i,gp.tileSize*i);
		left1 = setUp("/monster/Cold_Mirror_Down_1",gp.tileSize*i,gp.tileSize*i);
		left2 = setUp("/monster/Cold_Mirror_Down_2",gp.tileSize*i,gp.tileSize*i);
		right1 = setUp("/monster/Cold_Mirror_Down_1",gp.tileSize*i,gp.tileSize*i);
		right2 = setUp("/monster/Cold_Mirror_Down_2",gp.tileSize*i,gp.tileSize*i);
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
		dropItem(new OBJ_Blue_Key(gp));
	}
}
