package com.vogella.android.myapplication;

import com.vogella.android.myapplication.Model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPokemonApi {

    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();
}