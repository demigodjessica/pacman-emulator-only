package eecs40.iPacMan;

//import android.R; <-- Gives a lot of errors! 
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SettingsActivity extends Activity implements OnClickListener{
    
	/** Called when the activity is first created. */
	private TextView tv, tv1, tv2, tv3, tv4;
	private boolean[] settingsHolder = new boolean[4];
	
	/* 
	 * Settings has 4 options 
	 * Cheap Mode - Grants power pellet effect of 60 seconds 
	 * Infinity Lives mode - Get +1000 Lives 
	 * Standard Mode  
	 * Expert Mode - Very fast ghost speed to begin with. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);       
        
        tv = (TextView) findViewById(R.id.cheapmode);
        tv1 = (TextView) findViewById(R.id.infinitylives);
        tv2 = (TextView) findViewById(R.id.standardmode);
        tv3 = (TextView) findViewById(R.id.expertmode);
        tv4 = (TextView) findViewById(R.id.back);
        
        tv.setTypeface(MenuActivity.tf);
        tv1.setTypeface(MenuActivity.tf);
        tv2.setTypeface(MenuActivity.tf);
        tv3.setTypeface(MenuActivity.tf);
        tv4.setTypeface(MenuActivity.tf);
        
        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        
        getSettings();
        setText();      
    }
        
    
	private void setText() {
		if (!settingsHolder[0]) { 
			tv.setText("Cheap Mode off"); 
		} else { 
			tv.setText("Cheap Mode on"); 
		}
		if (!settingsHolder[1]) { 
			tv1.setText("Infinity lives off"); 
		} else { 
			tv1.setText("Infinity lives on"); 
		}
		if (!settingsHolder[2]) { 
			tv2.setText("Standard Mode off"); 
		} else { 
			tv2.setText("Standard Mode on"); 
		}
		if (!settingsHolder[3]) { 
			tv3.setText("Expert Mode off"); 
		} else { 
			tv3.setText("Expert Mode on"); 
		}
	}
	
	private void getSettings() {
		SharedPreferences settings = getSharedPreferences(MenuActivity.PREFS_NAME, 0);
		
		settingsHolder[0] = settings.getBoolean("cheapmode", false);
		settingsHolder[1] = settings.getBoolean("infinitylives", false);
		settingsHolder[2] = settings.getBoolean("standardmode", true);
		settingsHolder[3] = settings.getBoolean("expertmode", false);			
	}

	public void onClick(View v) {
		SharedPreferences settings = getSharedPreferences(MenuActivity.PREFS_NAME, 0);
	    SharedPreferences.Editor editor = settings.edit();
	     
		switch(v.getId()){
			case R.id.cheapmode:
				editor.putBoolean("cheapmode", !settingsHolder[0]);
				System.out.println("changed a variable");
				break;
			case R.id.infinitylives:
				editor.putBoolean("infinitylives", !settingsHolder[1]);
				System.out.println("changed a variable");
				break;
			case R.id.standardmode:
				editor.putBoolean("standardmode", !settingsHolder[2]);
				break;
			case R.id.expertmode:
				editor.putBoolean("expertmode", !settingsHolder[3]);
				break;
			case R.id.back:
				finish();
				break;
		}
		
		editor.commit();
		getSettings();
		setText();
	}
}