/**
 * 
 * @author Preeti Kumawat
 * Date: 20-07-2017
 * Class Name: Display
 *
 */
public class Display {
	private String outputString = "";
	
	public Display(String value){
		// check the value
		// append to previous value in outputString
			outputString += value;
		// until operator equals('=') is pressed 
			outputString = value;
		
	}
	
	public Display(Double value){
			outputString = value;
	}
	
}
