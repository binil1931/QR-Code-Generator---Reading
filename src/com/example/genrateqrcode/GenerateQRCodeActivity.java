package com.example.genrateqrcode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.binil.qrcodegenreatinganddecoding.MainActivity;
import com.binil.qrcodegenreatinganddecoding.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class GenerateQRCodeActivity extends Activity implements OnClickListener{
	 
	 private String LOG_TAG = "GenerateQRCode";
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.main);
	 
	  Button button1 = (Button) findViewById(R.id.button1);
	  button1.setOnClickListener(this);
	 
	 }
	 
	 @SuppressLint("NewApi") public void onClick(View v) {
	 
	  switch (v.getId()) {
	  case R.id.button1:
	   EditText qrInput = (EditText) findViewById(R.id.qrInput);
	   String qrInputText = qrInput.getText().toString();
	   Log.v(LOG_TAG, qrInputText);
	 
	   //Find screen size
	   WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
	   Display display = manager.getDefaultDisplay();
	   Point point = new Point();
	   display.getSize(point);
	   int width = point.x;
	   int height = point.y;
	   int smallerDimension = width < height ? width : height;
	   smallerDimension = smallerDimension * 3/4;
	 
	   //Encode with a QR Code image
	   QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(qrInputText, 
	             null, 
	             Contents.Type.TEXT,  
	             BarcodeFormat.QR_CODE.toString(), 
	             smallerDimension);
	   try {
	    Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
	    ImageView myImage = (ImageView) findViewById(R.id.imageView1);
	    myImage.setImageBitmap(bitmap);
	 
	   } catch (WriterException e) {
	    e.printStackTrace();
	   }
	 
	 
	   break;
	 
	   // More buttons go here (if any) ...
	 
	  }
	 }
	 
	 @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
      
	  Intent i = new Intent(GenerateQRCodeActivity.this, MainActivity.class);
	  finish();
	  startActivity(i);
	 }
	 
	}