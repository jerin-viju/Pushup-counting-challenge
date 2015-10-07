package com.yahdav.liron.pushupcounter;

import java.util.Formatter;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class PushupCounterActivity extends Activity implements
		SensorEventListener, OnClickListener {
	private enum Transition {
		UP, DOWN, STOPPED
	}

	private enum PushupState {
		MOVING_UP, MOVING_DOWN, STOPPED_BOTTOM, STOPPED_TOP
	}

	private static final int SENSOR_DELAY = SensorManager.SENSOR_DELAY_GAME;
	private static final float NOISE = (float) 2.0;
	private static final boolean DEBUG = false;

	private PushupState mPushupState = PushupState.STOPPED_TOP;
	private int mPushupCount = 0;

	private float mGravityX, mGravityY, mGravityZ;

	private SensorManager mSensorManager;
	private Sensor mLinearAccelerometer;
	private Sensor mGravity;

	private boolean isStarted = false;

	private TextToSpeech mTts;
	private WakeLock mWakeLock;

	Intent intent;
	String[] str;
	TextView player;
	int arraylen;
	int noofplayers;
	int count1;
	int count2;
	int count3;
	int count4;
	int count5;
	int i,j,temp;
	int no=1;
	Intent intent1;
	String[] str2;
	int[] count;

	private static float[] unitVector(float x, float y, float z) {
		float mag = (float) Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0)
				+ Math.pow(z, 2.0));
		return new float[] { x / mag, y / mag, z / mag };
	}

	float dotProduct(float x, float y, float z, float otherX, float otherY,
					 float otherZ) {
		return (x * otherX) + (y * otherY) + (z * otherZ);
	}

	float projection(float x, float y, float z, float ontoX, float ontoY,
					 float ontoZ) {
		float[] ontoUnitVector = unitVector(ontoX, ontoY, ontoZ);
		return dotProduct(x, y, z, ontoUnitVector[0], ontoUnitVector[1],
				ontoUnitVector[2]);
	}



	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		intent=getIntent();
		str=intent.getStringArrayExtra("ID_EXTRA");
		player=(TextView)findViewById(R.id.player);
		player.setText(str[1]);
		arraylen=str.length;
        noofplayers=Integer.parseInt(str[0].toString());

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mLinearAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
		mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

		mTts = new TextToSpeech(this, new OnInitListener() {
			public void onInit(int status) {
				if (status == TextToSpeech.SUCCESS) {
					// Set preferred language to US English.
					// Note that a language may not be available, and the result
					// will indicate this.
					mTts.setLanguage(Locale.US);
				}
			}
		});

		Button btnStartStop = (Button) findViewById(R.id.btnStartStop);
		btnStartStop.setOnClickListener(this);





	}

	protected void onResume() {
		super.onResume();
	}

	protected void onPause() {
		super.onPause();
		if (isStarted) {
			onClick(findViewById(R.id.btnStartStop));
		}
	}

	public void onClick(View v) {
		if (v == findViewById(R.id.btnStartStop)) {
			Button btnStartStop = (Button) v;

			if (isStarted) { // stopping
				isStarted = false;
				btnStartStop.setText("Start");
				onBtnStop();
			} else { // starting
				isStarted = true;
				btnStartStop.setText("Stop");
				onBtnStart();
			}
		}
	}

	private void onBtnStart() {
		mSensorManager.registerListener(this, mLinearAccelerometer,
				SENSOR_DELAY);
		mSensorManager.registerListener(this, mGravity, SENSOR_DELAY);

		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
				"Pushup Counter");
		mWakeLock.acquire();
	}

	private void onBtnStop() {


			switch(no){
				case 1:count1=mPushupCount;

					break;
				case 2:count2=mPushupCount;

					break;
				case 3:count3=mPushupCount;

					break;
				case 4:count4=mPushupCount;

					break;
				case 5:count5=mPushupCount;

					break;
			}
			no++;

		int pos1=0,pos2=0,pos3=0,pos4=0,pos5=0;
		if(no>noofplayers){
			onBtnResetClick();
			mWakeLock.release();
			intent1 = new Intent("com.yahdav.liron.pushupcounter.LeaderBoard");

			mSensorManager.unregisterListener(this);




			switch (noofplayers){
				case 1:
					pos1=1;
					intent1.putExtra("ID_EXTRA1", new String[]{"1", str[1], String.valueOf(count1),String.valueOf(pos1)});
					startActivity(intent1);
					break;
				case 5:
					if((count1>=count2)&&(count1>=count3)&&(count1>=count4)&&(count1>=count5)){
						pos1=1;
					}
					else if((count2>=count1)&&(count2>=count3)&&(count2>=count4)&&(count2>=count5))
						pos1=2;
					else if((count3>=count1)&&(count3>=count2)&&(count3>=count4)&&(count3>=count5))
						pos1=3;
					else if((count4>=count1)&&(count4>=count2)&&(count4>=count3)&&(count4>=count5))
						pos1=4;
					else
					pos1=5;

					intent1.putExtra("ID_EXTRA1",new String[]{"5", str[1], String.valueOf(count1),str[2],String.valueOf(count2),str[3],String.valueOf(count3),str[4],String.valueOf(count4),str[5],String.valueOf(count5),String.valueOf(pos1)});
			        startActivity(intent1);
					break;
				case 4:
					if((count1>=count2)&&(count1>=count3)&&(count1>=count4)){
						pos1=1;
					}
					else if((count2>=count1)&&(count2>=count3)&&(count2>=count4))
						pos1=2;
					else if((count3>=count1)&&(count3>=count2)&&(count3>=count4))
						pos1=3;
					else
					pos1=4;
					intent1.putExtra("ID_EXTRA1", new String[]{"4", str[1], String.valueOf(count1), str[2], String.valueOf(count2), str[3], String.valueOf(count3),str[4],String.valueOf(count4),String.valueOf(pos1)});
					startActivity(intent1);
					break;
				case 3:
					if((count1>=count2)&&(count1>=count3)){
					pos1=1;
				}
					else if((count2>=count1)&&(count2>=count3))
						pos1=2;
					else
					pos1=3;

					intent1.putExtra("ID_EXTRA1", new String[]{"3", str[1], String.valueOf(count1), str[2], String.valueOf(count2), str[3], String.valueOf(count3),String.valueOf(pos1)});
					startActivity(intent1);
					break;
				case 2:
					if(count1>count2)
					{
						pos1=1;
					}
					else
					pos1=2;

					intent1.putExtra("ID_EXTRA1", new String[]{"2", str[1], String.valueOf(count1), str[2], String.valueOf(count2),String.valueOf(pos1)});
					startActivity(intent1);
					break;
			}

		}
		else {
			onBtnResetClick();
			mWakeLock.release();
			mSensorManager.unregisterListener(this);
		}
		if(no<=noofplayers)
		player.setText(str[no].toString());

	}

	public void onBtnResetClick() {

		TextView tvPushupCount = (TextView) findViewById(R.id.txtPushupCount);
		tvPushupCount.setText("0");
		mPushupCount = 0;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// can be safely ignored for this app
	}

	public void onSensorChanged(SensorEvent event) {
		if (event.sensor == mLinearAccelerometer) {
			onLinearAccelerometerChanged(event);
		} else if (event.sensor == mGravity) {
			onGravityChanged(event);
		}
	}

	private void onGravityChanged(SensorEvent event) {
		mGravityX = event.values[0];
		mGravityY = event.values[1];
		mGravityZ = event.values[2];
	}

	private void onLinearAccelerometerChanged(SensorEvent event) {
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];

		// positive = moving down -> stop
		// negative = moving up -> stop
		float proj = projection(x, y, z, mGravityX, mGravityY, mGravityZ);
		proj = Math.abs(proj) - NOISE > 0.0f ? proj : 0.0f;

		if (Math.abs(0.0f - proj) > 0.01) {
			Formatter f = new Formatter();


			if (proj > 0.0f) {
				transition(Transition.DOWN);
			} else {
				transition(Transition.UP);
			}
		} else {
			transition(Transition.STOPPED);
		}
	}

	private void transition(Transition transition) {
		PushupState prevState = mPushupState;
		PushupState newState = getNewPushupState(transition, prevState);
		if (newState != null) {
			handleNewState(prevState, newState);
		}
	}

	private void handleNewState(PushupState prevState, PushupState newState) {
		mPushupState = newState;



		if (prevState == PushupState.MOVING_UP
				&& newState == PushupState.STOPPED_TOP) {
			incrementPushupCount();
		}
	}



	private void incrementPushupCount() {
		mPushupCount++;

		mTts.speak(Integer.toString(mPushupCount),
				TextToSpeech.QUEUE_FLUSH, null);

		TextView tvPushupCount = (TextView) findViewById(R.id.txtPushupCount);
		tvPushupCount.setText(Integer.toString(mPushupCount));



	}

	private PushupState getNewPushupState(Transition transition,
										  PushupState prevState) {
		PushupState newState = null;
		switch (prevState) {
			case MOVING_DOWN:
				if (transition == Transition.STOPPED) {
					newState = PushupState.STOPPED_BOTTOM;
				}
				break;
			case STOPPED_TOP:
				if (transition == Transition.DOWN) {
					newState = PushupState.MOVING_DOWN;
				}
				break;
			case STOPPED_BOTTOM:
				if (transition == Transition.UP) {
					newState = PushupState.MOVING_UP;
				}
				break;
			case MOVING_UP:
				if (transition == Transition.STOPPED) {
					newState = PushupState.STOPPED_TOP;
				}
				break;
		}
		return newState;
	}
}