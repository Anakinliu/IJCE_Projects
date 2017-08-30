package com.tedu.registdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SucessActivity extends Activity{
	
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);
		
		textView = (TextView)findViewById(R.id.txtSuccess);
		Intent intent = getIntent();
		if(intent!=null){
			textView.setText("»¶Ó­Äã£¬"+intent.getStringExtra("name"));
			
		}
		
		
		
		
	}

}
