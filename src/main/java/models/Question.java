package models;

public class Question {
	private int question_id;
	private String question;
	private String correct;
	private String wrong1;
	private String wrong2;
	private String wrong3;
	private String explanation;
	private int userid;

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", correct=" + correct + ", wrong1="
				+ wrong1 + ", wrong2=" + wrong2 + ", wrong3=" + wrong3 + ", explanation=" + explanation + ", creator="
				+ userid + "]";
	}

	public Question(int question_id, String question, String correct, String wrong1, String wrong2, String wrong3,
			String explanation, int userid) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.correct = correct;
		this.wrong1 = wrong1;
		this.wrong2 = wrong2;
		this.wrong3 = wrong3;
		this.explanation = explanation;
		this.userid = userid;
	}

	public Question() {
		super();
	}

	public int getQuestion_id() {
		return question_id;
	}

	public String getQuestion() {
		return question;
	}

	public String getCorrect() {
		return correct;
	}

	public String getWrong1() {
		return wrong1;
	}

	public String getWrong2() {
		return wrong2;
	}

	public String getWrong3() {
		return wrong3;
	}

	public String getExplanation() {
		return explanation;
	}

	public int getUserid() {
		return userid;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
