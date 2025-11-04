package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chocolate extends Entity {

	GamePanel gp;
	public static final String objName = "Chocolate";
	
	public OBJ_Chocolate(GamePanel gp) {
		super(gp);
		this.gp = gp;
		value = 5;
		type = type_consumable;
		name = objName;
		down1 = setUp("/objects/Chocolate", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\n100% Dark. Your\nfavorite. Heals " + value + " life.";
		price = 20;
		stackable = true;
		setDialogue();
	}
	
	public void setDialogue() {
		dialogues[0][0] = "You eat the " + name + ". Mmm that's good.\nLife recovered by " + value + ".";
	}
	
	public boolean use(Entity entity) {
		startDialogue(this, 0);
		entity.life += value;
		gp.playerSE(2);
		return true;
	}

}
