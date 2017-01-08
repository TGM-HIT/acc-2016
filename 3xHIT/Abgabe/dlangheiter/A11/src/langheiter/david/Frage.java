package langheiter.david;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frage {
	
	private static final String questionStr = "QUESTION";
	private static final String answersStr = "ANSWERS";
	private static final String correctStr = "CORRECT";
	
	private String question;
	private String[] answers;
	private int correct;
	
	public Frage(String question, String[] answers, int correct) {
		if(answers.length != 4) {
			throw new IllegalArgumentException("Array answers need to be 4 long");
		}
		this.question = question;
		this.answers = answers;
		this.correct = correct;
	}
	
	public Frage(JSONObject obj) {
		answers = new String[4];
		try {
			question = obj.getString(questionStr);
			correct = obj.getInt(correctStr);
			JSONArray t = obj.getJSONArray(answersStr);
			for(int i = 0; i < 4; i++) {
				answers[i] = t.getString(i);
			}
		} catch (JSONException e) {
			throw new IllegalArgumentException("Wrong JSONObject: " + e.getMessage());
		}
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public int getCorrect() {
		return correct;
	}
	
	public JSONObject getJSONObject() {
		JSONObject ret = new JSONObject();
		
		try {
			ret.accumulate(questionStr, question);
			ret.accumulate(answersStr, answers);
			ret.accumulate(correctStr, correct);
		} catch (JSONException e) {}
		
		return ret;
	}
	
}
