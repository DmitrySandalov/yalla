package org.sandalov.yalla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;


public class YallaLoad extends Activity {
	public void placeholderDialogCustomText(String text) {
		new AlertDialog.Builder(this)
			.setTitle(R.string.placeholder_title)
			.setMessage(text)
			.setPositiveButton(R.string.str_ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i)	{}
				}
			)
			.show();
	}
	
	public void openFile(View view) {		
		try{
			   File f = new File(Environment.getExternalStorageDirectory()+"/yalla/Dictionary.dic");
			   FileInputStream fileIS = new FileInputStream(f);
			   BufferedReader buf = new BufferedReader(new InputStreamReader(fileIS));
			   String readString = new String();
			   ArrayList<String> wordsInFile = new ArrayList<String>();
			   while((readString = buf.readLine())!= null){				   
				   wordsInFile.add(readString);
			   }
//			   for (int i=0; i<wordsInFile.size(); i++) {
//				   Log.d("yalla", wordsInFile.get(i));
//			   }
			   int randomNum = (int) Math.ceil(Math.random() * wordsInFile.size()-1);
			   placeholderDialogCustomText(wordsInFile.get(randomNum));
			} catch (FileNotFoundException e) {
			   e.printStackTrace();
			} catch (IOException e){
			   e.printStackTrace();
			}
	}
	
   public void onCreate(Bundle icicle)
   {
      super.onCreate(icicle);
      setContentView(R.layout.yallaload);
      Button b = (Button) findViewById(R.id.btnClick2);
      b.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
         setResult(RESULT_OK);
         finish();
         }
      });
   }
}