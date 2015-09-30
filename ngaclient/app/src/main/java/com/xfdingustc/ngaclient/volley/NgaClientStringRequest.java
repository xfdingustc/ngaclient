package com.xfdingustc.ngaclient.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.xfdingustc.ngaclient.global.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiaofei on 2015/9/30.
 */
public class NgaClientStringRequest extends StringRequest {
    public NgaClientStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> header = new HashMap<>();
        header.put("User-Agent", Constants.getUserAgent());
        header.put("Accept-Charset", "GBK");
        return header;
    }
}
