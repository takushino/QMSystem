package models;

public class Quiz {
	private int quiz_id;
	private String title;
	private String questionSequence;
	private int creator;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(int quiz_id, String title, int creator) {
		super();
		this.quiz_id = quiz_id;
		this.title = title;
		this.creator = creator;
	}
	
	public int getQuiz_id() {
		return quiz_id;
	}
	public String getTitle() {
		return title;
	}
	public String getQuestionSequence() {
		return questionSequence;
	}
	public int getCreator() {
		return creator;
	}
}
