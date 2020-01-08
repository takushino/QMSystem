package utility;

public final class MagicWords {

	// UserDaoImpl MagicWords
	public static final String LOGIN_QUERY = "SELECT user_id, user_name, user_role FROM qms_users WHERE user_name = ? AND user_pw = ?";

	public static final String GET_ALL_USERS = "SELECT user_id, user_name, user_role FROM qms_users";

	// ObjectMapper Header
	public static final String CONTENT_TYPE = "application/json";

	// QuestionImplMagicWords
	public static final String QUESTION_INSERT_QUERY = "INSERT INTO qms_questions (QUESTION_ID, QUESTION_PROBLEM, QUESTION_CORRECT, QUESTION_WRONG1, QUESTION_WRONG2, QUESTION_WRONG3, QUESTION_EXPLANATION, QUESTION_CREATOR)"
			+ "VALUES (QMS_Questions_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_ALL_QUESIONS = "SELECT * FROM qms_questions";

	// QuizImplMagicWords
	public static final String QUIZ_INSERT_QUERY = "INSERT INTO qms_quizzes (QUIZ_ID, QUIZ_NAME, QUIZ_CREATOR)"
			+ "VALUES (QMS_Quizzes_seq.nextval, ?, ?)";

	public static final String QUIZ_BY_TITLE = "SELECT * FROM qms_quizzes WHERE QUIZ_NAME = ?";

	public static final String QUIZ_QUESTION_RELATOR = "INSERT INTO QMS_Quiz_Question (QUIZ_ID, QUESTION_ID)"
			+ "VALUES (?, ?)";

	public static final String GET_ALL_QUIZZES = "SELECT * FROM qms_quizzes";

	public static final String GET_ASSIGNED_QUIZZES = "SELECT qms_quiz_assignment.quiz_id, quiz_name, qms_quiz_assignment.current_attempts, qms_quiz_assignment.max_attempts FROM QMS_QUIZ_ASSIGNMENT INNER JOIN QMS_QUIZZES ON QMS_QUIZ_ASSIGNMENT.QUIZ_ID = QMS_QUIZZES.QUIZ_ID WHERE USER_ID = ?";

	// AssignmentImplMagicWords
	public static final String ASSIGNMENT_INSERT_QUERY = "INSERT INTO QMS_Quiz_Assignment (USER_ID, QUIZ_ID, MAX_ATTEMPTS, CURRENT_ATTEMPTS)"
			+ "VALUES (?, ?, ?, 0)";

}