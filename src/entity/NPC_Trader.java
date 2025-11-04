package entity;

import java.util.Random;

import main.GamePanel;
import object.OBJ_Ash_Glove;
import object.OBJ_Chocolate;
import object.OBJ_Key;
import object.OBJ_Moon_Tree_Shield;
import object.OBJ_Shield_Cardboard;
import object.OBJ_Socks;
import object.OBJ_Weapon_Normal;

public class NPC_Trader extends Entity {
	public NPC_Trader(GamePanel gp) {
		super(gp);
		
		direction = "down";
		
		getImage();	
		setDialogue();
		setItems();
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Traveler. You come to the wreckage of our world,\ndestroy our flora and fauna,"
				+ " loot all you see, unknowing the\ntreasures you take were those of my fallen comrades, "
				+ "\nand you still expect me to give you more?";
		dialogues[1][0] = "Hehe...\nSure, why not? Take more.\nGo forth and destroy, traveler.";
		dialogues[2][0] = "You lack the coins for that item.";
		dialogues[3][0] = "You cannot carry anything more.";
		dialogues[4][0] = "You cannot sell equipped items.";
	}
	
	public void speak() {
		facePlayer();
			gp.gameState = gp.tradeState;
			gp.ui.npc = this;	
	}
	
	public void getImage() {
		
		up1 = setUp("/npc/Trader_Down_1",gp.tileSize,gp.tileSize);
		up2 = setUp("/npc/Trader_Down_2",gp.tileSize,gp.tileSize);
		down1 = setUp("/npc/Trader_Down_1",gp.tileSize,gp.tileSize);
		down2 = setUp("/npc/Trader_Down_2",gp.tileSize,gp.tileSize);
		left1 = setUp("/npc/Trader_Down_1",gp.tileSize,gp.tileSize);
		left2 = setUp("/npc/Trader_Down_2",gp.tileSize,gp.tileSize);
		right1 = setUp("/npc/Trader_Down_1",gp.tileSize,gp.tileSize);
		right2 = setUp("/npc/Trader_Down_2",gp.tileSize,gp.tileSize);
		
	}
	
	public void setItems() {
		inventory.add(new OBJ_Chocolate(gp));
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Ash_Glove(gp));
		inventory.add(new OBJ_Shield_Cardboard(gp));
		inventory.add(new OBJ_Moon_Tree_Shield(gp));
		inventory.add(new OBJ_Socks(gp));
	}
 }
