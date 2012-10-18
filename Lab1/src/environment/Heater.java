package environment;

public class Heater {
	
private double thermostatValue;
private double thermostatOverheatValue;
private double heatingFactorPerAreaUnit;
private Room containerRoom;

	public Heater(double thermostatValue, double thermostatOverheatValue, double heatingConstant){
		this.thermostatValue = thermostatValue;
		this.heatingFactorPerAreaUnit = heatingConstant;
	}
	
	public void moveToRoom(Room containerRoom){
		this.containerRoom = containerRoom;
	}
	
	public boolean isTurnedOn(double outsideTemp){
		if(outsideTemp <= thermostatValue + thermostatOverheatValue)
			return true;
		return false;
	}
	
	public void heatRoom(){
		if(containerRoom != null){
			if(this.isTurnedOn(this.containerRoom.temperature)){
				this.containerRoom.temperature += heatingFactorPerAreaUnit / this.containerRoom.getArea();
			}
		}
		
		return;
	}
	
}
