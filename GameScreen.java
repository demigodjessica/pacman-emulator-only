package eecs40.iPacMan;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/*  This comprises of the whole game board */ 
public class GameScreen {
	
	private int GamePiecesWidth;
	private int GamePiecesHeight;
	private final int grid = 21;
	public int winNumber; // Number of pellets needed to win. 
	int pelletsAte; 
	
	public long powerTime; 

	public boolean killMode; 
	
	Maze maze[][] = new Maze[21][21];
	
	
	/* Empty constructor */ 
	public GameScreen() 
	{ 
		killMode = false; 
	}

	/* Sets which grid cells have which items 
	 * 0 - Nothing; 1 - Pellet; 2 - Wall; 3 - Ghost; 4 - Pacman; 5 - null; 6- Power Pellet, 7 - Dead space. ;
	 * We have 2 different levels*/ 
	
	public void FillMaze1(){
			maze[0][0].filled = 7;
			maze[0][1].filled = 2;	
			maze[0][2].filled = 2;	
			maze[0][3].filled = 2;
			maze[0][4].filled = 2;	
			maze[0][5].filled = 2;	
			maze[0][6].filled = 2;	
			maze[0][7].filled = 2;	
			maze[0][8].filled = 2;	
			maze[0][9].filled = 2;	
			maze[0][10].filled = 2;	
			maze[0][11].filled = 2;	
			maze[0][12].filled = 2;	
			maze[0][13].filled = 2;	
			maze[0][14].filled = 2;	
			maze[0][15].filled = 2;	
			maze[0][16].filled = 2;	
			maze[0][17].filled = 2;				
			maze[0][18].filled = 2;	
			maze[0][19].filled = 2;
			maze[0][20].filled = 7; 

			maze[1][0].filled = 7;
			maze[1][1].filled = 2;
			maze[1][10].filled = 2;
			//maze[1][17].filled = 0; -- Pellet 
			maze[1][19].filled = 2;
			maze[1][20].filled = 7;
			
			maze[2][0].filled = 7;
			maze[2][1].filled = 2;
			maze[2][2].filled = 6;
			maze[2][3].filled = 2;
			maze[2][4].filled = 2;	
			maze[2][6].filled = 2;	
			maze[2][7].filled = 2;	
			maze[2][8].filled = 2;	
			maze[2][10].filled = 2;	
			maze[2][12].filled = 2;	
			maze[2][13].filled = 2;	
			maze[2][14].filled = 2;	
			maze[2][16].filled = 2;	
			maze[2][17].filled = 2;	
			maze[2][18].filled = 6;
			maze[2][19].filled = 2;	
			maze[2][20].filled = 7;
			
			maze[3][0].filled = 7;
			maze[3][1].filled = 2;	
			maze[3][19].filled = 2;	
			maze[3][20].filled = 7;
			
			maze[4][0].filled = 7;
			maze[4][1].filled = 2;	
			maze[4][3].filled = 2;	
			maze[4][4].filled = 2;	
			maze[4][4].filled = 2;
			maze[4][6].filled = 2;
			//maze[4][7].filled = 0;
			maze[4][8].filled = 2;
			maze[4][9].filled = 2;
			maze[4][11].filled = 2;
			
			maze[4][10].filled = 2;
			maze[4][12].filled = 2;
			//maze[4][13].filled = 2;
			maze[4][14].filled = 2;
			maze[4][16].filled = 2;
			maze[4][17].filled = 2;
			maze[4][19].filled = 2;
			maze[4][20].filled = 7;
			
			maze[5][0].filled = 7;
			maze[5][1].filled = 2;
			maze[5][6].filled = 2;
			maze[5][10].filled = 2;
			maze[5][14].filled = 2;
			maze[5][19].filled = 2;
			maze[5][20].filled = 7;

			maze[6][0].filled = 7;
			maze[6][1].filled = 2;
			maze[6][2].filled = 2;
			maze[6][3].filled = 2;
			maze[6][4].filled = 2;
			maze[6][6].filled = 2;
			maze[6][7].filled = 2;
			maze[6][8].filled = 2;
			maze[6][9].filled = 0;
			maze[6][10].filled = 2;
			maze[6][11].filled = 0;
			maze[6][12].filled = 2;
			maze[6][13].filled = 2;
			maze[6][14].filled = 2;
			maze[6][16].filled = 2;
			maze[6][17].filled = 2;
			maze[6][18].filled = 2;
			maze[6][19].filled = 2;
			maze[6][20].filled = 7;
			
			
			maze[7][0].filled = 7;
			maze[7][1].filled = 7;
			maze[7][2].filled = 7;
			maze[7][3].filled = 7;
			maze[7][4].filled = 2;
			maze[7][6].filled = 2;
			maze[7][7].filled = 0;
			maze[7][8].filled = 0;
			maze[7][9].filled = 0;
			maze[7][10].filled = 0;
			maze[7][11].filled = 0;
			maze[7][12].filled = 0;
			maze[7][13].filled = 0;
			maze[7][14].filled = 2;
			maze[7][16].filled = 2;
			maze[7][17].filled = 7;
			maze[7][18].filled = 7;
			maze[7][19].filled = 7;
			maze[7][20].filled = 7;
			
			maze[8][0].filled = 2;
			maze[8][1].filled = 2;
			maze[8][2].filled = 2;
			maze[8][3].filled = 2;
			maze[8][4].filled = 2;
			maze[8][6].filled = 2;
			maze[8][7].filled = 0;
			maze[8][8].filled = 2;
			maze[8][9].filled = 2;
			maze[8][10].filled = 3;
			maze[8][11].filled = 2;
			maze[8][12].filled = 2;
			maze[8][13].filled = 0;
			maze[8][14].filled = 2;
			maze[8][16].filled = 2;
			maze[8][17].filled = 2;
			maze[8][18].filled = 2;
			maze[8][19].filled = 2;
			maze[8][20].filled = 2;
			
			maze[9][0].filled = 0;	
			maze[9][1].filled = 0;
			maze[9][2].filled = 0;
			maze[9][3].filled = 0;
			maze[9][4].filled = 0;
			maze[9][6].filled = 0;
			maze[9][7].filled = 0;
			maze[9][8].filled = 2;
			maze[9][9].filled = 3; 
			maze[9][10].filled = 3; 
			maze[9][11].filled = 3; 
			maze[9][12].filled = 2;
			maze[9][13].filled = 0;
			maze[9][14].filled = 0;
			maze[9][16].filled = 0;
			maze[9][17].filled = 0;
			maze[9][18].filled = 0;
			maze[9][19].filled = 0;
			maze[9][20].filled = 0;
			

			maze[10][0].filled = 2;
			maze[10][1].filled = 2;
			maze[10][2].filled = 2;
			maze[10][3].filled = 2;
			maze[10][4].filled = 2;
			maze[10][6].filled = 2;
			maze[10][7].filled = 0;
			maze[10][8].filled = 2;
			maze[10][9].filled = 2;
			maze[10][10].filled = 2;
			maze[10][11].filled = 2;
			maze[10][12].filled = 2;
			maze[10][13].filled = 0;
			maze[10][14].filled = 2;
			maze[10][16].filled = 2;
			maze[10][17].filled = 2;
			maze[10][18].filled = 2;
			maze[10][19].filled = 2;
			maze[10][20].filled = 2;
			
			maze[11][0].filled = 7;
			maze[11][1].filled = 7;
			maze[11][2].filled = 7;
			maze[11][3].filled = 7;
			maze[11][4].filled = 2;
			maze[11][6].filled = 2;
			maze[11][7].filled = 0;
			maze[11][8].filled = 0;
			maze[11][9].filled = 0;
			maze[11][10].filled = 0;
			maze[11][11].filled = 0;
			maze[11][12].filled = 0;
			maze[11][13].filled = 0;
			maze[11][17].filled = 7;
			maze[11][18].filled = 7;
			maze[11][19].filled = 7;
			maze[11][20].filled = 7;
			maze[11][14].filled = 2;
			maze[11][16].filled = 2;
		
			
			maze[12][0].filled = 7;
			maze[12][1].filled = 2;	
			maze[12][2].filled = 2;	
			maze[12][3].filled = 2;	
			maze[12][4].filled = 2;	
			maze[12][6].filled = 2;
			maze[12][7].filled = 0;
			maze[12][8].filled = 2;	
			maze[12][9].filled = 2;	
			maze[12][10].filled = 2;	
			maze[12][11].filled = 2;	
			maze[12][12].filled = 2;	
			maze[12][13].filled = 0;
			maze[12][14].filled = 2;		
			maze[12][16].filled = 2;	
			maze[12][17].filled = 2;	
			maze[12][18].filled = 2;	
			maze[12][19].filled = 2;	
			maze[12][20].filled = 7;
			
			maze[13][0].filled = 7;
			maze[13][1].filled = 2;	
			maze[13][10].filled = 2;	
			maze[13][19].filled = 2;
			maze[13][20].filled = 7;
			
			maze[14][0].filled = 7;
			maze[14][1].filled = 2;
			maze[14][3].filled = 2;
			maze[14][4].filled = 2;
			maze[14][6].filled = 2;
			maze[14][7].filled = 2;
			maze[14][8].filled = 2;
			maze[14][10].filled = 2;
			//maze[14][11].filled = 0;
			maze[14][12].filled = 2;
			maze[14][13].filled = 2;
			maze[14][14].filled = 2;
			maze[14][16].filled = 2;
			maze[14][17].filled = 2;
			maze[14][19].filled = 2;
			maze[14][20].filled = 7;
			
			maze[15][0].filled = 7;
			maze[15][1].filled = 2;
			maze[15][2].filled = 6;
			maze[15][4].filled = 2;
			maze[15][16].filled = 2;
			maze[15][18].filled = 6;
			maze[15][19].filled = 2;
			maze[15][20].filled = 7;
			
			maze[16][0].filled = 7;
			maze[16][1].filled = 2;
			maze[16][2].filled = 2;
			maze[16][4].filled = 2;
			maze[16][6].filled = 2;
			maze[16][8].filled = 2;
			maze[16][9].filled = 2;
			maze[16][10].filled = 2;
			maze[16][11].filled = 2;
			maze[16][12].filled = 2;
			maze[16][14].filled = 2;
			maze[16][16].filled = 2;
			maze[16][18].filled = 2;
			maze[16][19].filled = 2;
			maze[16][20].filled = 7;
			
			maze[17][0].filled = 7;
			maze[17][1].filled = 2;
			maze[17][6].filled = 2;
			maze[17][10].filled = 2;
			maze[17][14].filled = 2;
			maze[17][19].filled = 2;
			maze[17][20].filled = 7;
			
			maze[18][0].filled = 7;
			maze[18][1].filled = 2;
			maze[18][3].filled = 2;
			maze[18][4].filled = 2;
			maze[18][5].filled = 2;
			maze[18][6].filled = 2;
			maze[18][7].filled = 2;
			maze[18][8].filled = 2;
			maze[18][10].filled = 2;
			maze[18][12].filled = 2;
			maze[18][13].filled = 2;
			maze[18][14].filled = 2;
			maze[18][15].filled = 2;
			maze[18][16].filled = 2;
			maze[18][17].filled = 2;
			maze[18][19].filled = 2;
			maze[18][20].filled = 7;
		
			maze[19][0].filled = 7;
			maze[19][1].filled = 2;
			maze[19][19].filled = 2;
			maze[19][20].filled = 7;
			
			maze[20][0].filled = 7;
			maze[20][1].filled = 2;	
			maze[20][2].filled = 2;	
			maze[20][3].filled = 2;
			maze[20][4].filled = 2;	
			maze[20][5].filled = 2;	
			maze[20][6].filled = 2;	
			maze[20][7].filled = 2;	
			maze[20][8].filled = 2;	
			maze[20][9].filled = 2;	
			maze[20][10].filled = 2;	
			maze[20][11].filled = 2;	
			maze[20][12].filled = 2;	
			maze[20][13].filled = 2;	
			maze[20][14].filled = 2;	
			maze[20][15].filled = 2;	
			maze[20][16].filled = 2;	
			maze[20][17].filled = 2;				
			maze[20][18].filled = 2;
			maze[20][19].filled = 2;
			maze[20][20].filled = 7;
			
			for(int i = 0; i < getGrid(); i++){
				for(int j = 0; j < getGrid(); j++){
					
					if(maze[i][j].filled == 5)
					{
						maze[i][j].filled = 1;
					}
					else{


					}
					
				}
			}
			
			
	}
	
	public void FillMaze2(){
		maze[0][0].filled = 7;
		maze[0][1].filled = 2;	
		maze[0][2].filled = 2;	
		maze[0][3].filled = 2;
		maze[0][4].filled = 2;	
		maze[0][5].filled = 2;	
		maze[0][6].filled = 2;	
		maze[0][7].filled = 2;	
		maze[0][8].filled = 2;	
		maze[0][9].filled = 2;	
		maze[0][10].filled = 2;	
		maze[0][11].filled = 2;	
		maze[0][12].filled = 2;	
		maze[0][13].filled = 2;	
		maze[0][14].filled = 2;	
		maze[0][15].filled = 2;	
		maze[0][16].filled = 2;	
		maze[0][17].filled = 2;				
		maze[0][18].filled = 2;	
		maze[0][19].filled = 2;
		maze[0][20].filled = 7; 

		maze[1][0].filled = 7;
		maze[1][1].filled = 2;
		maze[1][8].filled = 2;
		maze[1][12].filled = 2;
		//maze[1][17].filled = 0; -- Pellet 
		maze[1][19].filled = 2;
		maze[1][20].filled = 7;
		
		maze[2][0].filled = 7;
		maze[2][1].filled = 2;
		maze[2][2].filled = 6;
		maze[2][3].filled = 2;
		maze[2][4].filled = 2;
		maze[2][5].filled = 2;
		maze[2][6].filled = 2;	
		maze[2][8].filled = 2;	
		maze[2][10].filled = 2;	
		maze[2][12].filled = 2;		
		maze[2][14].filled = 2;
		maze[2][15].filled = 2;
		maze[2][16].filled = 2;	
		maze[2][17].filled = 2;	
		maze[2][18].filled = 6;
		maze[2][19].filled = 2;	
		maze[2][20].filled = 7;
		
		maze[3][0].filled = 7;
		maze[3][1].filled = 2;
		maze[3][3].filled = 2;	
		maze[3][10].filled = 2;
		maze[3][17].filled = 2;
		maze[3][19].filled = 2;	
		maze[3][20].filled = 7;
		
		maze[4][0].filled = 7;
		maze[4][1].filled = 2;		
		maze[4][5].filled = 2;	
		maze[4][7].filled = 2;
		maze[4][8].filled = 2;
		maze[4][10].filled = 2;
		maze[4][12].filled = 2;
		maze[4][13].filled = 2;
		maze[4][15].filled = 2;
		maze[4][19].filled = 2;
		maze[4][20].filled = 7;
		
		maze[5][0].filled = 2;
		maze[5][1].filled = 2;
		maze[5][2].filled = 2;
		maze[5][3].filled = 2;
		maze[5][5].filled = 2;
		maze[5][15].filled = 2;
		maze[5][17].filled = 2;
		maze[5][18].filled = 2;
		maze[5][19].filled = 2;
		maze[5][20].filled = 2;
		
		maze[6][0].filled = 0;
		maze[6][1].filled = 0;
		maze[6][5].filled = 2;
		maze[6][6].filled = 2;
		maze[6][7].filled = 0;
		maze[6][8].filled = 2;
		maze[6][9].filled = 2;
		maze[6][10].filled = 2;
		maze[6][11].filled = 2;
		maze[6][12].filled = 2;
		maze[6][13].filled = 0;
		maze[6][14].filled = 2;
		maze[6][15].filled = 2;
		maze[6][19].filled = 0;
		maze[6][20].filled = 0;
		
		maze[7][0].filled = 2;
		maze[7][1].filled = 2;
		maze[7][3].filled = 2;
		maze[7][6].filled = 0;
		maze[7][7].filled = 0;
		maze[7][8].filled = 0;
		maze[7][9].filled = 0;
		maze[7][10].filled = 0;
		maze[7][11].filled = 0;
		maze[7][12].filled = 0;
		maze[7][13].filled = 0;
		maze[7][14].filled = 0;
		maze[7][17].filled = 2;
		maze[7][19].filled = 2;
		maze[7][20].filled = 2;
		
		maze[8][0].filled = 7;
		maze[8][1].filled = 2;
		maze[8][3].filled = 2;
		maze[8][4].filled = 2;
		maze[8][6].filled = 2;
		maze[8][7].filled = 0;
		maze[8][8].filled = 2;
		maze[8][9].filled = 2;
		maze[8][10].filled = 3;
		maze[8][11].filled = 2;
		maze[8][12].filled = 2;
		maze[8][13].filled = 0;
		maze[8][14].filled = 2;
		maze[8][16].filled = 2;
		maze[8][17].filled = 2;
		maze[8][19].filled = 2;
		maze[8][20].filled = 7;
		
		maze[9][0].filled = 7;
		maze[9][1].filled = 2;
		maze[9][6].filled = 2;
		maze[9][7].filled = 0;
		maze[9][8].filled = 2;
		maze[9][9].filled = 3; 
		maze[9][10].filled = 3; 
		maze[9][11].filled = 3; 
		maze[9][12].filled = 2;
		maze[9][13].filled = 0;
		maze[9][14].filled = 2;
		maze[9][19].filled = 2;
		maze[9][20].filled = 7;
		
		maze[10][0].filled = 7;
		maze[10][1].filled = 2;
		maze[10][3].filled = 2;
		maze[10][5].filled = 2;
		maze[10][6].filled = 2;
		maze[10][7].filled = 0;
		maze[10][8].filled = 2;
		maze[10][9].filled = 2;
		maze[10][10].filled = 2;
		maze[10][11].filled = 2;
		maze[10][12].filled = 2;
		maze[10][13].filled = 0;
		maze[10][14].filled = 2;
		maze[10][15].filled = 2;
		maze[10][17].filled = 2;
		maze[10][19].filled = 2;
		maze[10][20].filled = 7;
		
		maze[11][0].filled = 7;
		maze[11][1].filled = 2;
		maze[11][3].filled = 2;
		maze[11][6].filled = 0;
		maze[11][7].filled = 0;
		maze[11][8].filled = 0;
		maze[11][9].filled = 0;
		maze[11][10].filled = 0;
		maze[11][11].filled = 0;
		maze[11][12].filled = 0;
		maze[11][13].filled = 0;
		maze[11][14].filled = 0;
		maze[11][17].filled = 2;
		maze[11][19].filled = 2;
		maze[11][20].filled = 7;
		
		maze[12][0].filled = 7;
		maze[12][1].filled = 2;	
		maze[12][3].filled = 2;	
		maze[12][4].filled = 2;
		maze[12][6].filled = 2;
		maze[12][7].filled = 2;
		maze[12][8].filled = 2;	
		maze[12][9].filled = 0;	
		maze[12][10].filled = 2;	
		maze[12][11].filled = 0;	
		maze[12][12].filled = 2;	
		maze[12][13].filled = 2;
		maze[12][14].filled = 2;
		maze[12][16].filled = 2;	
		maze[12][17].filled = 2;		
		maze[12][19].filled = 2;	
		maze[12][20].filled = 7;

		maze[13][0].filled = 7;
		maze[13][1].filled = 2;	
		maze[13][6].filled = 2;	
		maze[13][10].filled = 2;
		maze[13][14].filled = 2;	
		maze[13][19].filled = 2;
		maze[13][20].filled = 7;
		
		maze[14][0].filled = 7;
		maze[14][1].filled = 2;
		maze[14][2].filled = 2;
		maze[14][4].filled = 2;
		maze[14][6].filled = 2;
		maze[14][8].filled = 2;
		maze[14][9].filled = 2;
		maze[14][10].filled = 2;
		maze[14][11].filled = 2;
		maze[14][12].filled = 2;
		maze[14][14].filled = 2;
		maze[14][16].filled = 2;
		maze[14][18].filled = 2;
		maze[14][19].filled = 2;
		maze[14][20].filled = 7;
		
		maze[15][0].filled = 7;
		maze[15][1].filled = 2;
		maze[15][2].filled = 6;
		maze[15][4].filled = 2;
		maze[15][10].filled = 0;
		maze[15][16].filled = 2;
		maze[15][18].filled = 6;
		maze[15][19].filled = 2;
		maze[15][20].filled = 7;
		
		maze[16][0].filled = 7;
		maze[16][1].filled = 2;
		maze[16][3].filled = 2;
		maze[16][4].filled = 2;
		maze[16][6].filled = 2;
		maze[16][7].filled = 2;
		maze[16][8].filled = 2;
		maze[16][10].filled = 2;
		maze[16][12].filled = 2;
		maze[16][13].filled = 2;
		maze[16][14].filled = 2;
		maze[16][16].filled = 2;
		maze[16][17].filled = 2;
		maze[16][19].filled = 2;
		maze[16][20].filled = 7;
		
		maze[17][0].filled = 7;
		maze[17][1].filled = 2;
		maze[17][6].filled = 2;
		maze[17][10].filled = 2;
		maze[17][14].filled = 2;
		maze[17][19].filled = 2;
		maze[17][20].filled = 7;
		
		maze[18][0].filled = 7;
		maze[18][1].filled = 2;
		maze[18][3].filled = 2;
		maze[18][4].filled = 2;
		maze[18][6].filled = 2;
		maze[18][8].filled = 2;
		maze[18][9].filled = 2;
		maze[18][10].filled = 2;
		maze[18][11].filled = 2;
		maze[18][12].filled = 2;
		maze[18][14].filled = 2;
		maze[18][16].filled = 2;
		maze[18][17].filled = 2;
		maze[18][19].filled = 2;
		maze[18][20].filled = 7;
	
		maze[19][0].filled = 7;
		maze[19][1].filled = 2;
		maze[19][6].filled = 2;
		maze[19][14].filled = 2;
		maze[19][19].filled = 2;
		maze[19][20].filled = 7;
		
		maze[20][0].filled = 7;
		maze[20][1].filled = 2;	
		maze[20][2].filled = 2;	
		maze[20][3].filled = 2;
		maze[20][4].filled = 2;	
		maze[20][5].filled = 2;	
		maze[20][6].filled = 2;	
		maze[20][7].filled = 2;	
		maze[20][8].filled = 2;	
		maze[20][9].filled = 2;	
		maze[20][10].filled = 2;	
		maze[20][11].filled = 2;	
		maze[20][12].filled = 2;	
		maze[20][13].filled = 2;	
		maze[20][14].filled = 2;	
		maze[20][15].filled = 2;	
		maze[20][16].filled = 2;	
		maze[20][17].filled = 2;				
		maze[20][18].filled = 2;
		maze[20][19].filled = 2;
		maze[20][20].filled = 7;
		
		
		for(int i = 0; i < getGrid(); i++){
			for(int j = 0; j < getGrid(); j++){
				
				if(maze[i][j].filled == 5)
				{
					maze[i][j].filled = 1;
				}
				else{


				}
				
			}
		}
		
		
	}
	
	// For collisions to destroy pellets, etc 
	public void modifyMaze(int a1, int a2, int newItem) { 
		maze[a1][a2].filled = newItem;
	}

	/* Doesn't quite work with all canvases yet I think */ 
	public void InitializeMaze(Canvas c, int mazeChoice)
	{
		pelletsAte = 0; 
		GamePiecesWidth = c.getWidth() / (getGrid());
		GamePiecesHeight = c.getHeight()/ (getGrid() + 4);
		// Plus 4 so that the grid can have some space for hiscore live count etc.  
		int extraSpace = GamePiecesHeight * 4; 
		for(int i = 0; i < getGrid(); i++){
			for(int j = 0; j < getGrid(); j++)
			{
					maze[i][j] = new Maze(GamePiecesWidth*j, GamePiecesHeight*i + extraSpace, 
							GamePiecesWidth*(j+1),GamePiecesHeight*(i+1) + extraSpace,5);
			}
		}
		if(mazeChoice == 1)
		{
			FillMaze1();
			winNumber = 147; 
		}
		else
		{
			FillMaze2();
			winNumber = 165; // What is it? 
		}
	}
	
	public boolean won () { 
		return (pelletsAte == winNumber); 
	}
	
	// Drawing game maze out. 
	public boolean onDrawMaze(Canvas c, Bitmap blockWall, Bitmap pelletPic, Bitmap powerpelletPic, int px1, int py1, int px2, int py2)
	{
		boolean killedSomething = false; 
		
		// Traverse through array and tries to create basic game architecture [walls, pellets, powerpellets] 
		for(int i = 0; i < getGrid(); i++)
		{
			for(int j = 0; j < getGrid(); j++)
			{
				if(maze[i][j].filled == 2) // Wall 
				{	
					Rect dst = new Rect();
					dst.set(maze[i][j].x1,maze[i][j].y1,maze[i][j].x2,maze[i][j].y2);
					c.drawBitmap(blockWall, null, dst, null);
				}
				if(maze[i][j].filled == 1) // Pellet
				{
					Rect dst = new Rect(); 
					dst.set(maze[i][j].x1,maze[i][j].y1,maze[i][j].x2,maze[i][j].y2);
					c.drawBitmap(pelletPic, null, dst, null);
					
					if (dst.intersect(px1, py1, px2, py2))
					{ 
						modifyMaze(i, j, 0); 
						killedSomething = true; 
						pelletsAte += 1; 
					}
				}
				if(maze[i][j].filled == 6) // Power pellet
				{
					Rect dst = new Rect();
					dst.set(maze[i][j].x1,maze[i][j].y1,maze[i][j].x2,maze[i][j].y2);
					c.drawBitmap(powerpelletPic, null, dst, null);
					
					if (dst.intersect(px1, py1, px2, py2))
					{ 
						modifyMaze(i, j, 0); 
						killMode = true; // Don't really do anything with this just yet. 
						powerTime = System.currentTimeMillis(); 
					}
					
				}
			}
		}
		return killedSomething; 
	}
	
	
	public int getGrid() {
		return grid;
	}
	
	public Maze[][] getMaze() { 
		return maze; 
	}
	

}
