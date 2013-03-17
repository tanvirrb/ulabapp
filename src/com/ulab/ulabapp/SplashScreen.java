package com.ulab.ulabapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashScreen extends Activity {

	MediaPlayer ourSound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		ourSound = MediaPlayer.create(SplashScreen.this, R.raw.chimes);
		ourSound.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(mainActivityIntent);
				}
			}
		};
		timer.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSound.release();
		finish();
	}
	
	

}
