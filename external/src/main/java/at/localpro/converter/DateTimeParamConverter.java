package at.localpro.converter;

import javax.ws.rs.ext.ParamConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class DateTimeParamConverter implements ParamConverter<DateTime> {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	// @formatter:off
	private static final DateTimeParser[] DATE_TIME_PARSERS = { 
			DateTimeFormat.forPattern( DEFAULT_FORMAT ).getParser(),
			DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS" ).getParser(),
			DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm:ss" ).getParser(),
			DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm" ).getParser(),
			DateTimeFormat.forPattern( "yyyy-MM-dd" ).getParser(),
	};
	// @formatter:on
	private static final DateTimeFormatter DATE_TIME_FORMATER = new DateTimeFormatterBuilder()
			.append(null, DATE_TIME_PARSERS).toFormatter();

	@Override
	public DateTime fromString(String value) {
		try {
			return DATE_TIME_FORMATER.parseDateTime(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString(DateTime value) {
		String result = null;
		if (value != null) {
			result = value.toString(DEFAULT_FORMAT);
		}
		return result;
	}

	public static String format(DateTime value) {
		return value.toString(DEFAULT_FORMAT);
	}

}
