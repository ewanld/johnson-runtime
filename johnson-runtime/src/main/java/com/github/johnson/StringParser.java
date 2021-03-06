package com.github.johnson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class StringParser extends JohnsonParser<String> {
	public static final StringParser INSTANCE = new StringParser(false);
	public static final StringParser INSTANCE_NULLABLE = new StringParser(true);

	public StringParser(boolean nullable) {
		super(nullable);
	}

	@Override
	public String doParse(JsonParser jp) throws JsonParseException, IOException {
		if (jp.getCurrentToken() == JsonToken.VALUE_NULL) {
			if (nullable)
				return null;
			else throw new JsonParseException(jp, "null not allowed!");
		}
		final String res = jp.getValueAsString();
		return res;
	}

	@Override
	public void doSerialize(String value, JsonGenerator generator) throws IOException {
		generator.writeString(value);
	}
}
