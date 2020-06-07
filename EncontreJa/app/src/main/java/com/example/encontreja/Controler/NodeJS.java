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
    Observable<String> registrarEmpresa(@Field("name") String name,
                                        @Field("email") String email,
                                        @Field("password") String password,
                                        @Field("empresa") String empresa,
                                        @Field("responsavel") String responsavel,
                                        @Field("description") String description,
                                        @Field("email_contato") String email_contato);



    @POST("/login/")
    @FormUrlEncoded
    Observable<String> logarUsuario(@Field("email") String email,
                                    @Field("password") String password);




    @POST("/cadastrarvagas/")
    @FormUrlEncoded
    Observable<String> cadastrarVagas(@Field("id_empresa") String id_empresa,
                                      @Field("cargo") String cargo,
                                        @Field("empresa") String empresa,
                                        @Field("competencia1") String competencia1,
                                        @Field("competencia1nivel") String competencia1nivel,
                                        @Field("competencia2") String competencia2,
                                        @Field("competencia2nivel") String competencia2nivel,
                                        @Field("competencia3") String competencia3,
                                        @Field("competencia3nivel") String competencia3nivel,
                                        @Field("competencia4") String competencia4,
                                        @Field("competencia4nivel") String competencia4nivel,
                                        @Field("competencia5") String competencia5,
                                        @Field("competencia5nivel") String competencia5nivel,
                                        @Field("vagas") String vagas,
                                        @Field("contrato") String contrato,
                                        @Field("description") String description);













}
