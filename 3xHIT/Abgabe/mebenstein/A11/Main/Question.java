package Main;
/**
 * 
 * @author Michael Ebenstein
 * @version 17-12-2016
 */
public class Question {
	private String question;
	private String[] answers;
	private String right;
	
	public Question(String e,String[] a,int rightIdx){
		question = e;
		answers = a;
		this.right = answers[rightIdx];
	}
	
	
	public String getQuestion(){
		return question;
	}

	public String getRight(){
		return right;
	}
	 
	public String[] getAnswers(){
		return answers;
	}

	
}
