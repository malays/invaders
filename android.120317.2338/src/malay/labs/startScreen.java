package malay.labs;

//import processing.core.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Button;
import android.view.*;
import android.content.Intent;
import android.content.SharedPreferences;

public class startScreen extends Activity implements View.OnClickListener  {
	SeekBar shipSpeed, bulletSpeed;
	Button btnsave;	
	int nshipSpeed = 10, nbulletSpeed = 20;
	SharedPreferences spf ;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_screen);
		shipSpeed = (SeekBar)findViewById(R.id.shipSpeed);
		bulletSpeed = (SeekBar)findViewById(R.id.bulletSpeed);
		btnsave=(Button)findViewById(R.id.button1);		
		btnsave.setOnClickListener(this);
		spf = getSharedPreferences("speed", MODE_PRIVATE);
		nshipSpeed = spf.getInt("shipSpeed", 10);
		nbulletSpeed = spf.getInt("bulletSpeed", 20);
		shipSpeed.setProgress(nshipSpeed);
		bulletSpeed.setProgress(nbulletSpeed);
	}
	@Override	
	public void onClick(View v) {		
		nshipSpeed = shipSpeed.getProgress();
		nbulletSpeed = bulletSpeed.getProgress();
		SharedPreferences.Editor spfEditor = spf.edit();
		spfEditor.putInt("shipSpeed", nshipSpeed);
		spfEditor.putInt("bulletSpeed", nbulletSpeed);
		spfEditor.commit();
		Intent intent = new Intent(this,Invaders2.class);
		startActivity(intent);
		finish();
	}
}
