 package tiles_interactive;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class IT_BurnedTree extends InteractiveTile {

	
	GamePanel gp;
	
	public IT_BurnedTree(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setUp("/tiles_interactive/TreeBurned", gp.tileSize, gp.tileSize);
		destructible = true;
		life = 2; 
	}
	
	public void playerSE() {
		gp.playerSE(11);
	}
	
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new IT_Trunk(gp, worldX / gp.tileSize, worldY / gp.tileSize);
		return tile;
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		if (entity.currentWeapon.type == type_ash_glove) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
	
	public Color getParticleColor() {
		Color color = new Color(0,0, 0);
		return color;
	}
	
	public int getParticleSize() {
		int size = 6;
		return size;
	}
	
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}

}
