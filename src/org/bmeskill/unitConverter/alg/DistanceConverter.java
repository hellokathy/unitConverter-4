package org.bmeskill.unitConverter.alg;

public class DistanceConverter {
	
	public DistanceConverter() {
		super();
	}

	public Double convert(int fromType, int toType, double input) {
		if(fromType == toType)
    		return input;
		
		else if((fromType <= 3) && (toType <= 3)) { //metric conversion
			return metricConversion(fromType, toType, input);
		}
		
		else if((fromType > 3) && (toType > 3)) { //imperial conversion
			return impConversion(fromType, toType, input);
		}
		
		else { //cross conversion
			return crossConversion(fromType, toType, input);
		}
    	
	}

	private Double crossConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		MetresToAll m2a = new MetresToAll();;
		AllToMetres a2m = new AllToMetres();
		if(fromType < 4) {//going from metric to imperial
			Double temp = metricConversion(fromType, 2, input); //ensure input is metre
			toReturn = m2a.convert(toType, temp);
		}
		else if(toType == 3){//going from imperial to metre
			toReturn = a2m.convert(fromType, input);
		}
		else { //going from imperial to non-metre metric
			Double temp = a2m.convert(fromType, input);
			toReturn = metricConversion(3, toType, temp);
		}
		return toReturn;
	}

	private Double impConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		if(fromType == toType)
    		return input;
		
		switch(fromType) {
		case 4:
			switch(toType) {
				case 5: //in to ft
					toReturn = (input / 12.0);
					break;
				case 6: //in to yd
					toReturn = (input / 36.0);
					break;
				case 7: //in to mi
					toReturn = (input / 63360.0);
					break;
			}
			break;
		case 5:
			switch(toType) {
				case 4: //ft to in
					toReturn = (input * 12.0);
					break;
				case 6: //ft to yd
					toReturn = (input / 3.0);
					break;
				case 7: //ft to mi
					toReturn = (input / 5280.0);
					break;
			}
			break;
		case 6:
			switch(toType) {
				case 4: //yd to in
					toReturn = (input * 36.0);
					break;
				case 5: //yd to ft
					toReturn = (input * 3.0);
					break;
				case 7: //yd to mi
					toReturn = (input / 1760.0);
					break;
			}
			break;
		case 7:
			switch(toType) {
				case 4: //mi to in
					toReturn = (input * 63360.0);
					break;
				case 5: //mi to ft
					toReturn = (input * 5280.0);
					break;
				case 6: //mi to yd
					toReturn = (input * 1760.0);
					break;
			}
			break;
		}
		
		return toReturn;
	}

	private Double metricConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		if(fromType == toType)
    		return input;
		
		switch(fromType) {
		case 0:
			switch(toType) {
				case 1: //in to ft
					toReturn = (input / 10.0);
					break;
				case 2: //in to m
					toReturn = (input / 1000.0);
					break;
				case 3: //in to km
					toReturn = (input / 1000000.0);
					break;
			}
			break;
		case 1:
			switch(toType) {
				case 0: //ft to in
					toReturn = (input * 10.0);
					break;
				case 2: //ft to m
					toReturn = (input / 100.0);
					break;
				case 3: //ft to km
					toReturn = (input / 100000.0);
					break;
			}
			break;
		case 2:
			switch(toType) {
				case 0: //m to in
					toReturn = (input * 1000.0);
					break;
				case 1: //m to ft
					toReturn = (input * 100.0);
					break;
				case 3: //m to km
					toReturn = (input / 1000.0);
					break;
			}
			break;
		case 3:
			switch(toType) {
				case 0: //km to in
					toReturn = (input * 1000000.0);
					break;
				case 1: //km to ft
					toReturn = (input * 100000.0);
					break;
				case 2: //km to m
					toReturn = (input * 1000.0);
					break;
			}
			break;
		}
		
		return toReturn;
	}
}