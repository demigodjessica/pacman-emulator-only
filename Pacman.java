package eecs40.iPacMan;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

public class Pacman {
	
	int a1, a2; 
	int mX1, mY1, mX2, mY2; 
	int dir; 
	boolean canTunnel; 
	
	// Enter starting location in constructor 
	public Pacman(int a1, int a2, Maze[][] maze) 
	{ 
		this.a1 = a1; 
		this.a2 = a2; 
		updatePMCoords(a1, a2, maze); 
		dir = -1; 
		canTunnel = false; 
	}

	// Check to see if a square is available to move into. 
	// It's not a (i.e wall block) or dead space or a ghost cave area
	public boolean availableSquare(int c1, int c2, Maze[][] maze)  { 
		try 
		{
			// 2 is wall 3 is ghosts cave area 7 is deadspace 
			if (maze[c1][c2].filled != 2 && maze[c1][c2].filled != 3 && maze[c1][c2].filled != 7) { 
				return true; 
			}
			else { 
				return false; 
			}
		} 
		catch (Exception outofbounds) 
		{ 
			System.out.println("Try to tunnel");
			canTunnel = true; 
			return false; 
		}
	}
	
	public void updatePMCoords(int a1, int a2, Maze[][] maze) 
	{ 
		this.mX1 = maze[a1][a2].x1; 
		this.mY1 = maze[a1][a2].y1; 
		this.mX2 = maze[a1][a2].x2; 
		this.mY2 = maze[a1][a2].y2; 
	}
	
	/*Helps for pacman to move continuously after 1 key press */ 
	public void changeDir(int newDir) { 
		dir = newDir; 
	}
	
	public void changeLoc(int zdir, Maze[][] maze) 
	{ 
		if (dir == 0 && availableSquare(a1 - 1, a2, maze))  { 
			a1 -= 1; 
			dir = 0; 
		}
		if (dir == 3 && availableSquare(a1 + 1, a2, maze)) { 
			a1 += 1; 
			dir = 3; 
		}
		if (dir == 1 && availableSquare(a1, a2 - 1, maze)) { 
			a2 -= 1;
			dir = 1; 
		}
		if (dir == 2 && availableSquare(a1, a2 + 1, maze)) { 
			a2 += 1;
			dir = 2; 
		}
		updatePMCoords(a1, a2, maze); 
	}
	
	// Tunneling support. 
	public void teleport(int t3, int t4, Maze[][] maze) 
	{ 
		a1  = t3; 
		a2  = t4; 
		updatePMCoords(a1, a2, maze); 
	} 
	
	public void changePicture(int xChoice) 
	{
		choice = xChoice; 
	}
	
	int choice = 1; 
	
	/* Draw method for pacman handles which picture to use */ 
	public void onDrawPacman(Canvas canvas, Bitmap pacmanUp, Bitmap pacmanDown, Bitmap pacmanLeft, Bitmap pacmanRight)
	{
		Bitmap temp = null; 
        switch (choice) {
	        case 1:  temp = pacmanUp;
	        		 	break; 
	        case 2:  temp = pacmanDown;
	        			break; 
	        case 3:  temp = pacmanLeft;
	        			break; 
	        case 4: temp = pacmanRight;
	        			break; 
	       
	        default: break;
        }
        
		Rect dst = new Rect();
		dst.set(mX1, mY1, mX2, mY2); 
		canvas.drawBitmap(temp, null, dst, null);
	}	
	

}
