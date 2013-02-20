package org.bmeskill.unitConverter.alg;

public class SpeedConverter {

	private DistanceConverter distConvert = new DistanceConverter();
	public Double convert(int distFromType, int timeFromType,int distToType, int timeToType, Double input) {
		double output = 0.0;
		if(timeFromType == timeToType) {
			if(distFromType == distToType){
				return input;
			}
			else {
				return distConvert.convert(distFromType,distToType,input);
			}
		}
		
		else {
			if(distFromType == distToType){
				return timeOnlyConversion(timeFromType, timeToType,input);
			}
			
			else {
				output = timeOnlyConversion(timeFromType, timeToType, input);
				return distConvert.convert(distFromType,distToType,output);
			}
			
		}
	}
	
	
	private Double timeOnlyConversion(int fromType, int toType, double input) {
		/* 
		 * Note: multiplier and divider signs are swapped from
		 * whats "obvious" because this is specific to speed
		 * i.e. its the denominator part of m/s km/h etc
		 * 10m/s is same as 600m/min
		 */
		double output = 0.0;
		if(fromType == toType)
			return input;
		switch(fromType) {
			case 0:	//from seconds
				switch(toType) {
				case 1: //to minutes
					output = input * 60;
					break;
				case 2: //to hours 
					output = input * 3600;
					break;
				case 3: // to days
					output = input * 86400;
					break;
				}
				break;
			case 1: //from minutes
				switch(toType) {
				case 0:
					output = input / 60;
					break;
				case 2:
					output = input * 60;
					break;
				case 3:
					output = input * 1440;
					break;
				}
				break;
			case 2: //from hours
				switch(toType) {
				case 0:
					output = input / 3600;
					break;
				case 1:
					output = input / 60;
					break;
				case 3:
					output = input * 24;
					break;
				}
				break;
			case 3: //from days
				switch(toType) {
				case 1:
					output = input / 86400;
					break;
				case 2:
					output = input / 1440;
					break;
				case 3:
					output = input / 24;
					break;
				}
				break;
				
		}
		return output;
	}
}
