package models;

public class Quiz {
	private int quiz_id;
	private String title;
	private String questionSequence;
	private int creator;
	private int maxAttempts;
	private int currentAttempts;
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
	
	public Quiz(int quiz_id, String title, int maxAttempts, int currentAttempts) {
		super();
		this.quiz_id = quiz_id;
		this.title = title;
		this.maxAttempts = maxAttempts;
		this.currentAttempts = currentAttempts;
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
	public int getMaxAttempts() {
		return maxAttempts;
	}
	public int getCurrentAttempts() {
		return currentAttempts;
	}
}
