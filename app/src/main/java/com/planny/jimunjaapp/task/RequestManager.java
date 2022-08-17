package com.planny.jimunjaapp.task;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class RequestManager {

    private HttpURLConnection httpURLConnection;

    public String[] GetDataFromURL(String address) throws IOException {
        URL url = new URL(address);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        InputStream is = httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = br.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        br.close();

        String res = response.toString();
        res = res.substring(1, res.length() - 1);
        String[] strs = res.split(",");

        String[] strings = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            strings[i] = str.substring(1, str.length() - 1);
        }
        return strings;
    }


}