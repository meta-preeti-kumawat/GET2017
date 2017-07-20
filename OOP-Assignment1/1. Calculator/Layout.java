import java.util.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Date: 20-07-2017
 * Class Name: Layout
 *
 */
public class Layout {
	// default size of calculator is 4 * 4
	private int numberOfRows = 4; 
	private int numberOfColumns = 4;
	private ArrayList<Button> buttonList;
	
	public Layout getLayout(){
		// get layout of calculator in case of GUI
		/* This helps to know number of rows and columns in calculator 
		 * along with buttons available at particular position
		 */
		return this;
	}
	
	public void setLayout(int numberOfRows, int numberOfColumns){
		// set a layout for calculator in case of GUI
		// here buttons can be set
		Button button = new Button();
		button.setButtonPosition();
	}
	
	/**
	 * @return numberOfRows
	 */
	public int getNumberOfRows(){
		//returns number of 
		return numberOfRows;
	}
	
	/**
	 * @return numberOfColumns
	 */
	public int getNumberOfColumns(){
		return numberOfColumns;
	}
	
	/**
	 * @param row
	 * @param column
	 * @return Button object
	 */
	public Button getButtonAt(int row, int column){
		Button button = new Button();
		// this methods helps to find button at a particular location
		
		return button;
	}
}
