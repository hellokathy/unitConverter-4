package org.bmeskill.unitConverter.alg;

public class MetresToAll {

	public MetresToAll() {
		super();
	}
	
	public Double convert(int toType, Double input) {
		double result = 0.0;
		switch(toType) {
			case 0:
				result = metersToMillimeters(input);
				break;
			case 1:
				result = metersToCentimeters(input);
				break;
			case 2:
				result = input;
				break;
			case 3:
				result = metersToKilometers(input);
				break;
			case 4:
				result = metersToInches(input);
				break;
			case 5:
				result = metersToFeet(input);
				break;
			case 6:
				result = metersToYards(input);
				break;
			case 7:
				result = metersToMiles(input);
				break;
		}
		return result;
	}
	public double metersToCentimeters(double metres) {
		double cm =0.0;
		if(metres != 0.0)
			cm = (metres * 100);
		
		return cm;
	}
	
	public double metersToMillimeters(double metres) {
		double mm =0.0;
		if(metres != 0.0)
			mm = (metres * 1000);
		
		return mm;
	}
	
	public double metersToKilometers(double metres) {
		double km =0.0;
		if(metres != 0.0)
			km = (metres / 1000);
		
		return km;
	}
	
	public double metersToInches(double metres) {
		double in =0.0;
		if(metres != 0.0)
			in = (metres * 39.3700787);
		
		return in;
	}
	
	public double metersToFeet(double metres) {
		double ft =0.0;
		if(metres != 0.0)
			ft = metersToInches(metres) /12;
		
		return ft;
	}

	public double metersToYards(double metres) {
		double yd =0.0;
		if(metres != 0.0)
			yd = metersToInches(metres) /36;
		
		return yd;
	}
	
	public double metersToMiles(double metres) {
		double mile =0.0;
		if(metres != 0.0)
			mile = metersToInches(metres) /63360;
		
		return mile;
	}
}
