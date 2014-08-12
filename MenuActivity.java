package eecs40.iPacMan;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	// This prefs will help save the information. 
	public static final String PREFS_NAME = "sampleGameSettings";		
	public static Typeface tf;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // super.onCreate()   
        
        setContentView(R.layout.mainmenu);
        
        // load a special font 
        tf = Typeface.createFromAsset(getAssets(),"data/fonts/emulogic.ttf");
        
        // 4 options on main menu 
        TextView tv3 = (TextView) findViewById(R.id.about);
        TextView tv = (TextView) findViewById(R.id.start);
        TextView tv2 = (TextView) findViewById(R.id.settings);
        TextView tv4 = (TextView) findViewById(R.id.exit);
        
        tv.setTypeface(tf);
        tv2.setTypeface(tf);
        tv3.setTypeface(tf);
        tv4.setTypeface(tf);
       
        
        tv.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);        
        
		   
    }
      
	public void onClick(View v) {
		
		switch(v.getId()){
			case R.id.start:
				Intent i1 = new Intent(this,PacmanActivity.class);
				startActivity(i1);
				break;
			case R.id.settings:
				Intent i2 = new Intent(this, SettingsActivity.class);
				startActivity(i2);
				break;
			case R.id.about:
				makeDialog();
				break;	
			case R.id.exit:
				finish();
				break;
		}
		
	}
	
	private void makeDialog() {		
		
	    AlertDialog.Builder dialog = new AlertDialog.Builder(this);	    
	    
	    dialog.setMessage("This is a clone of Pacman made for EECS 40 2012!");

	    dialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {}
	    });
	
	    dialog.show();
	}
		
}