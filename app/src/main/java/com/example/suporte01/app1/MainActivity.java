package com.example.suporte01.app1;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String API_BASE_URL = "http://192.168.1.39:24767/api/v1/";
    private static final String urlEstabelecimento = API_BASE_URL + "estabelecimento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configNet();

        //execRequestHelper();
        try {
            execRetrofitHelper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execRequestHelper() {
        final RequestHelper requestHelper = new RequestHelper();
        requestHelper.setOnFinishListener(new RequestHelper.IOnFinishListener() {
            @Override
            public void onFinish() {
                String jsonArray = requestHelper.getResult();
                Gson gson = new GsonBuilder().create();
                EstabelecimentoModel[] estabelecimentos = gson.fromJson(jsonArray, EstabelecimentoModel[].class);

            }
        });
        requestHelper.execute(urlEstabelecimento);
    }

    private void execRetrofitHelper() throws IOException {
        RetrofitHelper service = new RetrofitHelper(API_BASE_URL);
        service.Init();
        List<EstabelecimentoModel> list = service.getEstabelecimentos();
    }

    private void configNet(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
