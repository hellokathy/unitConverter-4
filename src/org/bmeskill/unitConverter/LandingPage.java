package org.bmeskill.unitConverter;

import org.bmeskill.unitConverter.R;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class LandingPage extends ListActivity {
	Intent intent;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, getResources().getStringArray(R.array.conversion_types)));

	    displayNotice();
	}
	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		switch (position) {
		case 0:
			intent = new Intent().setClass(parent.getContext(), DistanceActivity.class);
			break;
		case 1:
			intent = new Intent().setClass(parent.getContext(), SpeedActivity.class);
			break;
		case 2:
			intent = new Intent().setClass(parent.getContext(), MassActivity.class);
			break;
		case 3:
			intent = new Intent().setClass(parent.getContext(), FuelActivity.class);
			break;
		}
    	startActivity(intent);
    } 
	
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
	public void displayNotice() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		String message = "This app truncates answers at 8 decimal places!";
		// set title
		alertDialogBuilder.setTitle("Info");
 
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

