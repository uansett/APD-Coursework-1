package environment;

public class Heater {
	
private double thermostatValue;
private double thermostatOverheatValue;
private double heatingFactorPerSqMtr;

	public Heater(double thermostatValue, double thermostatOverheatValue, double heatingConstant){
		this.thermostatValue = thermostatValue;
		this.heatingFactorPerSqMtr = heatingConstant;
	}
	
	public double heatGainPerSqMtr(double roomTemp){
		if(roomTemp <= thermostatValue + thermostatOverheatValue)
			return heatingFactorPerSqMtr;
		return 0.0;
	}
	
}
