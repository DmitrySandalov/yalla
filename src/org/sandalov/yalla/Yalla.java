package org.sandalov.yalla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.sandalov.yalla.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;

public class Yalla extends Activity {
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.app_about);		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
			case 0:
				openOptionsDialog();
				break;
		}
		return true;
	}
	
	private void openOptionsDialog() {
		new AlertDialog.Builder(this)
			.setTitle(R.string.app_about)
			.setMessage(R.string.app_about_message)
			.setPositiveButton(R.string.str_ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i)	{}
				}
			)
			.show();
	}

	public void placeholderDialog(View view) {
		new AlertDialog.Builder(this)
			.setTitle(R.string.placeholder_title)
			.setMessage(R.string.placeholder_message)
			.setPositiveButton(R.string.str_ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i)	{}
				}
			)
			.show();
	}
	
	public void openFile(View view) {
		try{
			   File f = new File(Environment.getExternalStorageDirectory()+"/filename.txt");			 
			   FileInputStream fileIS = new FileInputStream(f);			 
			   BufferedReader buf = new BufferedReader(new InputStreamReader(fileIS));			 
			   String readString = new String();			 
			   //just reading each line and pass it on the debugger			 
			   while((readString = buf.readLine())!= null){			 
			      Log.d("line: ", readString);			 
			   }			 
			} catch (FileNotFoundException e) {			 
			   e.printStackTrace();			 
			} catch (IOException e){			 
			   e.printStackTrace();			 
			}
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}