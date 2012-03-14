package org.sandalov.yalla;

import org.sandalov.yalla.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent i = new Intent(Yalla.this, YallaLoad.class);
            startActivity(i);
            }
         });
    }
}