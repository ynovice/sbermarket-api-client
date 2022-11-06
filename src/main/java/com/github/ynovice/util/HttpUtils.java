package com.github.ynovice.util;

public class HttpUtils {

    private final static char[] allowedHeaderNameChars;
    private final static boolean[] isCharAllowedInHeaderName;

    private final static boolean[] isCharAllowedInHeaderValue;

    private final static String[] disallowedHeaders;

    static {

        allowedHeaderNameChars =
                " !#$%&'*+-.^_`|~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        isCharAllowedInHeaderName = new boolean[256];
        isCharAllowedInHeaderValue = new boolean[256];


        for (char ch : allowedHeaderNameChars) {
            isCharAllowedInHeaderName[ch] = true;
        }

        for(char c = '!'; c <= 255; ++c) {
            isCharAllowedInHeaderValue[c] = true;
        }
        isCharAllowedInHeaderValue[127] = false;

        disallowedHeaders = new String[] {"Connection", "Content-Length", "Expect", "Host", "Upgrade"};
    }

    public boolean isValidHeaderName(String headerName) {

        for(int i = 0; i < headerName.length(); ++i) {

            char ch = headerName.charAt(i);

            if (ch > 255 || !isCharAllowedInHeaderName[ch]) {
                return false;
            }
        }

        return !headerName.isBlank();
    }

    public boolean isHeaderAllowed(String headerName) {

        for (String disallowedHeader : disallowedHeaders) {
            if (disallowedHeader.equals(headerName)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidHeaderValue(String headerValue) {

        for(int i = 0; i < headerValue.length(); ++i) {

            char ch = headerValue.charAt(i);

            if (ch > 255) {
                return false;
            }

            if (ch != '\t' && !isCharAllowedInHeaderValue[ch]) {
                return false;
            }
        }

        return true;
    }
}
