package com.example.encontreja.Controler;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface NodeJS {
    @POST("/registrar/")
    @FormUrlEncoded
    Observable<String> registrarUsuario(@Field("email") String email,
                                         @Field("name") String name,
                                         @Field("password") String password);

    @POST("/login/")
    @FormUrlEncoded
    Observable<String> logarUsuario(@Field("email") String email,
                                    @Field("password") String password);




}
