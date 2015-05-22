package com.orangecandle.service;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JsonService {
	Gson gson;
	private static Logger logger = LoggerFactory.getLogger(JsonService.class);

	private Gson getGson() {
		if (null == gson)
			gson = new Gson();
		return gson;
	}

	public String toJson(Object o) {
		return getGson().toJson(o);
	}

	public <T> T fromJson(String s, Class<T> c) {
		return getGson().fromJson(s, c);
	}

	public void toExtJSON(Writer w, boolean success, String message,
			Object... data) {
		try {
			w.write(toExtJSON(success, message, data));
		} catch (IOException e) {
			logger.error("failed to write message:{}", message);
			try {
				w.write(toExtJSON(false, "Action Failed"));
			} catch (IOException e1) {
				logger.error("failed to write failure message for:{}", message);
			}
		}
	}

	public String toExtJSON(boolean success, String message, Object... data) {
		// JsonObject result = new JsonObject();
		// result.addProperty("success", success);
		// result.addProperty("message", message);
		// result.addProperty("data", toJson(data.length == 1 ? data[0] :
		// data));
		// return result.toString();
		return "{\"success\":" + success + ",\"message\":\"" + message
				+ "\", \"data\":" + toJson(data.length == 1 ? data[0] : data)
				+ "}";
	}
}
