package data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {
	// PLAYER STATS
	int level;
	int maxLife;
	int life;
	int maxEnergy;
	int energy;
	int strength;
	int dexterity;
	int exp;
	int nextLevelExp;
	int coin;
	
	// PLAYER INVENTORY 
	ArrayList<String> itemNames = new ArrayList<>();
	ArrayList<Integer> itemAmounts = new ArrayList<>();
	int currentWeaponSlot;
	int currentShieldSlot;
	int currentLightSlot;
	
	// OBJECT ON MAP
	String mapObjectNames[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootNames[][];
	boolean mapObjectOpened[][];
}
