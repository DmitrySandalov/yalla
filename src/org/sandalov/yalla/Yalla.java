package org.sandalov.yalla;

import org.sandalov.yalla.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Yalla extends Activity {
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.app_about);
		menu.add(0, 1, 1, R.string.str_exit);
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
			case 1:
				exitOptionsDialog();
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
	
	private void exitOptionsDialog() {			
		new AlertDialog.Builder(this)
			.setTitle(R.string.app_exit)
			.setMessage(R.string.app_exit_message)
			.setNegativeButton(R.string.str_no,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i)	{}
				}
			)
			.setPositiveButton(R.string.str_ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface, int i) {
							finish();
						}
					}
			)
			.show();
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}