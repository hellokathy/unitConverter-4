package org.bmeskill.unitConverter;

import java.text.DecimalFormat;

import org.bmeskill.unitConverter.alg.MassConverter;
import org.bmeskill.unitConverter.R;

import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MassActivity extends UcBaseActivity {
	final Context context = this;
	private Double input = 0.0, output = 0.0;
	private EditText dataIn;
	private Spinner spinnerFrom, spinnerTo;
	private MassConverter massConvert;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.masstab);
	
	    spinnerFrom = (Spinner) findViewById(R.id.SpinnerFrom);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weights,	android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerFrom.setAdapter(adapter);
	    
	    spinnerTo = (Spinner) findViewById(R.id.SpinnerTo);
	    spinnerTo.setAdapter(adapter);
	
	    final Button button = (Button) findViewById(R.id.Go_Button);
	    button.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	calculate();
	        }
	    });
    }
    private void calculate() {
    	String[] tempArray;
    	String resultString;
    	massConvert = new MassConverter();
    	
    	dataIn = (EditText) findViewById(R.id.TextInput);
    	try {
	    	input = Double.valueOf(dataIn.getText().toString());
	    	
	    	int fromType = (int)spinnerFrom.getSelectedItemId();
	    	int toType = (int)spinnerTo.getSelectedItemId();
	    	
	    	output = massConvert.convert(fromType,toType,input); 	
			
			tempArray = getResources().getStringArray(R.array.weights);
			resultString = new DecimalFormat("#.########").format(output);
			resultString = (resultString + " " + tempArray[toType]);
			System.out.println(resultString);
			displayResult(resultString, context);
    	}
    	
    	catch (NumberFormatException e) {
    		displayNotice("Invalid Input");
    	}
    }
}