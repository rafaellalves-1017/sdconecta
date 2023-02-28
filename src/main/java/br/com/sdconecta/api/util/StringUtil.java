package br.com.sdconecta.api.util;


import static java.util.Objects.isNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

public class StringUtil {
	
	private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
	
	public static final int ZERO = 0;
	
	public static final String EMPTY = "";
	
	public static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

	public static String formatMessage(String message, Object... parameters) {
		var quantity = StringUtils.countMatches(message, "{}");
		if (isNull(parameters)) {
			parameters = getList(new Object[quantity], ZERO, quantity);
		} else if (parameters.length < quantity) {
			parameters = getList(parameters, parameters.length, quantity);
		}
		var response = MessageFormatter.arrayFormat(message, parameters).getMessage();
		return StringUtils.isNotBlank(response) ? response.trim() : response;
	}
	
	private static Object[] getList(Object[] parameters, Integer init, Integer end) {
		var parametersList = new ArrayList<>(Arrays.asList(parameters));
		IntStream.range(init, end).forEach(n -> parametersList.add(EMPTY));
		return parametersList.toArray();
	}
	
}
