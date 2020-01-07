package utility;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
 * Utility to reduce number of object mappers
 * 
 * write:	converts pojo to json, used to convert:
 * 			-game data sent to angular
 * 
 * read:	converts json to pojo, used to convert:
 * 			login credentials sent to java
 * 			liked/disliked game info sent to java
 */

public class StoredMapper {

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	private StoredMapper() {
	}

	public static byte[] write(Object o) {
		try {
			return mapper.writeValueAsBytes(o);
		} catch (IOException e) {
			Exceptions.logJsonMarshalException(e, o.getClass());
		}
		return null;
	}

	public static Object read(InputStream is, Class<?> classy) {
		try {
			return mapper.readValue(is, classy);
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, classy);
		}
		return null;
	}
}