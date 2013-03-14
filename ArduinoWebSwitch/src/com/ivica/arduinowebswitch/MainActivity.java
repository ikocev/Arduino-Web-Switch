package com.ivica.arduinowebswitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	ToggleButton tgbtn;
	TextView textView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		tgbtn = (ToggleButton) findViewById(R.id.toggleButton1);
		
		tgbtn.setOnClickListener(new View.OnClickListener() {
			
		    @Override
		    public void onClick(View v) {
		    	textView1.setText("");
		        if (tgbtn.isChecked()) {
		        	HttpClient client = new DefaultHttpClient();
		        	HttpGet request = new HttpGet("http://85.130.114.182/?5");
		        	HttpResponse response;
					try {
						response = client.execute(request);
						// Get the response
			        	BufferedReader rd = new BufferedReader
			        	  (new InputStreamReader(response.getEntity().getContent()));
			        	String line = "";
			        	while ((line = rd.readLine()) != null) {
			        		textView1.append(line);
			        	} 
			        	
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        } else {
		        	
		        	HttpClient client = new DefaultHttpClient();
		        	HttpGet request = new HttpGet("http://85.130.114.182/?6");
		        	HttpResponse response;
					try {
						response = client.execute(request);
						// Get the response
			        	BufferedReader rd = new BufferedReader
			        	  (new InputStreamReader(response.getEntity().getContent()));
			        	String line = "";
			        	while ((line = rd.readLine()) != null) {
			        		textView1.append(line);
			        	} 
			        	
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
