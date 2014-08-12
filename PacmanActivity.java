package eecs40.iPacMan;


import android.app.Activity;
import android.content.SharedPreferences;
//import android.game.menu.GenericMenu;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class PacmanActivity extends Activity {
	
	PacmanView PV; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get rid of top bar. 
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);       
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        SharedPreferences settings = getSharedPreferences(MenuActivity.PREFS_NAME, 0);
        boolean cMode = settings.getBoolean("cheapmode", false);  
        System.out.println("cheap mode is " + cMode);
        
        boolean iMode = settings.getBoolean("infinitylives", false);  
        System.out.println("infinity mode is " + iMode);
        
        boolean sMode = settings.getBoolean("standardmode", true);  
        System.out.println("standard mode is " + sMode);
        
        boolean eMode = settings.getBoolean("expertmode", false);  
        System.out.println("expertmode mode is " + eMode);
        
        PacmanView PV = new PacmanView(getBaseContext(), cMode, iMode, sMode, eMode);
        setContentView(PV);
        PacmanThread thread = new PacmanThread(PV);
        thread.start();
        System.out.println("Does this loop over and over again?");
    }
    
    
}
