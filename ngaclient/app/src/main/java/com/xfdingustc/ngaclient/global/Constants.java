package com.xfdingustc.ngaclient.global;

import java.util.Locale;

/**
 * Created by Xiaofei on 2015/9/28.
 */
public class Constants {
    //public static final String HOST_URL = "http://nga.178.com";
    public static final String HOST_URL = "http://bbs.ngacn.cc";

    public static final String API_THREAD = HOST_URL + "/thread.php";

    public static final String API_READ = HOST_URL + "/read.php";

    public static String MODEL = android.os.Build.MODEL.toUpperCase(Locale.US);

    public static String MANUFACTURER = android.os.Build.MANUFACTURER.toUpperCase(Locale.US);

    public static String getUserAgent() {
        String machine = "";
        if (MODEL.indexOf(MANUFACTURER) >= 0) {
            machine = android.os.Build.MODEL;
        } else {
            machine = android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
        }
        if (machine.length() < 19) {
            machine = "[" + machine + "]";
        }
        String userAgent = new StringBuilder().append("Nga_Official/").append(573).append("(")
            .append(machine).append(";Android").append(android.os.Build.VERSION.RELEASE).append(")").toString();

        return userAgent;
    }

}
