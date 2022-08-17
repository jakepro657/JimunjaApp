package com.planny.jimunjaapp.task;

import android.os.AsyncTask;
import android.widget.ImageView;

import com.planny.jimunjaapp.util.Adapter;
import com.planny.jimunjaapp.util.Prototype;

import java.io.IOException;

public class RequestTask extends AsyncTask<String, Void, String[]> {

    RequestManager requestManager;
    String keyword;
    Prototype prototype;
    Adapter adapter;

    public RequestTask(String keyword, Prototype prototype) {
        System.out.println("Constructor!");
        requestManager = new RequestManager();
        this.keyword = keyword;
        this.prototype = prototype;
        adapter = Adapter.getAdapter();
    }

    @Override
    protected String[] doInBackground(String... strings) {

        System.out.println("Do in Background!");

        String[] stringArr = null;

        try {
            System.out.println("Try!");

            stringArr = requestManager.GetDataFromURL("http://your_address/api?sentence=" + keyword);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringArr;
    }

    @Override
    protected void onPostExecute(String[] values) {
        System.out.println("Post Excute!");
        for(String s : values) {
            ImageView imageView = (ImageView) prototype.MakeView(Prototype.IMAGE, s);
            adapter.insert(imageView);
        }
        String text = "1/" + adapter.getViewListSize();
        adapter.setOwlText(text);

    }

}