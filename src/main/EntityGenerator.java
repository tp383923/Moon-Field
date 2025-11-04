package main;

import entity.Entity;
import object.OBJ_Ash_Glove;
import object.OBJ_Blue_Door;
import object.OBJ_Blue_Key;
import object.OBJ_Boxing_Glove;
import object.OBJ_Chest;
import object.OBJ_Chocolate;
import object.OBJ_Door;
import object.OBJ_Door_Dark;
import object.OBJ_Energy;
import object.OBJ_Green_Door;
import object.OBJ_Green_Key;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_Mini_Moon;
import object.OBJ_Moon_Coin;
import object.OBJ_Moon_Tree_Shield;
import object.OBJ_Moonball;
import object.OBJ_Plasma_Ball;
import object.OBJ_Ravaged_Shield;
import object.OBJ_Red_Door;
import object.OBJ_Red_Key;
import object.OBJ_Shield_Cardboard;
import object.OBJ_Snowglobe;
import object.OBJ_Socks;
import object.OBJ_Tent;
import object.OBJ_Weapon_Normal;

public class EntityGenerator {
	
	GamePanel gp;
	
	public EntityGenerator(GamePanel gp) {
		this.gp = gp;
	}
	
	public Entity getObject(String itemName) {
		 Entity obj = null;
		 
		 switch(itemName) {
		 case OBJ_Ash_Glove.objName: obj = new OBJ_Ash_Glove(gp); break;
		 case OBJ_Boxing_Glove.objName: obj = new OBJ_Boxing_Glove(gp); break;
		 case OBJ_Socks.objName: obj = new OBJ_Socks(gp); break;
		 case OBJ_Weapon_Normal.objName: obj = new OBJ_Weapon_Normal(gp); break;
		 case OBJ_Chocolate.objName: obj = new OBJ_Chocolate(gp); break;
		 case OBJ_Moon_Tree_Shield.objName: obj = new OBJ_Moon_Tree_Shield(gp); break;
		 case OBJ_Ravaged_Shield.objName: obj = new OBJ_Ravaged_Shield(gp); break;
		 case OBJ_Shield_Cardboard.objName: obj = new OBJ_Shield_Cardboard(gp); break;
		 case OBJ_Tent.objName: obj = new OBJ_Tent(gp); break;
		 case OBJ_Door.objName: obj = new OBJ_Door(gp); break;
		 case OBJ_Red_Door.objName: obj = new OBJ_Red_Door(gp); break;
		 case OBJ_Blue_Door.objName: obj = new OBJ_Blue_Door(gp); break;
		 case OBJ_Green_Door.objName: obj = new OBJ_Green_Door(gp); break;
		 case OBJ_Door_Dark.objName: obj = new OBJ_Door_Dark(gp); break;
		 case OBJ_Mini_Moon.objName: obj = new OBJ_Mini_Moon(gp); break;
		 case OBJ_Key.objName: obj = new OBJ_Key(gp); break;
		 case OBJ_Blue_Key.objName: obj = new OBJ_Blue_Key(gp); break;
		 case OBJ_Red_Key.objName: obj = new OBJ_Red_Key(gp); break;
		 case OBJ_Green_Key.objName: obj = new OBJ_Green_Key(gp); break;
		 case OBJ_Chest.objName: obj = new OBJ_Chest(gp); break;
		 case OBJ_Moon_Coin.objName: obj = new OBJ_Moon_Coin(gp); break;
		 case OBJ_Heart.objName: obj = new OBJ_Heart(gp); break;
		 case OBJ_Energy.objName: obj = new OBJ_Energy(gp); break;
		 case OBJ_Plasma_Ball.objName: obj = new OBJ_Plasma_Ball(gp); break;
		 case OBJ_Moonball.objName: obj = new OBJ_Moonball(gp); break;
		 case OBJ_Snowglobe.objName: obj = new OBJ_Snowglobe(gp); break;
		 }
		 
		 return obj;
	 }
}
