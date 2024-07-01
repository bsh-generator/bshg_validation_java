package org.bshg.validation.utils;

import java.util.regex.Pattern;

public class Regex {
    public static final Pattern EMAIL = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    public static final Pattern PHONE = Pattern.compile("^\\+?[1-9]\\d{1,14}$");
    public static final Pattern URL = Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$");
    public static final Pattern DATE = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    public static final Pattern TIME = Pattern.compile("^\\d{2}:\\d{2}(:\\d{2})?$");
    public static final Pattern HEX_COLOR = Pattern.compile("^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
    public static final Pattern CREDIT_CARD = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|6(?:011|5[0-9]{2})[0-9]{12}|(?:2131|1800|35\\d{3})\\d{11})$");
    public static final Pattern HTML_TAG = Pattern.compile("^<([a-z1-6]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
    public static final Pattern BASE64 = Pattern.compile("^(?:[A-Za-z0-9+\\/]{4})*(?:[A-Za-z0-9+\\/]{2}==|[A-Za-z0-9+\\/]{3}=)?$");
    public static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]+$");
    public static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    public static final Pattern ALPHA = Pattern.compile("^[a-zA-Z]+$");
}
