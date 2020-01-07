package models;

public class Assignment {
	private int quizid;
	private String quiztitle;
	private int userid;
	private int attempts;
	private int takenAttempts;

	public Assignment() {
		super();
	}

	public Assignment(int quizid, int userid, int attempts) {
		super();
		this.quizid = quizid;
		this.userid = userid;
		this.attempts = attempts;
	}

	public Assignment(int quizid, String quiztitle, int attempts, int takenAttempts) {
		super();
		this.quizid = quizid;
		this.quiztitle = quiztitle;
		this.attempts = attempts;
		this.takenAttempts = takenAttempts;
	}

	public int getQuizid() {
		return quizid;
	}

	public int getUserid() {
		return userid;
	}

	public int getAttempts() {
		return attempts;
	}

	public int getTakenAttempts() {
		return takenAttempts;
	}
}
