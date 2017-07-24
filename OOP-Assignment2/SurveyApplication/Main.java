import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Questions question = new Questions();
		ArrayList<Questions> setOfQuestions = question.fetchQuestionData();
		
		Scanner scanAnswer = new Scanner(System.in);
		String answer;
		for (Iterator<Questions> iterator = setOfQuestions.iterator(); iterator.hasNext();) {
			Questions questions = (Questions) iterator.next();
			System.out.println(questions.getQuestionText());
			
			if(questions.getQuestionOptions() != null){
				String[] optionString = questions.getQuestionOptions();
				for (int iterateString = 0; iterateString < optionString.length; iterateString++) {
					System.out.println(iterateString+1 +".) "+optionString[iterateString]);
				}
				
			}
			if("Multi Select".equals(questions.getQuestionType().getType())){
				System.out.println("Type your options seperated by comma(/) "
									+ "(example: 1/3 for option 1 and 3)");
			}
			answer = scanAnswer.nextLine();
			
			while(!questions.checkAndSetAnswer(answer)){
				System.out.print("Invalid Input. Please enter a valid answer: ");
				answer = scanAnswer.nextLine();
			}
		}
		scanAnswer.close();

		System.out.println("Thank you for your feedback");
		
		try{
			@SuppressWarnings("unused")
			ReportGeneration addToReport = new ReportGeneration("src/", setOfQuestions);
		}
		catch(IOException fileNotFound){
			System.out.println("Location might be incorrect");
		}
		
		// code for sorting according to question text
		Collections.sort(setOfQuestions);
		System.out.println("Sorted result according to question text");
		for (Iterator<Questions> iterator = setOfQuestions.iterator(); iterator.hasNext();) {
			Questions sortQuestions = (Questions) iterator.next();
			System.out.println(sortQuestions.getCompleteQuestion());
		}
					
	}
}
