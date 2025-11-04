package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Key;
import object.OBJ_Plasma_Ball;
import object.OBJ_Shield_Cardboard;
import object.OBJ_Weapon_Normal;

public class Player extends Entity{

	 
	KeyHandler keyH;
	//public int hasKey = 0;  
	public final int screenX;
	public final int screenY;
	int standCounter = 0;
	public boolean lightUpdated = false;
	public boolean attackCanceled = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp); //calls superclass constructor
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize/2);
		screenY = gp.screenHeight / 2 - (gp.tileSize/2);
		
		solidArea = new Rectangle(15, 18, 18, 27); //6x9 Hit Box
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		attackArea.width = 36;
		attackArea.height = 36; 
		
		setDefaultValues();
	}
	
	public void setDefaultPositions() {
		gp.currentMap = 0;
		worldX = gp.tileSize * 23; //23 
		worldY = gp.tileSize * 21; //21
		direction = "down";
	}
	
	public void restoreLifeAndEnergy() {
		life = maxLife;
 		energy = maxEnergy;
 		speed = defaultSpeed;
		invincible = false;
		transparent = false;
		attacking = false;
		guarding = false;
		knockBack = false;
		lightUpdated = true;
	}
	
	public void setDefaultValues() {
		// Starting Coordinates for First Map
		worldX = gp.tileSize * 23; 
		worldY = gp.tileSize * 21; 
		// Starting Coordinates for Hut Map
		//worldX = gp.tileSize * 11; 
		//worldY = gp.tileSize * 11;
		// Starting Coordinates for Dungeon Map
//		worldX = gp.tileSize * 8; //23 
//		worldY = gp.tileSize * 46; //21
		// Starting Coordinates for Boss Map
//		worldX = gp.tileSize * 20; //23 
//		worldY = gp.tileSize * 44; //21
		defaultSpeed = 4;
		speed = defaultSpeed;
		direction = "down";
		
		//PLAYER STATUS
		level = 1;
		strength = 1; // Greater strength = stronger attacks
		dexterity = 1; // Greater Dexterity = Less Damage Taken
		exp = 0;
		nextLevelExp =  5;
		coin = 0;
		currentWeapon = new OBJ_Weapon_Normal(gp);
		currentShield = new OBJ_Shield_Cardboard(gp);
		currentLight = null;
		projectile = new OBJ_Plasma_Ball(gp);
		attack = getAttack();
		defense = getDefense();
		maxLife = 6; // 3 Hearts
		life = maxLife;
		maxEnergy = 4;
		energy = maxEnergy;
		
		getPlayerImage();
		getPlayerAttackImage();
		getGuardImage();
		setItems();
		setDialogue();
	}
	
	public void setItems() {
		inventory.clear();
		inventory.add(currentWeapon);
		inventory.add(currentShield);
		inventory.add(new OBJ_Key(gp));
	}
	
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		motion1_duration = currentWeapon.motion1_duration;
		motion2_duration = currentWeapon.motion2_duration;
		return attack = strength * currentWeapon.attackValue;
	}
 
	public int getDefense() {
		return defense = dexterity * currentShield.defenseValue;
	}
	
	public int getCurrentWeaponSlot() {
		int currentWeaponSlot = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) == currentWeapon) {
				currentWeaponSlot = i;
			}
		}
		return currentWeaponSlot;
	}
	
	public int getCurrentShieldSlot() {
		int currentShieldSlot = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) == currentShield) {
				currentShieldSlot = i;
			}
		}
		return currentShieldSlot;
	}
	
	public int getCurrentLightSlot() {
		int currentLightSlot = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) == currentLight) {
				currentLightSlot = i;
			}
		}
		return currentLightSlot;
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
 
	public void getPlayerAttackImage() {
		if (currentWeapon.type == type_fist) {
			attackUp1 = setUp("/player/EG_Attack_Up_1",gp.tileSize,gp.tileSize*2); 
			attackUp2 = setUp("/player/EG_Attack_Up_2",gp.tileSize,gp.tileSize*2); 
			attackDown1 = setUp("/player/EG_Attack_Down_1",gp.tileSize,gp.tileSize*2); 
			attackDown2 = setUp("/player/EG_Attack_Down_2",gp.tileSize,gp.tileSize*2); 
			attackLeft1 = setUp("/player/EG_Attack_Left_1",gp.tileSize*2,gp.tileSize); 
			attackLeft2 = setUp("/player/EG_Attack_Left_2",gp.tileSize*2,gp.tileSize); 
			attackRight1 = setUp("/player/EG_Attack_Right_1",gp.tileSize*2,gp.tileSize); 
			attackRight2 = setUp("/player/EG_Attack_Right_2",gp.tileSize*2,gp.tileSize); 
		}
		if (currentWeapon.type == type_ash_glove) {
			attackUp1 = setUp("/player/EG_Sludge_Glove_Up_1",gp.tileSize,gp.tileSize*2); 
			attackUp2 = setUp("/player/EG_Sludge_Glove_Up_2",gp.tileSize,gp.tileSize*2); 
			attackDown1 = setUp("/player/EG_Sludge_Glove_Down_1",gp.tileSize,gp.tileSize*2); 
			attackDown2 = setUp("/player/EG_Sludge_Glove_Down_2",gp.tileSize,gp.tileSize*2); 
			attackLeft1 = setUp("/player/EG_Sludge_Glove_Left_1",gp.tileSize*2,gp.tileSize); 
			attackLeft2 = setUp("/player/EG_Sludge_Glove_Left_2",gp.tileSize*2,gp.tileSize); 
			attackRight1 = setUp("/player/EG_Sludge_Glove_Right_1",gp.tileSize*2,gp.tileSize); 
			attackRight2 = setUp("/player/EG_Sludge_Glove_Right_2",gp.tileSize*2,gp.tileSize); 
		}
		if (currentWeapon.type == type_socks) {
			attackUp1 = setUp("/player/EG_Socks_Up_1",gp.tileSize,gp.tileSize*2); 
			attackUp2 = setUp("/player/EG_Socks_Up_2",gp.tileSize,gp.tileSize*2); 
			attackDown1 = setUp("/player/EG_Socks_Down_1",gp.tileSize,gp.tileSize*2); 
			attackDown2 = setUp("/player/EG_Socks_Down_2",gp.tileSize,gp.tileSize*2); 
			attackLeft1 = setUp("/player/EG_Socks_Left_1",gp.tileSize*2,gp.tileSize); 
			attackLeft2 = setUp("/player/EG_Socks_Left_2",gp.tileSize*2,gp.tileSize); 
			attackRight1 = setUp("/player/EG_Socks_Right_1",gp.tileSize*2,gp.tileSize); 
			attackRight2 = setUp("/player/EG_Socks_Right_2",gp.tileSize*2,gp.tileSize); 
		}
		if (currentWeapon.type == type_boxing_glove) {
			attackUp1 = setUp("/player/EG_Boxing_Glove_Up_1",gp.tileSize,gp.tileSize*2); 
			attackUp2 = setUp("/player/EG_Boxing_Glove_Up_2",gp.tileSize,gp.tileSize*2); 
			attackDown1 = setUp("/player/EG_Boxing_Glove_Down_1",gp.tileSize,gp.tileSize*2); 
			attackDown2 = setUp("/player/EG_Boxing_Glove_Down_2",gp.tileSize,gp.tileSize*2); 
			attackLeft1 = setUp("/player/EG_Boxing_Glove_Left_1",gp.tileSize*2,gp.tileSize); 
			attackLeft2 = setUp("/player/EG_Boxing_Glove_Left_2",gp.tileSize*2,gp.tileSize); 
			attackRight1 = setUp("/player/EG_Boxing_Glove_Right_1",gp.tileSize*2,gp.tileSize); 
			attackRight2 = setUp("/player/EG_Boxing_Glove_Right_2",gp.tileSize*2,gp.tileSize); 
		}
	}
	
	public void update() {
		if (knockBack == true) {
			collisionOn = false;
			gp.eChecker.checkTile(this);
			gp.eChecker.checkObject(this, true);
			gp.eChecker.checkEntity(this, gp.npc);
			gp.eChecker.checkEntity(this, gp.monster);
			gp.eChecker.checkEntity(this, gp.iTile);
			
			if (collisionOn == true) {
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			} else if (collisionOn == false) {
				switch(knockBackDirection) {
				case"up": worldY -= speed; break;
				case"down": worldY += speed; break;
				case"left":	worldX -= speed; break;
				case"right": worldX += speed; break;
				}
			}
			
			knockBackCounter++;
			if (knockBackCounter == 10) {
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
		} else if (attacking) {
			attacking();
		} else if (keyH.spacePressed) {
			guarding = true;
			guardCounter++;
		} else if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			if(keyH.rightPressed == true) {
				direction = "right";
			}
			
			// CHECK TILE COLLISION 
			collisionOn = false;
			gp.eChecker.checkTile(this);
			
			// CHECK OBJ COLLISION 
			int objIndex = gp.eChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// CHECK NPC COLLISION
			int npcIndex = gp.eChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//CHECK MONSTER COLLISION
			int monsterIndex = gp.eChecker.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			// CHECK INTERACTIVE TILE COLLISION 
			int iTileIndex = gp.eChecker.checkEntity(this, gp.iTile);
			
			// CHECK EVENT
			gp.eHandler.checkEvent();
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false && keyH.enterPressed == false) {
				switch(direction) {
				case"up": worldY -= speed; break;
				case"down": worldY += speed; break;
				case"left": worldX -= speed; break;
				case"right": worldX += speed; break;
				}
			}
			
			// CODE CORRECTION
			if (keyH.enterPressed == true && attackCanceled == false) {
				gp.playerSE(7);
				attacking = true;
				spriteCounter = 0;
			}
			
			attackCanceled = false;
			gp.keyH.enterPressed = false; 
			guarding = false;
			guardCounter = 0;
			
			++spriteCounter;
			if(spriteCounter > 14) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1; 
				}
				spriteCounter = 0;
			}
		}
		else {
			standCounter++; 
			if(standCounter == 20) {
				spriteNum = 1;
				standCounter = 0;
			}
			guarding = false;	
			guardCounter = 0;
		}
		
		if (gp.keyH.shotKeyPressed == true && projectile.alive == false 
				&& shotAvailableCounter == 30 && projectile.haveResouce(this) == true) {
			
			// SET DEFAULT COORDINATES, DIRECTION AND USER
			projectile.set(worldX, worldY, direction, true, this);
			
			// SUBTRACT THE COST (MANA/ENERGY)
			projectile.subtractResource(this);
			
			// CHECK VACANCY
			for (int i = 0; i < gp.projectile[1].length; i++) {
				if (gp.projectile[gp.currentMap][i] == null) {
					gp.projectile[gp.currentMap][i] = projectile;
					break;
				}
			}
			
			shotAvailableCounter = 0;
			
			gp.playerSE(10);
		}
		
		// Needs to be outside key if invincible
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false;
				transparent = false;
				
				
				invincibleCounter = 0;
			}
		}
		
		if (shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
		if (life > maxLife) {
			life = maxLife;
		}
		
		if (energy > maxEnergy) {
			energy = maxEnergy;
		}
		if (keyH.godModeOn == false) {
			if (life <= 0) {
				gp.gameState = gp.gameOverState;
				transparent = false;
				gp.ui.commandNum = -1;
				gp.stopMusic();
				gp.playerSE(12);
			}	
		}
		
	}
	
	public void pickUpObject(int i) {
		if(i != 999) {
			// PICKUP ONLY ITEMS
			if (gp.obj[gp.currentMap][i].type == type_pickup_only) {
				 gp.obj[gp.currentMap][i].use(this); 
				 gp.obj[gp.currentMap][i] = null;
			} else if (gp.obj[gp.currentMap][i].type == type_obstacle) {
				// OBSTACLE
				if (keyH.enterPressed == true) {
					attackCanceled = true;
					gp.obj[gp.currentMap][i].interact();
				}
				
			} else {
				// INVENTORY ITEMS
				String text;
				
				if (canObtainItem(gp.obj[gp.currentMap][i])) {
					gp.playerSE(1);
					text = "Got " + gp.obj[gp.currentMap][i].name + ".";
				} else {
					text = "You cannot carry any more.";
				}
				gp.ui.showMessage(text);
				gp.obj[gp.currentMap][i] = null;
			}
		}
	}
	
	public void damageProjectile(int i) {
		if (i != 999) {
			Entity projectile = gp.projectile[gp.currentMap][i];
			projectile.alive = false;
			generateParticle(projectile, projectile);
		}
	}
	  
	public void damageInteractiveTile(int i) {
		if (i != 999 && gp.iTile[gp.currentMap][i].destructible == true 
				&& gp.iTile[gp.currentMap][i].isCorrectItem(this) == true && gp.iTile[gp.currentMap][i].invincible == false) {
			gp.iTile[gp.currentMap][i].playerSE();
			gp.iTile[gp.currentMap][i].life--;
			gp.iTile[gp.currentMap][i].invincible = true;
			
			generateParticle(gp.iTile[gp.currentMap][i], gp.iTile[gp.currentMap][i]);
			
			if (gp.iTile[gp.currentMap][i].life == 0) {
				gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyedForm();	
			}
		}
	}

	public void interactNPC(int i){
		
		if(i != 999) {
			if(gp.keyH.enterPressed == true) {
				attackCanceled = true;
				gp.npc[gp.currentMap][i].speak();	
			}
			gp.npc[gp.currentMap][i].move(direction);
		}
	}
	
 	public void contactMonster(int i) {
		if(i != 999) {
			
			if(invincible == false && gp.monster[gp.currentMap][i].dying == false) {
				
				gp.playerSE(6);
				int damage = gp.monster[gp.currentMap][i].attack - defense;
				if (damage < 1) {
					damage = 1;
				}
				life -= damage; 
				invincible = true;
				transparent = true;
			}
		
		}
	}
	
	public void damageMonster(int i, Entity attacker, int attack, int knockBackPower) {
		if (i != 999) {
			if (gp.monster[gp.currentMap][i].invincible == false) {
				gp.playerSE(5);
				
				if (knockBackPower > 0) {
					knockBack(gp.monster[gp.currentMap][i], attacker, knockBackPower);
				}
				
				if (gp.monster[gp.currentMap][i].offBalance) {
					attack *= 3;
				}
				
				int damage = attack - gp.monster[gp.currentMap][i].defense;
				if (damage < 0) {
					damage = 0;
				}
				gp.monster[gp.currentMap][i].life -= damage;
				gp.ui.showMessage(damage + " damage!");
				gp.monster[gp.currentMap][i].invincible = true;
				gp.monster[gp.currentMap][i].damageReaction();
				
				if (gp.monster[gp.currentMap][i].life <= 0) {
					gp.monster[gp.currentMap][i].dying = true;
					gp.ui.showMessage("Killed " + gp.monster[gp.currentMap][i].name + "...");
					gp.ui.showMessage("Got " + gp.monster[gp.currentMap][i].exp + " Exp");
					exp += gp.monster[gp.currentMap][i].exp;
					checkLevelUp();
				}
			}  
		} 
		
	}
	
	public void checkLevelUp() {
		if (exp >= nextLevelExp) {
			level++;
			nextLevelExp = nextLevelExp * 2;
			strength++;
			dexterity++;
			attack = getAttack();
			defense = getDefense();
			
			gp.playerSE(8);
			gp.gameState = gp.dialogueState;
			startDialogue(this, 0);
		}
	}
	
	public void setDialogue() {
		dialogues[0][0] = "Level Up! You have gained strength.";
	}
	
	public void selectItem() {
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol ,gp.ui.playerSlotRow);
		if (itemIndex < inventory.size()) {
			Entity selectedItem = inventory.get(itemIndex);
			if (selectedItem.type == type_fist || selectedItem.type == type_ash_glove || selectedItem.type == type_socks || selectedItem.type == type_boxing_glove) {
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			if (selectedItem.type == type_shield || selectedItem.type == type_moon_shield  || selectedItem.type == type_ravaged_shield) {
				currentShield = selectedItem;
				defense = getDefense();
			}
			if (selectedItem.type == type_light) {
				if (currentLight == selectedItem) {
					currentLight = null;
				} else {
					currentLight = selectedItem;
				}
				lightUpdated = true;
			}
			if (selectedItem.type == type_consumable) {
				if(selectedItem.use(this)) {
					if (selectedItem.amount > 1) {
						selectedItem.amount--;
					} else {
						inventory.remove(itemIndex);		
					}
				}
			}
		}
	}
	
	public void draw(Graphics2D g2) {
	//g2.setColor(Color.white);
	//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		
		switch(direction) {
			case "up":
				if (attacking == false) { 
					if(spriteNum == 1) image = up1;
					if(spriteNum == 2) image = up2;
				} 
				if (attacking) {
					tempScreenY = screenY - gp.tileSize;
					if(spriteNum == 1) image = attackUp1;
					if(spriteNum == 2) image = attackUp2;
				}
				if (guarding) {
					image = guardUp;
				}
				break;
			case "down":
				if (attacking == false) { 
					if(spriteNum == 1) image = down1;
					if(spriteNum == 2) image = down2;
				} 
				if (attacking) {
					if(spriteNum == 1) image = attackDown1;
					if(spriteNum == 2) image = attackDown2;
				}
				if (guarding) {
					image = guardDown;
				}
				break;
			case "left":
				if (attacking == false) { 
					if(spriteNum == 1) image = left1;
					if(spriteNum == 2) image = left2;
				} 
				if (attacking) {
					tempScreenX = screenX - gp.tileSize;
					if(spriteNum == 1) image = attackLeft1;
					if(spriteNum == 2) image = attackLeft2;
				}
				if (guarding) {
					image = guardLeft;
				}
				break;
			case "right":
				if (attacking == false) { 
					if(spriteNum == 1) image = right1;
					if(spriteNum == 2) image = right2;
				} 
				if (attacking) {
					if(spriteNum == 1) image = attackRight1;
					if(spriteNum == 2) image = attackRight2;
				}
				if (guarding) {
					image = guardRight;
				}
				break;
		}
		
		if(transparent == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		
		if(drawing) {
			g2.drawImage(image, tempScreenX, tempScreenY, null);	
		}
		
		//Reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		//g2.setColor(Color.red); //Checks Collision box
		//g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
		
		//DEBUG
		//g2.setFont(new Font("Arial", Font.PLAIN, 26));
		//g2.setColor(Color.white);
		//g2.drawString("Invincible:" + invincibleCounter, 10, 400);
	}
	
	public int searchItemInInventory(String itemName) {
		// Searches if you have an item. Used for stackable items and checking for quest items.
		int itemIndex = 999;
		
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name.equals(itemName)) {
				itemIndex = i;
				break;
			}
		}
		return itemIndex;
	}
	
	public boolean canObtainItem(Entity item) {
		boolean canObtain = false;
		
		Entity newItem = gp.eGenerator.getObject(item.name);
		
		// CHECK STACKABLE
		if (newItem.stackable) {
			int index = searchItemInInventory(newItem.name);
			
			if (index != 999) {
				inventory.get(index).amount++;
				canObtain = true;
			} else {
				// New item, check vacancy
				if (inventory.size() != maxInventorySize) {
					inventory.add(newItem);
					canObtain = true;
				}
			}
		} else {
			// New item, check vacancy
			if (inventory.size() != maxInventorySize) {
				inventory.add(newItem);
				canObtain = true;
			}
		}
		return canObtain;
	}
	
	public void getSleepingImage(BufferedImage image) {
		up1 = image;
		up2 = image;
		down1 = image;
		down2 = image;
		left1 = image;
		left2 = image;
		right1 = image; 
		right2 = image; 
	}
	
	public void getGuardImage() {
		guardUp = setUp("/player/EG_Guard_Up",gp.tileSize,gp.tileSize);
		guardDown = setUp("/player/EG_Guard_Down",gp.tileSize,gp.tileSize);
		guardLeft = setUp("/player/EG_Guard_Left",gp.tileSize,gp.tileSize);
		guardRight = setUp("/player/EG_Guard_Right",gp.tileSize,gp.tileSize);
	}
	
}
