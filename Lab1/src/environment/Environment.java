package environment;

public class Environment {
protected double temperature;
protected double leakConstant;


public double getTemperature(){
	return this.temperature;
}

public void decreaseTemperature(){
	this.temperature -= leakConstant;
}

public Environment(double temperature, double leakConstant){
	this.temperature = temperature;
	this.leakConstant = leakConstant;
}
}
