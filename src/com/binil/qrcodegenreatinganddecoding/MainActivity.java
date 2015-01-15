package com.binil.qrcodegenreatinganddecoding;

import com.binil.reading.quick_response_code.CaptureActivity;
import com.example.genrateqrcode.GenerateQRCodeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void reading(View v)
	{
		Intent i = new Intent(MainActivity.this,CaptureActivity.class);
		startActivity(i);
	}
	
	public void generating(View v)
	{
	  Intent i = new Intent(MainActivity.this, GenerateQRCodeActivity.class);
	  finish();
	  startActivity(i);
	}
}
