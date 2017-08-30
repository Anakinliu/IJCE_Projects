package com.tedu.registdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends Activity{
	
	private EditText usrName;
	private EditText usrPwd;
	private Button btnRegist;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		init();
		
	}
	
	private void init(){
		usrName=(EditText)findViewById(R.id.edtName);
		usrPwd=(EditText)findViewById(R.id.edtPwd);
		btnRegist=(Button)findViewById(R.id.btnRegist);
		
		btnRegist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
			}
		});
		
	}

}
