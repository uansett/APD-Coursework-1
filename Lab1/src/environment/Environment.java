package environment;

public class Environment {
protected double temperature;
protected double temperatureLeakConstant;


public double getTemperature(){
	return this.temperature;
}

public void decreaseTemperature(){
	this.temperature -= temperatureLeakConstant;
}

public Environment(double temperature, double leakConstant){
	this.temperature = temperature;
	this.temperatureLeakConstant = leakConstant;
}
}
