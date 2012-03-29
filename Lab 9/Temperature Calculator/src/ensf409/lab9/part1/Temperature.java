package ensf409.lab9.part1;

public class Temperature {
	
	public enum TemperatureType {
		TemperatureTypeCelsius,
		TemperatureTypeFahrenheit
	}

	private double temperature;
	private TemperatureType type;

	public Temperature( double aTemperature, TemperatureType aType )
	{
		this.temperature = aTemperature;
		this.type = aType;
	}

	public double toCelsius()
	{
		double temp = 0.0;

		switch( this.type )
		{
			case TemperatureTypeCelsius:
				temp = this.temperature;
				break;
			case TemperatureTypeFahrenheit:
				temp = (this.temperature - 32) * 100 / 180;
				break;
		}

		return temp;
	}

	public double toFahrenheit()
	{
		double temp = 0.0;

		switch ( this.type )
		{
			case TemperatureTypeCelsius:
				temp = (this.temperature * 180 / 100 ) + 32;
				break;
			case TemperatureTypeFahrenheit:
				temp = this.temperature;
				break;
			default:
				break;	
		}

		return temp;
	}

	public double getTemperature()
	{
		return this.temperature;
	}

	public TemperatureType getTemperatureType()
	{
		return this.type;
	}
}
