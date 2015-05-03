package com.orangecandle.service;

import java.util.Arrays;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonService {
	static Gson gson;

	private static class ExcludeLists implements ExclusionStrategy {
		@Override
		public boolean shouldSkipClass(Class<?> arg0) {
			return arg0.isAssignableFrom(List.class);
		}

		@Override
		public boolean shouldSkipField(FieldAttributes arg0) {
			return false;
		}
	}

	private static Gson getGson() {
		if (null == gson)
			gson = new GsonBuilder().serializeNulls()
					.setExclusionStrategies(new ExcludeLists()).create();
		return gson;
	}

	public static String toJson(Object o) {
		StringBuilder result = new StringBuilder();
		if (o instanceof List || o instanceof Object[]) {
			result.append("[");
			List<?> l;
			if (o instanceof List) {
				l = (List<?>) o;
			} else {
				l = Arrays.asList((Object[]) o);
			}
			for (Object element : l) {
				boolean isAtomic = element.getClass().isEnum()
						|| element instanceof String;
				result.append(",");
				if (isAtomic)
					result.append("{\"name\":\"");
				result.append(element);
				if (isAtomic)
					result.append("\"}");
			}
			result.delete(1, 2);
			if (o instanceof Object[]) {
			}
			result.append("]");
		} else {
			result.append(o);
		}
		return result.toString();
	}

	public static <T> T fromJson(String s, Class<T> c) {
		return getGson().fromJson(s, c);
	}

	public static String toExtJSON(boolean success, String message,
			Object... data) {
		return "{\"success\":" + success + ",\"message\":\"" + message
				+ "\", \"data\":" + toJson(data.length > 1 ? data : data[0])
				+ "}";
	}
}
