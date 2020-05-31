package com.example.encontreja.Controler;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface NodeJS {
    @POST("/registrarusuario/")
    @FormUrlEncoded
    Observable<String> registrarUsuario(@Field("email") String email,
                                        @Field("name") String name,
                                        @Field("password") String password,
                                        @Field("email_contato") String email_contato,
                                        @Field("empresa") String empresa,
                                        @Field("data") String data,
                                        @Field("telefone") String telefone,
                                        @Field("cep") String cep,
                                        @Field("sexo") String sexo);


    @POST("/registrarempresa/")
    @FormUrlEncoded
    Observable<String> registrarEmpresa(@Field("email") String email,
                                        @Field("name") String name,
                                        @Field("password") String password,
                                        @Field("empresa") String empresa,
                                        @Field("responsavel") String responsavel,
                                        @Field("description") String description,
                                        @Field("email_contato") String email_contato);



    @POST("/login/")
    @FormUrlEncoded
    Observable<String> logarUsuario(@Field("email") String email,
                                    @Field("password") String password);




}
