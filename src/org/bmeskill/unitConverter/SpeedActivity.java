package org.bmeskill.unitConverter;

import java.text.DecimalFormat;

import org.bmeskill.unitConverter.alg.*;
import org.bmeskill.unitConverter.R;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SpeedActivity extends UcBaseActivity {
	final Context context = this;
	private Spinner spinnerFromDist,spinnerFromTime,spinnerToDist,spinnerToTime;
	private Double input = 0.0, output = 0.0;
	private EditText dataIn;
	private SpeedConverter speedConvert;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.speedtab);

        spinnerFromDist = (Spinner) findViewById(R.id.SpinnerFromDist);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distances,	android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.times,	android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromDist.setAdapter(adapter);
        
        spinnerFromTime = (Spinner) findViewById(R.id.SpinnerFromTime);
        spinnerFromTime.setAdapter(adapter2);
        
        spinnerToDist = (Spinner) findViewById(R.id.SpinnerToDist);
        spinnerToDist.setAdapter(adapter);
        
        spinnerToTime = (Spinner) findViewById(R.id.SpinnerToTime);
        spinnerToTime.setAdapter(adapter2);

        final Button button = (Button) findViewById(R.id.Go_Button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	calculate();
            }
        });
    }
    private void calculate() {
    	String[] timeTempArray;
    	String[] distTempArray;
    	String resultString;
    	speedConvert = new SpeedConverter();
    	dataIn = (EditText) findViewById(R.id.TextInput);
    	try {
	    	input = Double.valueOf(dataIn.getText().toString());
	    	
	    	int distFromType = (int)spinnerFromDist.getSelectedItemId();
	    	int distToType = (int)spinnerToDist.getSelectedItemId();
	    	int timeFromType = (int)spinnerFromTime.getSelectedItemId();
	    	int timeToType = (int)spinnerToTime.getSelectedItemId();
	    	
	    	output = speedConvert.convert(distFromType,timeFromType,distToType,timeToType,input);
	
	    	timeTempArray = getResources().getStringArray(R.array.times);
	    	distTempArray = getResources().getStringArray(R.array.distances);
			resultString = new DecimalFormat("#.########").format(output);
			resultString = (resultString + " " + distTempArray[distToType]+ "/" + timeTempArray[timeToType]);
			System.out.println(resultString);
			displayResult(resultString, context);
	    }
		
		catch (NumberFormatException e) {
			displayNotice("Invalid Input");
		}
    }
}