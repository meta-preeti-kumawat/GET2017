import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Preeti Kumawat
 * Date: 21-07-2017
 * Class Name: ReportGeneration
 */
public class ReportGeneration {
	private FileInputStream inputReportFile;
	private BufferedReader readParticipant;
	private String readText = new String();
	private int participantNumber;
	private ArrayList<String[]> reportStatus = new ArrayList<>();
	
	/**
	 * This is a constructor that generates both the reports
	 * @param reportLocation (location before the file name. e.g, src/)
	 * @param answers
	 */
	public ReportGeneration(String reportLocation, ArrayList<Questions> answers) 
			throws IOException {
		writeToReportB(reportLocation + "ReportB.txt", answers);
		writeToReportA(reportLocation + "ReportA.txt", answers);
	}
	
	/**
	 * @param number
	 */
	public void setParticipantNumber(int number){
		this.participantNumber = number;
	}
	
	/**
	 * this method reads the file to fetch total number of participants
	 * and store information about each participant
	 * @param reportLocation
	 */
	public void readReportBToFetchParticipants(String reportLocation){
		try{
			inputReportFile = new FileInputStream(reportLocation);
			readParticipant = new BufferedReader(new InputStreamReader(inputReportFile));
			readText = readParticipant.readLine();	
			int increasedParticipantNumber = 1;
			
			//if text is available then increase the number of participants
			while(readText != null){
				if("".equals(readText)){
					increasedParticipantNumber--;
				}
				else{
					reportStatus.add(readText.split(", "));
				}
				increasedParticipantNumber++;
				readText = readParticipant.readLine();
			}
			setParticipantNumber(increasedParticipantNumber);
			inputReportFile.close();
		}
		catch(IOException fileNotFound){
			setParticipantNumber(1); // if file not found then set participant as 1
		}
	}
	
	/**
	 * this method generates a report containing answers by different users
	 * @param reportLocation
	 * @param answers
	 */
	public void writeToReportB(String reportLocation, ArrayList<Questions> answers) 
		throws IOException{
		
		readReportBToFetchParticipants(reportLocation);
		File file =new File(reportLocation);
		if(!file.exists()){
    	   file.createNewFile();
    	}
    	BufferedWriter writeAnswer = new BufferedWriter(new FileWriter(file, true));
    	PrintWriter printAnswer = new PrintWriter(writeAnswer);
    	String content = "Participant " + this.participantNumber;
    	
    	//combine answers for each question by a particular participant
    	for (Iterator<Questions> iterator = answers.iterator(); iterator.hasNext();) {
    		Questions answer = (Questions) iterator.next();
			content += ", " + answer.getAnswer();
    	}
    	reportStatus.add(content.split(", "));
    	printAnswer.println(content);
    	printAnswer.close();
    	writeAnswer.close();
	}

	/**
	 * this method generates a report for single select questions
	 * and tells what percent of users chose which option
	 * @param reportLocation
	 * @param answers
	 */
	public void writeToReportA(String reportLocation, ArrayList<Questions> answers){
		
		try{
			String content = "";
	    	for (Iterator<Questions> iterator = answers.iterator(); iterator.hasNext();) {
	    		Questions answer = (Questions) iterator.next();
	    		if("Single Select".equals(answer.getQuestionType().getType())){
	    			int questionNumber = Integer.parseInt(answer.getCompleteQuestion().
	    									substring(1, 2));
	    			content += answer.getCompleteQuestion().split("\\.", 2)[1].trim();
	    			int[] countNumberOfParticipantForQuestion = 
	    					new int[answer.getQuestionOptions().length ];
	    			for (Iterator<String[]> iterateAnswers = this.reportStatus.iterator(); 
	    					iterateAnswers.hasNext();) {
	    				String[] answerStatus = (String[]) iterateAnswers.next();
	    				countNumberOfParticipantForQuestion[Integer.parseInt
	    				                                    (answerStatus[questionNumber])-1] ++;
	    			}
	    			for (int optionNumber = 0; optionNumber < countNumberOfParticipantForQuestion.length; 
	    					optionNumber++) {
						double percentageInDouble = (countNumberOfParticipantForQuestion[optionNumber] * 100 
														/ this.participantNumber );
	    				content += "\n\t" + (optionNumber+1) + " - " + percentageInDouble + "%";
					}
	    		}
	    		content += "\n";
	    	}
	    	File file =new File(reportLocation);
			if(!file.exists()){
	    	   file.createNewFile();
	    	}
	    	BufferedWriter writeAnswer = new BufferedWriter(new FileWriter(file));
	    	PrintWriter printAnswer = new PrintWriter(writeAnswer);
	        printAnswer.println(content);
	    	printAnswer.close();
	    	writeAnswer.close();
		}
		catch(IOException fileNotFound){
			
		}
	}
}
