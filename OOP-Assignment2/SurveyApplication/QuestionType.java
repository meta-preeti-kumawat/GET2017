/**
 * 
 * @author Preeti Kumawat
 * Date: 21-07-2017
 * Class Name: QuestionType
 *
 */
class QuestionType{
	private String quesType;
	private String[] quesOptions;
	
	public String getType() {
		return quesType;
	}
	
	/**
	 * @param type 
	 */
	public void setType(String type) {
		String[] data = type.split(", ");
		this.quesType = data[0];
		if( "Single Select".equals(this.quesType ) || "Multi Select".equals(this.quesType)){
			this.setOptions(data[1]);	
		}
		else{
			this.quesOptions = null;
		}
	}
	
	public String[] getOptions() {
		return this.quesOptions;
	}
	
	/**
	 * @param options
	 */
	public void setOptions(String options) {
		String extract = options.substring(1, options.length() - 1);
		this.quesOptions = extract.split("/");
		for (int numberOfOptions = 0; numberOfOptions < this.quesOptions.length; numberOfOptions++) {
			this.quesOptions[numberOfOptions] = this.quesOptions[numberOfOptions].trim();
		}
		
	}
	
}