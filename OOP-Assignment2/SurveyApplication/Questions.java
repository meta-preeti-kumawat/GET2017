import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Date: 21-07-2017
 * Class Name: Question
 *
 */
public class Questions implements Comparable<Questions>{
	private String completeQuestion;
	private String questionText;
	private QuestionType questionType;
	private FileInputStream dataFile;
	private BufferedReader readQuestion;
	private String inputText = new String();
	private String answer = "";
	private String questionTextWithoutNumber;
	
	/**
	 * @return ArrayList<Questions> 
	 * this returns a complete set of questions in form of array list
	 */
	public ArrayList<Questions> fetchQuestionData() {
		ArrayList<Questions> setOfQuestion = new ArrayList<Questions>(); 
		
		try{
			dataFile = new FileInputStream("src/DataFile.txt");
			readQuestion = new BufferedReader(new InputStreamReader(dataFile));
			inputText = readQuestion.readLine();	
			
			while(inputText != null){
				String[] seperateData = inputText.split(", ", 2); 
				Questions holdQuestion = new Questions();
				holdQuestion.completeQuestion = inputText;
				holdQuestion.setQuestionText(seperateData[0]) ; 
				holdQuestion.setQuestionType(seperateData[1]); 
				
				setOfQuestion.add(holdQuestion);
				inputText = readQuestion.readLine();	
				
			}
			dataFile.close();
		}
		catch (IOException fileError) {}
		return setOfQuestion;
	}
	
	public String getCompleteQuestion() {
		return this.completeQuestion;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	/**
	 * @param type
	 */
	public void setQuestionType(String type) {
		try{
			QuestionType tempQuestionType = new QuestionType();
			tempQuestionType.setType(type);
			this.questionType = tempQuestionType;
		}
		catch(NullPointerException nullPointer){
			this.questionType = null;
		}
		
	}
	
	/**
	 * 
	 * @return String[] 
	 * returns a String array of all the options available 
	 */
	public String[] getQuestionOptions() {
		try{
			String[] options = this.questionType.getOptions();
			return options;
			
		}
		catch(NullPointerException nullPointer){
			return null;
		}
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	/**
	 * @param inputAnswer
	 * @return Boolean
	 * true if answers are valid
	 * false for invalid answers
	 */
	public Boolean checkAndSetAnswer(String inputAnswer){
		Boolean correctAnswer = false;
		
		try{
			String choice = this.questionType.getType();
			int optList;
			if("Single Select".equals(choice)){
				optList = this.getQuestionOptions().length;
				inputAnswer = inputAnswer.trim();
				int optionNumber = Integer.parseInt(inputAnswer);
				if(optionNumber <= optList){
					correctAnswer = true;
					this.answer = this.getQuestionOptions()[optionNumber-1];
				}
			}
				
			else if("Multi Select".equals(choice)){
				optList = this.getQuestionOptions().length;
				String[] extractAnswers = inputAnswer.split("/");
				for (int numberOfOptions = 0; numberOfOptions < extractAnswers.length; 
						numberOfOptions++) {
					extractAnswers[numberOfOptions] = extractAnswers[numberOfOptions].trim();
				}
				
				for (int numberOrAnswers = 0; numberOrAnswers < extractAnswers.length; 
						numberOrAnswers++) {
					if(Integer.parseInt(extractAnswers[numberOrAnswers]) <= optList){
						correctAnswer = true;
					}
					else{
						correctAnswer = false;
						break;
					}
				}
				if(correctAnswer == true){
					for (int numberOfAnswers = 0; numberOfAnswers < extractAnswers.length; 
							numberOfAnswers++) {
						if(numberOfAnswers != 0){
							this.answer += "/";
						}
						this.answer += this.getQuestionOptions()
										[Integer.parseInt(extractAnswers[numberOfAnswers])-1];
					}
				}
			}
			
			else{
				correctAnswer = true;
				this.answer = inputAnswer;
			}
		}
		catch(NumberFormatException invalidInput){
			correctAnswer = false;
		}
		
		return correctAnswer;
	}
	
	public String getQuestionWithoutNumber()
	{
		this.questionTextWithoutNumber = this.getQuestionText().split("\\. ")[1].trim();
		return this.questionTextWithoutNumber;
	}
	
	@Override
	public int compareTo(Questions sortQuestions) {
		if(this.getQuestionWithoutNumber().compareTo(sortQuestions.getQuestionWithoutNumber()) == 0)
			return 0;
		else if(this.questionText.compareTo(sortQuestions.getQuestionText()) > 0)
			return 1;
		else
			return -1;
	}
}

