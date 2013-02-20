package org.bmeskill.unitConverter.alg;

public class DistanceConverter {
	private MetresToAll m2a;
	private AllToMetres a2m;
	
	public DistanceConverter() {
		super();
		this.m2a = new MetresToAll();
		this.a2m = new AllToMetres();
	}

	public Double convert(int fromType, int toType, double input) {
		double output = 0.0;
		if(fromType == toType)
    		output = input;
    	else if(fromType == 2){//converting from meters
    		output = m2a.convert(toType,input);
    	}
    	else if(toType == 2){//converting to meters
    		output = a2m.convert(fromType, input);
    	}
    	else {//converting non-meters to non-meters
    		double meters = a2m.convert(fromType, input);
    		output = m2a.convert(toType,meters);
    	}
		return output;
	}
}
