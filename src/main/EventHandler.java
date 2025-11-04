package main;

import data.Progress;
import entity.Entity;

public class EventHandler {
	GamePanel gp; 
	EventRect eventRect[][][]; 
	Entity eventMaster;
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventMaster = new Entity(gp);
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col =0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 10;
			eventRect[map][col][row].height = 10;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if (row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
		setDialogue();
	}
	
	public void setDialogue() {
		eventMaster.dialogues[0][0] = "There is an invisible man here.\nHe punches you.";
		eventMaster.dialogues[1][0] = "The Invisible Man is kind of confused\nas to why you wanna get punched again.";
		eventMaster.dialogues[2][0] = "You drink some toxic moon waste.\nTastes yummy! HP and Energy Restored.\n(Progress Saved)";
	}
	
	public void checkEvent() {
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if (distance > gp.tileSize) {
			canTouchEvent = true;
		}
		
		if (canTouchEvent) {
			if(hit(0, 29, 18, "up") == true) { damagePit(0, 29, 18, gp.dialogueState); } 
			
			// HEALING POOL
			else if(hit(0, 23, 6, "up") == true) { healingPool(gp.dialogueState); }
			
			// TRADER
			else if(hit(0, 13, 38, "any") == true) { teleport(1, 11, 11, gp.indoor); }
			else if(hit(1, 11, 11, "any") == true) { teleport(0, 13, 38, gp.outside); }
			
			// INVISIBLE MAN
			else if (hit(1, 11, 9, "up") == true) {speak(gp.npc[1][0]);}
			
			// CHURCH
			else if(hit(0, 13, 42, "any") == true) { teleport(2, 5, 6, gp.dungeon); }
			else if(hit(2, 5, 6, "any") == true) { teleport(0, 13, 42, gp.outside); }
			
			// VALLEY
			else if(hit(0, 48, 42, "any") == true) { teleport(7, 20, 37, gp.valley); }
			else if(hit(7, 20, 37, "any") == true) { teleport(0, 48, 42, gp.outside); }
			
			// BIRDS
			else if(hit(0, 20, 12, "any") == true) { teleport(6, 10, 15, gp.birds); }
			else if(hit(6, 10, 15, "any") == true) { teleport(0, 20, 12, gp.outside); }
			
			// SNOW
			else if(hit(0, 8, 13, "any") == true) { teleport(5, 8, 13, gp.snow); }
			else if(hit(5, 8, 13, "any") == true) { teleport(0, 8, 13, gp.outside); }
			
			// DUNGEON
			else if(hit(2, 27, 13, "any") == true) { teleport(3, 6, 46, gp.boss); }
			else if(hit(3, 6, 46, "any") == true) { teleport(2, 27, 13, gp.dungeon); }
			
			// BOSS ARENA
			else if(hit(3, 7, 21, "any") == true) { teleport(4, 20, 44, gp.boss); }
			else if(hit(4, 20, 44, "any") == true) { teleport(3, 7, 21, gp.boss); }
			
			// BOSS FIGHT
			else if(hit(4, 20, 40, "any") == true) { boss(); }
		}
	}
	
	public void damagePit(int map, int col, int row, int gameState) {
		if(eventRect[map][col][row].eventDone == false) {
		gp.gameState = gameState;
		gp.playerSE(6);
		eventMaster.startDialogue(eventMaster, 0);
		gp.player.life -= 1; 
		eventRect[map][col][row].eventDone = true;
		}
		else {
			gp.gameState = gameState;
			eventMaster.startDialogue(eventMaster, 1);
			eventRect[map][col][row].eventDone = true;
		}
		
	}
	
	public void teleport(int map, int col, int row, int area) {
		gp.gameState = gp.transitionState;
		gp.nextArea = area;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		canTouchEvent = false;
		gp.playerSE(13);
	}
	
	public boolean hit(int map, int col, int row, String reqDirection) {
		boolean hit = false;
		
		if (map == gp.currentMap) {
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
			
			if(gp.player.solidArea.intersects(eventRect[map][col][row])) {
				if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
					hit = true;
				}
			}
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;	
		}

		return hit;	
	}
	
	public void healingPool(int gameState) {
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.attackCanceled = true;
			gp.playerSE(2);
			eventMaster.startDialogue(eventMaster, 2);
			gp.player.life = gp.player.maxLife;
			gp.player.energy = gp.player.maxEnergy;
			gp.aSetter.setMonster();
			gp.saveLoad.save();
		}
	}
	
	public void speak(Entity entity) {
		if (gp.keyH.enterPressed == true) {
			gp.gameState = gp.dialogueState;
			gp.player.attackCanceled = true;
			entity.speak();
		}
	}
	
	public void boss() {
		if (gp.bossBattleOn == false && !Progress.forgetMeNautDefeated) {
			gp.gameState = gp.cutsceneState;
			gp.csManager.sceneNum = gp.csManager.forgetMeNaut;
		}
	}
	
	
}
