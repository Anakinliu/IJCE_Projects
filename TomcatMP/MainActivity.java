package com.tedu.registdemo;

import java.util.jar.Attributes.Name;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private EditText usrName;
	private EditText usrPwd;
	private Button btnLogin;
	private TextView txtRegist;
	
	
	//定义一个弹窗
	private ProgressDialog pd;
	
	
	//用户名密码
	public String name;
	 String pwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	
		
		
	}
	
	
	private void init(){
		
		usrName=(EditText)findViewById(R.id.edtUsrName);
		usrPwd=(EditText)findViewById(R.id.edtUsrPwd);
		btnLogin=(Button)findViewById(R.id.btnLogin);
		txtRegist=(TextView)findViewById(R.id.txtRegist);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				name=usrName.getText().toString();
				pwd=usrPwd.getText().toString();
				
				
				
				checkLogin(name,pwd);
				
				
				
				
				/*Intent intent =new Intent();
				intent.setClass(MainActivity.this, SucessActivity.class);
				intent.putExtra("name", name);
				startActivity(intent);*/
				//Toast.makeText(MainActivity.this, "用户名："+name+"，密码："+pwd, 3000).show();
				
			}
		});
		
		txtRegist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent =new Intent();
				intent.setClass(MainActivity.this, RegistActivity.class);
				startActivity(intent);
				
			}
		});
		
		
	}
	
	
	//验证登录
	public void checkLogin(String name,String pwd){
		//弹框提示
		pd=ProgressDialog.show(MainActivity.this, 
				null, "登陆中。。。");
		pd.setCanceledOnTouchOutside(false);
		
		
		//1创建请求队列
		RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
		//2创建请求
		JsonObjectRequest request=new JsonObjectRequest(
				"http://192.168.1.101:8080/RegistDem/login?name="+name+"&pwd="+pwd, 
				null, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						dissmissDialog();
						
						//Toast.makeText(MainActivity.this, response.toString(), 3000).show();
						
						try {
							int resultCode=response.getInt("resultCode");
							
							if(resultCode==0){
								Intent intent =new Intent();
								intent.setClass(MainActivity.this, SucessActivity.class);
								intent.putExtra("name", MainActivity.this.name);
								startActivity(intent);
							}else if(resultCode==1){
								Toast.makeText(MainActivity.this, "密码错误，请重新输入！", 3000).show();
							}else if(resultCode==2){
								Toast.makeText(MainActivity.this, "用户未注册，请先注册！", 3000).show();
							}
						
						} catch (JSONException e) {
							e.printStackTrace();
						}
						
						
					}
					
					
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						dissmissDialog();
						Toast.makeText(MainActivity.this, "登录失败，请检查网络链接！", 3000).show();
					}
					
				});
		//3请求加入队列
		queue.add(request);
		
	}
	
	public void  dissmissDialog(){
		if(pd!=null&&pd.isShowing()){
			pd.dismiss();
		}
	}
	
	
}
