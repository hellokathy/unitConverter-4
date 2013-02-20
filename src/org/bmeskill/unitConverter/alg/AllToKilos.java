package org.bmeskill.unitConverter.alg;

public class AllToKilos {

	public AllToKilos() {
		super();
	}

	public double convert(int fromType, Double input) {
		double result = 0.0;
		switch(fromType) {
		case 0:
			result = milligramsToKilos(input);
			break;
		case 1:
			result = gramsToKilos(input);
			break;
		case 2:
			result = input;
		case 3:
			result = ouncesToKilos(input);
			break;
		case 4:
			result = poundsToKilos(input);
			break;
		case 5:
			result = stoneToKilos(input);
			break;
	}
		return result;
	}

	private double milligramsToKilos(Double input) {
		double mg =0.0;
		if(input != 0.0)
			mg = (input / 1000000);
		
		return mg;
	}

	private double gramsToKilos(Double input) {
		double g =0.0;
		if(input != 0.0)
			g = (input / 1000);
		
		return g;
	}

	private double ouncesToKilos(Double input) {
		double oz =0.0;
		if(input != 0.0)
			oz = (input * 0.0283495231);
		
		return oz;
	}

	private double poundsToKilos(Double input) {
		double lb =0.0;
		if(input != 0.0)
			lb = (input * 0.45359237);
		
		return lb;
	}

	private double stoneToKilos(Double input) {
		double stone =0.0;
		if(input != 0.0)
			stone = (input * 6.35029318);
		
		return stone;
	}

}
