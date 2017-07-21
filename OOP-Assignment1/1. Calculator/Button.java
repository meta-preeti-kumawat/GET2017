/**
 * 
 * @author Preeti Kumawat
 * Date: 20-07-2017
 * Class Name: Button
 *
 */
public class Button {
	private String value;
	private String type;
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setButtonPosition(){
		// to set position such as row and column for a particular button
		this.setButtonLayout(2,2,2,2);
	}
	
	/**
	 * @param row_index
	 * @param column_index
	 * @param height
	 * @param width
	 */
	public void setButtonLayout(int row_index, int column_index, int height, int width) {
		// this will set height and width of a button
	}
	
	public void buttonEvents(){
		// this will help to perform operations on buttons such as onclick event
		Calculator calculator = new Calculator();
		calculator.getInput(this.getValue());
	}
	
}
