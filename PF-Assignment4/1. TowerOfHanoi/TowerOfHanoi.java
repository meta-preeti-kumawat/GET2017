import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author Preeti Kumawat
 * Class Name: TowerOfHanoi
 * Date: 18-07-2017
 *
 */
public class TowerOfHanoi {
	ArrayList<String> listOfMovements = new ArrayList<String>(); 
	
	/**
	 * @param source
	 * @param destination
	 * @param auxiliary
	 * @param numberOfDisk
	 * @return ArrayList<String>
	 */
	ArrayList<String> towerOfHanoi(String source, String destination, String auxiliary, int numberOfDisk){
		
		if(numberOfDisk==1){
			listOfMovements.add("Move Disk "+numberOfDisk+" from "+source+" to "+destination);
		}
		else if(numberOfDisk > 1){
			towerOfHanoi(source, auxiliary, destination, numberOfDisk-1);
			listOfMovements.add("Move Disk "+numberOfDisk+" from "+source+" to "+destination);
			towerOfHanoi(auxiliary, destination, source, numberOfDisk-1);
		}
		else if(numberOfDisk<0){
			throw new InputMismatchException();
		}
		
		return listOfMovements;
	}

}
