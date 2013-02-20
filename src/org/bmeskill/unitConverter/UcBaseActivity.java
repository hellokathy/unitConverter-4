package org.bmeskill.unitConverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.*;;

public class UcBaseActivity extends Activity {
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.exit_menu, menu);
	    return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.menu_exit:
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void displayResult(final String resultValue, Context context) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
 
		// set title
		alertDialogBuilder.setTitle("Result!");
 
		// set dialog message
		alertDialogBuilder.setMessage(resultValue).setCancelable(false)
		.setPositiveButton("Back",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// if this button is clicked, close
				// current activity
				UcBaseActivity.this.finish();
			}
		})
		.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// if this button is clicked, just close
				// the dialog box and do nothing
				dialog.cancel();
			}
		})
		.setNeutralButton("Copy",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				cm.setPrimaryClip(ClipData.newPlainText(resultValue, resultValue));
				dialog.cancel();
			}
		});
		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
 
		// show it
		alertDialog.show();
	}
	
	public void displayNotice(String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		// set title
		alertDialogBuilder.setTitle("Warning");
 
		// set dialog message
		alertDialogBuilder.setMessage(message).setCancelable(false)
		.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// if this button is clicked, just close
				// the dialog box and do nothing
				dialog.cancel();
			}
		});
		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
 
		// show it
		alertDialog.show();
	}
}
