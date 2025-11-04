package entity;

import main.GamePanel;

public class PlayerDummy extends Entity {

	public static final String npcName = "Dummy";
	
	public PlayerDummy(GamePanel gp) {
		super(gp);
		name = npcName;
		getPlayerImage();
	}

	public void getPlayerImage() {
		up1 = setUp("/player/EG_Up_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/player/EG_Up_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/player/EG_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/player/EG_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/player/EG_Left_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/player/EG_Left_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/player/EG_Right_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/player/EG_Right_2",gp.tileSize,gp.tileSize);
	}
	
}
