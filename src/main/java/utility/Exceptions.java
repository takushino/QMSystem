package utility;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Exceptions {
	private static Logger logger = LogManager.getLogger(Exceptions.class);

	private Exceptions() {
	}

	public static void logSQLException(SQLException e) {
		logger.warn("SQL Message: {}", e.getMessage());
		logger.warn("Error Code: {}", e.getErrorCode());
		logger.warn("SQL State: {}", e.getSQLState());
		logger.warn("Stack Trace: ", e);
	}

	// Memo: Marshalling = POJO=>JSON (write)
	public static void logJsonMarshalException(IOException e, Class<?> inputClass) {
		logger.warn("Failed to Marshal object of type {}", inputClass.getName());
		logger.warn("Stack Trace: ", e);
	}

	// Memo: Unmarshalling JSON=>POJO (a read)
	public static void logJsonUnmarshalException(IOException e, Class<?> inputClass) {
		logger.warn("Failed to Unmarshal object of type {}", inputClass.getName());
		logger.warn("Stack Trace: ", e);
	}
}