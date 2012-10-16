package environment;

public class Heater {
	
private double thermostatValue;
private double thermostatOverheatValue;
private double heatingFactorPerAreaUnit;

	public Heater(double thermostatValue, double thermostatOverheatValue, double heatingConstant){
		this.thermostatValue = thermostatValue;
		this.heatingFactorPerAreaUnit = heatingConstant;
	}
	
	public boolean isTurnedOn(double outsideTemp){
		if(outsideTemp <= thermostatValue + thermostatOverheatValue)
			return true;
		return false;
	}
	
	public double heatGainPerAreaUnit(double outsideTemp){
		if(this.isTurnedOn(outsideTemp))
			return heatingFactorPerAreaUnit;
		return 0.0;
	}
	
}
