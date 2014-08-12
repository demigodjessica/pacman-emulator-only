package eecs40.iPacMan;


/* Maze is one cell. Game screen is whole game */ 
public class Maze {

	int filled;
	
	public int x1, x2;
	
	public int y1, y2;
	
	//0 - Nothing; 1 - Pellet; 2 - Wall; 3 - Ghost; 4 - Pacman; 5 - null; 6- Power Pellet;
	// 8- Tunnel 7- Deadspace 
	public Maze(int x1, int y1, int x2, int y2, int setting)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.filled = setting;
	}
	
}