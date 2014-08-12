package eecs40.iPacMan;

import android.graphics.Canvas;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;


public class PacmanThread extends Thread {
	
	PacmanView PV;

	public PacmanThread(PacmanView View) {
		this.PV= View;
	}

	// Game loop 
	public void run() 
	{
		Loop(); 
	}
	
	public void Loop() 
	{
		while(true) 
		{
			SurfaceHolder sh = PV.getHolder(); //Creating a new surface holder and canvas everytime seems stupid. 
			Canvas canvas = sh.lockCanvas();
			if (canvas != null) {
				PV.onDraw(canvas);
				sh.unlockCanvasAndPost(canvas);
			}
			 try {
	        	   sleep(10); // get rid of a little lag. 
	           } 
	           catch (Exception e) {}
			if(canvas == null)
			{
				System.out.println("canvas is null");
			}
			
		}	
	}	
	
	
}


