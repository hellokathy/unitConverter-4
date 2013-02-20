package org.bmeskill.unitConverter.alg;

public class MassConverter {
	private KilosToAll kg2a;
	private AllToKilos a2kg;
	
	public MassConverter() {
		super();
		this.kg2a = new KilosToAll();
		this.a2kg = new AllToKilos();
	}
	
	public Double convert(int fromType, int toType, double input) {
		double output = 0.0;
		if(fromType == toType)
    		output = input;
    	else if(fromType == 2){//converting from meters
    		output = kg2a.convert(toType,input);
    	}
    	else if(toType == 2){//converting to meters
    		output = a2kg.convert(fromType, input);
    	}
    	else {//converting non-meters to non-meters
    		double meters = a2kg.convert(fromType, input);
    		output = kg2a.convert(toType,meters);
    	}
		return output;
	}
}
