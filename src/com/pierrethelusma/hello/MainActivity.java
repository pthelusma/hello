package com.pierrethelusma.hello;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

@SuppressWarnings("unused")
public class MainActivity extends Activity {
	
	MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mp = MediaPlayer.create(this, R.raw.hello_min);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void playHello(View view)
    {
    	if(mp.isPlaying())
    	{
    		mp.stop();
    		mp = MediaPlayer.create(this, R.raw.hello_min);
    	}
    	
    	mp.start();
    	
    	if(mp.isPlaying())
    		Log.d("State",  "Is Playing");
    	
    	mp.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				Log.d("msg", "The sound has finished playing!");
			}
		});	
    }
    
}
