package com.example.suporte01.app1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Suporte01 on 11/11/2016.
 */

public class RetrofitHelper {
    private static String BASE_URL;
    private Retrofit retrofit;

    public interface IEstabelecimentoApiService {
        @GET("estabelecimento/")
        Call<List<EstabelecimentoModel>> getAll();
    }

    public RetrofitHelper(String apiBaseUrl) {
        this.BASE_URL = apiBaseUrl;
    }

    public void Init(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    public List<EstabelecimentoModel> getEstabelecimentos() throws IOException {
        IEstabelecimentoApiService service = retrofit.create(IEstabelecimentoApiService.class);
        Call<List<EstabelecimentoModel>> call = service.getAll();
        Response<List<EstabelecimentoModel>> response = call.execute();
        List<EstabelecimentoModel> list = response.body();
        return list;
    }
}
