import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Temperature {
	
	/**
	 * This is a server program to convert Fahrenheit to celsius
	 * @param fahrenheit
	 * @return celsius double
	 */
	@WebMethod
	public double convertFahrenheitToCelsius(double fahrenheit){
		return (fahrenheit - 32) * 5 / 9;
	}
}
