package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
	GamePanel gp; 
	public Tile[] tile;
	public int mapTileNum[][][];
	boolean drawPath = false; // See the walking path of NPCs
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		 
		getTileImage();
		loadMap("/maps/utf-8-Map.txt", 0);
		loadMap("/maps/Hut_Map.txt", 1);
		loadMap("/maps/Dungeon.txt", 2);
		loadMap("/maps/Dungeon_Basement.txt", 3);
		loadMap("/maps/Dungeon_Boss.txt", 4);
		loadMap("/maps/Snow.txt", 5);
		loadMap("/maps/Birds.txt", 6);
		loadMap("/maps/Valley.txt", 7);
	}
	
	public void getTileImage() {
			//PLACEHOLDER
			setUp(0, "Grass", false);
			setUp(1, "Grass", false);
			setUp(2, "Grass", false);
			setUp(3, "Grass", false);
			setUp(4, "Grass", false);
			setUp(5, "Grass", false);
			setUp(6, "Grass", false);
			setUp(7, "Grass", false);
			setUp(8, "Grass", false);
			setUp(9, "Grass", false);
			
			//TILES
			setUp(10, "Grass", false);
			setUp(11, "Space", false);
			setUp(12, "Lava", false);
			setUp(13, "Stone", true);
			setUp(14, "Water", true);
			setUp(15, "GreenWater", true);
			setUp(16, "GreenWater2", true);
			setUp(17, "Dirt", false);
			setUp(18, "Moonstone", false);
			setUp(19, "Tree1", true);
			setUp(20, "TreeBurned", true);
			setUp(21, "Green_Grass", false);
			setUp(22, "Brick", true);
			setUp(23, "GrassCornerDownLeft", true);
			setUp(24, "GrassCornerDownRight", true);
			setUp(25, "GrassCornerLeft", true);
			setUp(26, "GrassCornerRight", true);
			setUp(27, "GrassDown", true);
			setUp(28, "GrassUp", true);
			setUp(29, "GrassRight", true);
			setUp(30, "GrassLeft", true);
			setUp(31, "GrassEdgeDownLeft", true);
			setUp(32, "GrassEdgeDownRight", true);
			setUp(33, "GrassEdgeLeft", true);
			setUp(34, "GrassEdgeRight", true);
			setUp(35, "Grass02", false);
			setUp(36, "Trunk", false);
			setUp(37, "Floor01", false);
			setUp(38, "Table01", true);
			setUp(39, "Hut", false);
			setUp(40, "Void", true);
			setUp(41, "Clear_Void", false);
			setUp(42, "Glitch", false);
			setUp(43, "Snow", false);
			setUp(44, "Snow02", false);
			setUp(45, "Wheat", false);
		
	}
	
	public void setUp(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath, int map) {

		try {
	
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
			
					mapTileNum[map][col][row] = num;
					++col;
 				}
				if(col == gp.maxWorldCol) {
					col = 0; 
					++row;	
				}
			}
			
			br.close();
			
		} catch(Exception e) {}
	
	}
	
	public void draw(Graphics2D g2) {
	
		int worldCol = 0;
		int worldRow = 0;
	
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
			int worldX = worldCol * gp.tileSize; 
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			} // Creates boundary, so if a tile is outside of this boundary, it isn't drawn.
			
			++worldCol;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				++worldRow;
			}
		}
		if (drawPath) {
			g2.setColor(new Color(255, 0, 0, 70));
			for (int i = 0; i < gp.pFinder.pathList.size(); i++) {
				int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize; 
				int worldY = gp.pFinder.pathList.get(i).row * gp.tileSize; 
				int screenX = worldX - gp.player.worldX + gp.player.screenX;
				int screenY = worldY - gp.player.worldY + gp.player.screenY;
				
				g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
			}
		}
	}
	
}
