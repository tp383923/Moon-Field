package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
	
	GamePanel gp;
	public static final String objName = "Heart";
	
	public OBJ_Heart(GamePanel gp) {
		super(gp); 
		this.gp = gp;
		
		type = type_pickup_only;
		name = objName;
		value = 2;
		down1 = setUp("/objects/heart_full",gp.tileSize,gp.tileSize);
		image = setUp("/objects/heart_full",gp.tileSize,gp.tileSize);
		image2 = setUp("/objects/heart_half",gp.tileSize,gp.tileSize);
		image3 = setUp("/objects/heart_empty",gp.tileSize,gp.tileSize);
		
	}
	
	public boolean use(Entity entity) {
		gp.playerSE(2);
		gp.ui.showMessage("Life +" + value);
		entity.life += value;
		return true;
	}
}
