package org.bmeskill.unitConverter.alg;

public class MassConverter {
	
	public MassConverter() {
		super();
	}
	
	public Double convert(int fromType, int toType, double input) {
		if(fromType == toType)
    		return input;
		
		else if((fromType <= 2) && (toType <= 2)) { //metric conversion
			return metricConversion(fromType, toType, input);
		}
		
		else if((fromType > 2) && (toType > 2)) { //imperial conversion
			return impConversion(fromType, toType, input);
		}
		
		else { //cross conversion
			return crossConversion(fromType, toType, input);
		}
    	
	}

	private Double metricConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		if(fromType == toType)
    		return input;
		
		else if(fromType == 0 && toType == 1)
			toReturn = (input / 1000.0);
		
		else if(fromType == 0 && toType == 2)
			toReturn = (input / 1000000.0);
		
		else if(fromType == 1 && toType == 0)
			toReturn = (input * 1000.0);
		
		else if(fromType == 1 && toType == 2)
			toReturn = (input / 1000.0);
		
		else if(fromType == 2 && toType == 0)
			toReturn = (input * 1000000.0);
		
		else if(fromType == 2 && toType == 1)
			toReturn = (input * 1000.0);
		
		return toReturn;
	}
	
	private Double impConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		if(fromType == toType)
    		return input;
		
		else if(fromType == 3 && toType == 4)
			toReturn = (input / 16.0);
		
		else if(fromType == 3 && toType == 5)
			toReturn = (input / 224.0);
		
		else if(fromType == 4 && toType == 3)
			toReturn = (input * 16.0);
		
		else if(fromType == 4 && toType == 5)
			toReturn = (input / 14.0);
		
		else if(fromType == 5 && toType == 3)
			toReturn = (input * 224.0);
		
		else if(fromType == 5 && toType == 4)
			toReturn = (input * 14.0);
		
		return toReturn;
	}
	
	private Double crossConversion(int fromType, int toType, double input) {
		Double toReturn = 0.0;
		KilosToAll kg_to_other = new KilosToAll();
		AllToKilos other_to_kg = new AllToKilos();
		if(fromType < 3) {//going from metric to imperial
			Double temp = metricConversion(fromType, 2, input); //ensure input is kg
			toReturn = kg_to_other.convert(toType, temp);
		}
		else if(toType == 2){//going from imperial to kg
			toReturn = other_to_kg.convert(fromType, input);
		}
		else { //going from imperial to non-kg metric
			Double temp = other_to_kg.convert(fromType, input);
			toReturn = metricConversion(2, toType, temp);
		}
		return toReturn;
	}
}