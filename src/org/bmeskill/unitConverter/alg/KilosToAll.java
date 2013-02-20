package org.bmeskill.unitConverter.alg;

public class KilosToAll {

	public KilosToAll() {
		super();
	}

	public double convert(int toType, double input) {
		double result = 0.0;
		switch(toType) {
			case 0:
				result = kilosToMilligrams(input);
				break;
			case 1:
				result = kilosToGrams(input);
				break;
			case 2:
				result = input;
				break;
			case 3:
				result = kilosToOunces(input);
				break;
			case 4:
				result = kilosToPounds(input);
				break;
			case 5:
				result = kilosToStone(input);
				break;
		}
		return result;
	}

	private double kilosToStone(double input) {
		double lb =0.0;
		if(input != 0.0)
			lb = (input * 0.157473044);
		
		return lb;
	}

	private double kilosToPounds(double input) {
		double lb =0.0;
		if(input != 0.0)
			lb = (input * 2.20462262);
		
		return lb;
	}

	private double kilosToOunces(double input) {
		double oz =0.0;
		if(input != 0.0)
			oz = (input * 35.2739619);
		
		return oz;
	}

	private double kilosToGrams(double input) {
		double g =0.0;
		if(input != 0.0)
			g = (input * 1000);
		
		return g;
	}

	private double kilosToMilligrams(double input) {
		double mg =0.0;
		if(input != 0.0)
			mg = (input * 1000000);
		
		return mg;
	}

}
