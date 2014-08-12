package eecs40.iPacMan;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ScoreAndLiveCount {
	
	// Save initial conditions
	private int initLives; 
	private int initScore; 
	
	private int tScore; // total score. 
	private int cScore; // Score on current level
	private int liveCount;
	
	Paint textPaint = new Paint();

	/* Constructor */ 
	public ScoreAndLiveCount(int lives, int score) { 
		initLives = lives; 
		initScore = score; 
		tScore = score; 
		liveCount = lives; 
		textPaint.setColor(Color.RED);
		textPaint.setAntiAlias(true);
		textPaint.setTextSize(20); 
	}
	
	/* Modifiers */ 
	public void updateScore(int xscore) 
	{ 
		this.cScore += xscore; 
		this.tScore += xscore; 
	}
	
	public void updateLives(int xlife)
	{ 
		this.liveCount += xlife; 
	}
	
	
	public void saveAndReset() { 
		this.cScore = 0; 	
	}
	
	public void restartAll() { 
		this.tScore = initScore;  
		this.cScore = 0; 
		this.liveCount = initLives; 
	}
	public void killed() { 
		//this.tScore = 0; Score should not be lost even though you died! 
		this.cScore = 0;
		this.liveCount -= 1;
		
		if (liveCount == 0)
			System.exit(0); 
	}
	
	/* Draw method for top bar. */ 
	public void onDrawTopBar(Canvas canvas)
	{
		textPaint.setColor(Color.YELLOW); 
		canvas.drawText("Pacman Clone [Spring 2012]", 30, 30, textPaint); 
		canvas.drawText("Score: " + tScore , 10, 60, textPaint); 
		canvas.drawText("Lives: " + liveCount, canvas.getWidth() - 100, 60, textPaint);
		canvas.drawLine(0, 70, canvas.getWidth(), 70, textPaint);
	}	
	
}
