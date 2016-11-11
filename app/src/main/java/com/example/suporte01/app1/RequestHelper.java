package com.example.suporte01.app1;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Suporte01 on 09/11/2016.
 */

public class RequestHelper extends AsyncTask<String, Void, String> {
    private String strResult;
    private IOnFinishListener onFinishListener;

    interface IOnFinishListener{
        void onFinish();
    };

    public String getResult(){
        return this.strResult;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally {
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        this.strResult = s;
        this.onFinishListener.onFinish();
    }

    public void setOnFinishListener(IOnFinishListener listener){
        onFinishListener = listener;
    }
}
