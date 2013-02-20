package org.bmeskill.unitConverter.alg;

public class AllToMetres {

	public AllToMetres() {
		super();
	}
	
	public double millimetersToMeters(double mm) {
		double meters =0.0;
		if(mm != 0.0)
			meters = (mm / 1000);
		
		return meters;
	}
	public double centimetersToMeters(double cm) {
		double meters =0.0;
		if(cm != 0.0)
			meters = (cm / 100);
		
		return meters;
	}
	
	public double kilometersToMeters(double km) {
		double meters =0.0;
		if(km != 0.0)
			meters = (km * 1000);
		
		return meters;
	}
	
	public double inchesToMeters(double in) {
		double meters =0.0;
		if(in != 0.0)
			meters = (in / 39.3700787);
		
		return meters;
	}
	
	public double feetToMeters(double ft) {
		return inchesToMeters(ft*12);
	}

	public double yardsToMeters(double yd) {
		return inchesToMeters(yd*36);
	}
	
	public double milesToMeters(double ml) {
		return inchesToMeters(63360*ml);
	}

	public double convert(int fromType, Double input) {
		double result = 0.0;
		switch(fromType) {
		case 0:
			result = millimetersToMeters(input);
			break;
		case 1:
			result = centimetersToMeters(input);
			break;
		case 2:
			result = input;
		case 3:
			result = kilometersToMeters(input);
			break;
		case 4:
			result = inchesToMeters(input);
			break;
		case 5:
			result = feetToMeters(input);
			break;
		case 6:
			result = yardsToMeters(input);
			break;
		case 7:
			result = milesToMeters(input);
			break;
	}
		return result;
	}
}
