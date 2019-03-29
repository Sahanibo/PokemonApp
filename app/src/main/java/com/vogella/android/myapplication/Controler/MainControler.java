package com.vogella.android.myapplication.Controler;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.myapplication.Model.Pokemon;
import com.vogella.android.myapplication.Model.RestPokemonResponse;
import com.vogella.android.myapplication.RestPokemonApi;
import com.vogella.android.myapplication.View.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MainControler {

    private MainActivity view;

    public MainControler(MainActivity mainActivity) {
        this.view = mainActivity;
    }

    public void onCreate() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        RestPokemonApi restApi = retrofit.create(RestPokemonApi.class);
        Call<RestPokemonResponse> call = restApi.getListPokemon();
        call.enqueue(new Callback<RestPokemonResponse>() {

            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                view.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("ERREUR", "Api Erreur");
            }
        });

    }
}
