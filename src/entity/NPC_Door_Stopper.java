package entity;

import java.awt.Rectangle;
import java.util.ArrayList;

import main.GamePanel;
import object.OBJ_Door_Dark;
import tiles_interactive.IT_MetalPlate;
import tiles_interactive.InteractiveTile;

public class NPC_Door_Stopper extends Entity {

	public static final String npcName = "Door Stopper Rock";
	
	public NPC_Door_Stopper(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		name = npcName;
		
		solidArea = new Rectangle();
		solidArea.x = 2;
		solidArea.y = 6;
		solidArea.width = 44;
		solidArea.height = 40;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		dialogueSet = -1;
		
		getImage();	
		setDialogue();
	}
	
	public void setDialogue() {
		dialogues[0][0] = "This rock looks suspicious.\nIt keeps eyeing the pressure plates\nlittered around the dungeon.";
	}
	
	public void update() {}
	
	public void setAction() {}
	
	public void speak() {
		//do this character specific stuff
		facePlayer();
		startDialogue(this, dialogueSet); 
		dialogueSet++;
		if (dialogues[dialogueSet][0] == null) {
			dialogueSet--;
		}
		
		// SPECIAL DIALOGUE IF LOW HEALTH
//		if (gp.player.life < gp.player.maxLife/3) {
//			dialogueSet = 1;
//		}
	}
	
	public void move(String d) {
		this.direction = d;
		
		checkCollision();
		if(collisionOn == false) {
			switch(direction) {
			case"up": worldY -= speed; break;
			case"down": worldY += speed; break;
			case"left":	worldX -= speed; break;
			case"right": worldX += speed; break;
			}
		}
		
		detectPlate();
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Door_Stopper",gp.tileSize,gp.tileSize);
		
	}
	
	public void detectPlate() {
		ArrayList<InteractiveTile> plateList = new ArrayList<>();
		ArrayList<Entity> rockList = new ArrayList<>();
		
		// PLATE LIST
		for(int i = 0; i < gp.iTile[1].length; i++) {
			if (gp.iTile[gp.currentMap][i] != null 
					&& gp.iTile[gp.currentMap][i].name != null 
					&& gp.iTile[gp.currentMap][i].name.equals(IT_MetalPlate.itName)) {
				plateList.add(gp.iTile[gp.currentMap][i]);
			}
		}
		
		// ROCK LIST
		for(int i = 0; i < gp.npc[1].length; i++) {
			if (gp.npc[gp.currentMap][i] != null 
					&& gp.npc[gp.currentMap][i].name.equals(NPC_Door_Stopper.npcName)) {
				rockList.add(gp.npc[gp.currentMap][i]);
			}
		}
		
		int count = 0;
		
		// SCAN PLATE LIST
		for (int i = 0; i < plateList.size(); i++) {
			int xDistance = Math.abs(worldX - plateList.get(i).worldX); 
			int yDistance = Math.abs(worldY - plateList.get(i).worldY);
			int distance = Math.max(xDistance, yDistance);
			
			if (distance < 8) {
				if (linkedEntity == null) {
					linkedEntity = plateList.get(i);
					gp.playerSE(3);	
				}
			}
			else {
				if (linkedEntity == plateList.get(i)) {
					linkedEntity = null;	
				}
			}
		}
		
		// SCAN ROCK LIST
		for (int i = 0; i < rockList.size(); i++) {
			if (rockList.get(i).linkedEntity != null) {
				count++;
			}
		}
		
		// CHECK DARK DOOR OPENING 
		if (count == rockList.size()) {
			for (int i = 0; i < gp.obj[1].length; i++) {
				if (gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Door_Dark.objName)) {
					gp.obj[gp.currentMap][i] = null;
					gp.playerSE(20);
				}
			}
		}
		
	}
	
}
