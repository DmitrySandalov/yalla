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
import android.widget.TextView;


public class YallaLoad extends Activity {
	ArrayList<String> wordsInFile = new ArrayList<String>();
	   
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
	
	public void openFile() {		
		try{
			   File f = new File(Environment.getExternalStorageDirectory()+"/yalla/Dictionary.dic");
			   FileInputStream fileIS = new FileInputStream(f);
			   BufferedReader buf = new BufferedReader(new InputStreamReader(fileIS));
			   String readString = new String();
			   while((readString = buf.readLine())!= null){				   
				   wordsInFile.add(readString);
			   }
//			   for (int i=0; i<wordsInFile.size(); i++) {
//				   Log.d("yalla", wordsInFile.get(i));
//			   }
			} catch (FileNotFoundException e) {
			   e.printStackTrace();
			} catch (IOException e){
			   e.printStackTrace();
			}
	}
	

	public void nextWord() {
		TextView tv = (TextView) findViewById(R.id.textView1);
		int randomNum = (int) Math.ceil(Math.random() * wordsInFile.size()-1);
		tv.setText(wordsInFile.get(randomNum));
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setText("--==[Tap to translate]==--");
	}
	
	public void nextWord(View view) {
		nextWord();
	}
	
	public void secondWordClick(View view) {
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setText("Translated!");
	}	
	
   public void onCreate(Bundle icicle)
   {
      super.onCreate(icicle);
      setContentView(R.layout.yallaload);
      openFile();
      nextWord();      
      Button exit = (Button) findViewById(R.id.btnClick2);
      exit.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
         setResult(RESULT_OK);
         finish();
         }
      });
   }
}