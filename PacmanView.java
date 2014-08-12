package eecs40.iPacMan;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.SurfaceView;


/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
Finished with Game + Game Menu. =) 

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/ 

public class PacmanView extends SurfaceView {
	
	/* All bitmaps used. */ 
	Bitmap map = BitmapFactory.decodeResource(getResources(),R.drawable.wall);
	Bitmap pellet = BitmapFactory.decodeResource(getResources(),R.drawable.pellet);
	Bitmap powerpellet = BitmapFactory.decodeResource(getResources(),R.drawable.powerpellet);
	Bitmap ghost = BitmapFactory.decodeResource(getResources(),R.drawable.bluesnail1);
	Bitmap deathghost = BitmapFactory.decodeResource(getResources(),R.drawable.deathsnail);
	Bitmap pLeft= BitmapFactory.decodeResource(getResources(),R.drawable.misspacleft);
	Bitmap pRight = BitmapFactory.decodeResource(getResources(),R.drawable.misspacright);
	Bitmap pUp = BitmapFactory.decodeResource(getResources(),R.drawable.misspacup);
	Bitmap pDown = BitmapFactory.decodeResource(getResources(),R.drawable.misspacdown);
	
	/*Objects used in the view */ 
	GameScreen pacmanScreen = new GameScreen(); 
	ScoreAndLiveCount slc = new ScoreAndLiveCount(3, 0); // Live count, Score to begin maybe put into menu options instead. 
	Pacman pm;  
	Ghost ghosts[] = new Ghost[4]; 
	
	Tunnel leftTunnel; 
	Tunnel rightTunnel; 
	
	/*Used like a singleton pattern */ 
	private boolean isGameInit = false;

	/* Timing variables */ 
	float elaspedTime = 0;
	float reviveTimeSec = 0; 
	long grabTime = 0; 
	long moveTime = 0; 
	

	
/*//////////////////////////////////////////////////////////////////////////////////////////////////////////

	                    USER SETTINGS CONSTANTS TO BEGIN WITH (implement w/ menu    everything seconds                         */
// How many seconds elapse till ghost can live cave? 
	float releaseTime = (float) 3; 
// Seconds per ghost movement? (1 is slow 0.1 is super fast). 
	float ghostSpeed = (float) 1; 
// How long will power pellet effect last? 
	float powerEffect = (float)6; 
// Which maze to begin with 
	int currentLevel = 1;
////////////////////////////////////////////////////////////////////////////////////////////////////////

	boolean cheapMode, infinityMode, standardMode, expertMode; 
	
	/* PacmanView constructor */ 
	public PacmanView(Context context, boolean cheapMode, boolean infinityMode, boolean standardMode, boolean expertMode) {
		super(context);
		setFocusable(true); 
		this.cheapMode = cheapMode; 
		this.infinityMode = infinityMode; 
		this.standardMode = standardMode; 
		this.expertMode = expertMode; 
	}
	
	public void changeDifficulty(int diff) { 
		System.out.println(" Diffculty is now " + diff);
	}
	
	// Grab maze from game screen. 
	public Maze[][] grabNewMaze() { 
		return pacmanScreen.getMaze();
	}
	
	// You died, restart game. Or initially just started. 
	public void restartGame(Canvas c, int option) { 
		if (cheapMode)  { 
			powerEffect = (float)60; // Turn cheap mode on power pellet effect lasts a whole minute. 
		}
		if (infinityMode) { 
			slc.updateLives(1000); 
		}
		if (expertMode)  { 
			ghostSpeed -= 0.5; // Start off ghosts moving waAaay faster! 
		}
		pacmanScreen.InitializeMaze(c, option); // Maze
		if (option == 1) { // Tunnel 
			leftTunnel = new Tunnel(9, 0, true); 
			rightTunnel = new Tunnel(9, 20, false); 
		}
		if(option == 2) { 
			leftTunnel = new Tunnel(6,0,true);
			rightTunnel = new Tunnel(6,20,false);
			
		}
		if(option == 1) { // Ghosts
				ghosts[0] = new Ghost(true, 7, 10, grabNewMaze());
				ghosts[1] = new Ghost(false, 9, 9, grabNewMaze());
				ghosts[2] = new Ghost(false, 9, 10, grabNewMaze()); 
				ghosts[3] = new Ghost(false, 9, 11, grabNewMaze()); 
		} 
		else {
			
			ghosts[0] = new Ghost(true, 7, 10, grabNewMaze());
			ghosts[1] = new Ghost(false, 9, 9, grabNewMaze());
			ghosts[2] = new Ghost(false, 9, 10, grabNewMaze()); 
			ghosts[3] = new Ghost(false, 9, 11, grabNewMaze()); 
			
			// maze choice 2 add here. 
		}
		pm = new Pacman(15, 10, grabNewMaze()); // Pacman starts at same position? 
		grabTime = System.currentTimeMillis();
		moveTime = System.currentTimeMillis();
		// restart score. 
	}
	
	/* The main onDraw function. */ 
	public void onDraw(Canvas c)
	{
		if (!isGameInit) {
			System.out.println("-----> Initialize once. ");
			slc.restartAll();
			restartGame(c, currentLevel); 
			isGameInit = true;
		} 	
		c.drawColor(Color.BLACK); // Clear screen. 
		if (pacmanScreen.onDrawMaze(c, map, pellet, powerpellet, pm.mX1, pm.mY1, pm.mX2, pm.mY2)) { 	
			slc.updateScore(1); 
		}  	
		slc.onDrawTopBar(c); 
		if(pm.canTunnel) { 
			
			if (leftTunnel.onSpecialTile(pm.a1, pm.a2))
				pm.teleport(rightTunnel.t1, rightTunnel.t2, grabNewMaze()); 
			else { 
				pm.teleport(leftTunnel.t1, leftTunnel.t2,  grabNewMaze()); 
			}
			pm.canTunnel = false; 
		}	
		else { 
			pm.changeLoc(pm.dir, grabNewMaze()); 
			pm.onDrawPacman(c, pUp, pDown, pLeft, pRight); 
		} 
		// For the ghost stuff. 
		for (int i = 0; i < 4; i++) {
			ghostInCaveHandling(i); 
			ghosts[i].onDrawGhost(c, deathghost, ghost, pacmanScreen.killMode); 
			int wh = ghosts[i].ghostDieOrIDie(pm.mX1, pm.mY1, pm.mX2, pm.mY2, pacmanScreen.killMode); // what scenario happened. u die. no one dies. ghost dies. 
			switch (wh) { 
				case 0: break; 
				case 1: slc.updateScore(100); 
						break; 
				case -1:{
					slc.killed();
					restartGame(c, currentLevel); 
						break;
				}
			}
			
			float eTime = (System.currentTimeMillis() - ghosts[i].moveTime)/1000F;
			if ((eTime) > ghostSpeed){
				ghosts[i].moveTime = System.currentTimeMillis();
				ghosts[i].ghostAIAlgorithm(grabNewMaze()); 
				if(leftTunnel.onSpecialTile(ghosts[i].array1, ghosts[i].array2)) { 
					System.out.println("Teleport right");
					ghosts[i].teleport(rightTunnel.t1, rightTunnel.t2, grabNewMaze()); 
					break; 
				} 
				if(rightTunnel.onSpecialTile(ghosts[i].array1, ghosts[i].array2)) { 
					System.out.println("Teleport left");
					ghosts[i].teleport(leftTunnel.t1, leftTunnel.t2,  grabNewMaze()); 
					break; 
				} 
			} 
			
		}		
		// Do stuff if we won. Not complete yet because not all level settings have been completed. 
		if (pacmanScreen.won()) { 
			c.drawColor(Color.WHITE);
			restartGame(c, flip()); 
			ghostSpeed = (float) (ghostSpeed - 0.2); 
			slc.saveAndReset(); 
		}
		// Turn power pellet effect off after powerEffect time has passed. 
		if (pacmanScreen.killMode) { 
			float powerDur = (System.currentTimeMillis() - pacmanScreen.powerTime) / 1000F; 
			if (powerDur > powerEffect) { 
				pacmanScreen.killMode = false; 
			}
		}
		
	}
	
	// Flip levels as you win 
	public int flip() { 
		if (currentLevel == 2)
			return 1; 
		else 
			return 2; 
	}

	/* Ghosts should come out one by one (depending on releaseTime) */ 
	public void ghostInCaveHandling(int num) { 
		reviveTimeSec = (System.currentTimeMillis() - grabTime)/1000F;
		if (!ghosts[num].release && (reviveTimeSec > releaseTime)) 
		{ 
			ghosts[num].escape(7, 10, grabNewMaze()); 
			grabTime = System.currentTimeMillis(); 
		}
	}

	/* Handle key presses */ 
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch(keyCode) {
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				pm.changePicture(4); 
				pm.changeDir(2);  
				System.out.println("Pressed right");
				return true; 
				
			case KeyEvent.KEYCODE_DPAD_LEFT: 
				pm.changePicture(3); 
				pm.changeDir(1); 
	
				System.out.println("Pressed Left");
				return true; 
				
			case KeyEvent.KEYCODE_DPAD_UP:
				pm.changePicture(1); 
				pm.changeDir(0); 
				System.out.println("Pressed up");
				return true; 
				
			case KeyEvent.KEYCODE_DPAD_DOWN:
				pm.changePicture(2); 
				pm.changeDir(3); 
				System.out.println("Pressed down");
				return true; 			
		}
		return true; 
	}
	
	

}
