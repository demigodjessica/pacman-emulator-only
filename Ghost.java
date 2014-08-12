package eecs40.iPacMan;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Ghost {
	
	// public because writing so many getter and setters would be confusing 
	// is it released from the cave yet? 
	public boolean release;
	
	// current box it inhabits. 
	public int gX1; 
	public int gY1; 
	public int gX2; 
	public int gY2; 
	
	// current position in 2d grid. 
	public int array1; 
    public int array2;
    
    // initial positions  
    public int init1; 
    public int init2; 
    public int i1, i2, i3, i4; 
    
    // 0 up. 1 left. 2 right. 3 down. 
    // Cannot reverse direction! 
    public int lastMove = -1; 
    public int nextMove = -1; 
    
    // keep track of whether it can move a certain direction. 
	public boolean up = false; 
	public boolean down = false;  
	public boolean left = false; 
	public boolean right = false; 
	long moveTime; 
	
	Rect ghostRect = new Rect();
	Random generator = new Random();
	
	public boolean died; 
	public boolean made = false;

	// Grabs the box coords based on the [gX][gY]  like an update too. 
	public void updateCoords(int gX, int gY, Maze[][] maze) 
	{ 
		array1 = gX; 
		array2 = gY; 
		this.gX1 = maze[gX][gY].x1; 
		this.gY1 = maze[gX][gY].y1; 
		this.gX2 = maze[gX][gY].x2; 
		this.gY2 = maze[gX][gY].y2; 
		//System.out.println("Current ghost coords are " + "(" + gX1 + ", " + gY1 + ", " + gX2 + " , " + gY2 + ")");
	}
	
	 // Constructor
	public Ghost(boolean release, int aX, int aY, Maze[][] maze)
	{ 
		this.made = true;
		died = false; 
		this.release = release; 
		 updateCoords(aX, aY, maze);
		 init1 = aX; 
		 init2 = aY; 
		 moveTime = System.currentTimeMillis(); 
	}
	
	public void refreshGhost(boolean release, int aX, int aY, Maze[][] maze)
	{
		this.release = release;
		died = false;
		updateCoords(aX, aY, maze);
		init1 = aX;
		init2 = aY;
		moveTime = System.currentTimeMillis();
		
		
	}
	
	public String generated(int d) { 
		if (d== 0 ) { 
			return " up "; 
		}
		if (d== 1 ) { 
			return " left "; 
		}
		if (d== 2 ) { 
			return " right "; 
		}
		if (d== 3 ) { 
			return " down"; 
		}
		return " Ur stupid "; 
	}
	
	// Make sure it doesn't reverse 
	// reverse would return false 
    public boolean goodMove(int next) { 
    	//System.out.println(" Trying to move " + generated(next));
    	if ( ((lastMove == 0) && (next == 3)) || ((lastMove == 3) && (next == 0))) { 
    		//System.out.println(" BAD MOVE. @ " + array1 + ", " + array2);
    		return false; 
    	}
    	
    	if ( ((lastMove == 2) && (next == 1)) || ((lastMove == 1) && (next == 2))) {
    		//System.out.println(" BAD MOVE. @ " + array1 + ", " + array2);
    		return false; 
    	}
    	
    	this.nextMove = next; 
    	return true; 
    		
    }
	
	// Change the location of this ghost. 
	public void diffLoc(int d1, int d2, Maze[][] maze) 
	{
	   updateCoords(d1, d2, maze); 
	}
	
	// Let a ghost escape out of cave thing. 
	public void escape(int startPt1, int startPt2, Maze[][] maze) 
	{ 
		release = true; 
		diffLoc(startPt1, startPt2, maze); 
	}
	
	// Check to see if a square is available to move into. 
	// It's not a (i.e wall block) or dead space or a ghost cave area
	public boolean availableSquare(int c1, int c2, Maze[][] maze)  { 
		try 
		{
			if (maze[c1][c2].filled != 2 && maze[c1][c2].filled != 3 && maze[c1][c2].filled != 7) 
			{ 
				//System.out.println("available. ");
				return true; 
			}
			else { 
				return false; 
			}
		} 
		catch (Exception outofbounds) 
		{ 
			System.out.println(" TUNNNEL GHOST !!! ");
			return false; 
		}
	}
	
	// Which directions are available for this ghost to move? 
	public void availableMovement(int current1, int current2, Maze[][] maze) 
	{ 
		if (availableSquare(current1 - 1, current2, maze)) // Up 1
		{ 
			up = true; 
		} else { 
			up = false; 
		}
		if(availableSquare(current1 + 1, current2, maze)) // Down 1
		{
			down = true; 
		} else { 
			down = false; 
		}
		if (availableSquare(current1, current2 + 1, maze)) // Right 1
		{ 
		    right = true; 
				
		} else { 
			right = false; 
		}
		if (availableSquare(current1, current2 - 1, maze)) // Left 1
		{ 
			left = true; 
		} else { 
			left = false; 
		}		
	}
	
	
	// Tunneling support. 
	public void teleport(int t3, int t4, Maze[][] maze) 
	{ 
		array1  = t3; 
		array2  = t4; 
		updateCoords(array1, array2, maze); 
	} 
		
	// Random movement. A* algorithm was too complicated... just tries to move smoothly
	// by avoiding directions that are opposite to previous direction 
	// Uses the fact that a ghost always has 2 possible directions. 
	int mNext;  
	public boolean ghostAIAlgorithm(Maze[][] maze) 
	{ 
		if (!release) { 
			//System.out.println("illegal ghost. " + "[" + array1 + ", " + array2 + "]");
			return true; 
		}
		availableMovement(array1, array2, maze); 
		boolean movement = false; 
		
		while (!movement) {
			mNext = generator.nextInt(4); // get a 0 - 3. 
			switch (mNext) { 
				case 0: 
					if (up && goodMove(0)) { 
						movement = true; 
						lastMove = 0; 
						System.out.println(" ~moved up 1. ");
						diffLoc(array1 - 1, array2, maze); 
						return true; 
					}		
				case 1: 	
					if (left && goodMove(1)) {
						movement = true; 
						lastMove = 1; 
						System.out.println(" ~moved left 1. ");
						diffLoc(array1, array2 - 1, maze); 
						return true; 
					}
				case 2: 	
					if (right && goodMove(2)) {
						movement = true; 
						lastMove = 2; 
						System.out.println(" ~moved right 1. ");
						  diffLoc(array1, array2 + 1, maze); 
						return true; 
					}
				case 3: 		
					if (down && goodMove(3)) {
						movement = true; 
						lastMove = 3; 
						System.out.println(" ~moved down 1. ");
						diffLoc(array1 + 1, array2, maze); 
						return true; 
					}
					
				default: 
					movement = false; 
				
			} 
			
		} 

		// Still haven't exited must have failed... 
		return false; 
	}
	
	// Draws out the 4 ghosts 
	public void onDrawGhost(Canvas c, Bitmap ghostPic, Bitmap deathPic, boolean xkillMode)
	{
		if (!died) {
			if (xkillMode) {
				ghostRect.set(gX1, gY1, gX2, gY2);
				c.drawBitmap(ghostPic, null, ghostRect, null);
			} 
			else { 
				ghostRect.set(gX1, gY1, gX2, gY2);
				c.drawBitmap(deathPic, null, ghostRect, null);
			}
		} 
	}
	
	// 1 -> Win 
	// -1 -> Died 
	// 0 -> Nothing happened. 
	public int ghostDieOrIDie(int px1, int py1, int px2, int py2, boolean xkillMode) { 
		if (!died) {
			if (ghostRect.intersect(px1, py1, px2, py2))
			{ 
				if (xkillMode) {
					release = false; 
					died = true; 
					array1 = init1; 
					array2 = init2; 
					return 1; 
				} else { 
					System.out.println(" YOU DIED. ");
					return -1; 
				}
			}	
		}
		return 0; 
	} 

}
