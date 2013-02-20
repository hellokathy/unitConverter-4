package org.bmeskill.unitConverter.alg;

public class FuelConverter {

	public Double convert(int fromType, int toType, Double input) {
		double output = 0.0;
		if(fromType == toType)
			return input;
		switch(fromType) {
			case 0:	//from l/100km
				switch(toType) {
				case 1://to m/usg
					output = 235.215 / input;
					break;
				case 2://to m/ig
					output = 282.481 / input;
					break;
				}
				break;
			case 1:	//from m/usg
				switch(toType) {
				case 0://to l/100km
					output = 235.215 / input;
					break;
				case 2://to m/ig
					output = 1.20095 * input;
					break;
				}
				break;
			case 2:	//from m/ig
				switch(toType) {
				case 0://to l/100km
					output = 282.481 / input;
					break;
				case 1://to m/usg
					output = input  * 0.832674;
					break;
				}
				break;
		}
		return output;
	}

}
