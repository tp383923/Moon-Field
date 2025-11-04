package tiles_interactive;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class IT_OldBrick extends InteractiveTile {

	GamePanel gp;
	
	public IT_OldBrick(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setUp("/tiles_interactive/Old_Brick", gp.tileSize, gp.tileSize);
		destructible = true;
		life = 4; 
	}
	
	public void playerSE() {
		gp.playerSE(19);
	}
	
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = null;
		return tile;
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		if (entity.currentWeapon.type == type_boxing_glove) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
	
	public Color getParticleColor() {
		Color color = new Color(65,65,65);
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
