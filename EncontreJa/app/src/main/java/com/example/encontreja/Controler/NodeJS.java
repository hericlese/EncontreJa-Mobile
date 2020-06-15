package com.example.encontreja.Controler;

import com.example.encontreja.Model.VagasList;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


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
                                        @Field("sexo") String sexo,
                                        @Field("cidade") String cidade,
                                        @Field("estado") String estado);


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
    Observable<String> cadastrarVagas(
                                        @Field("cargo") String cargo,
                                        @Field("empresa") String empresa,
                                        @Field("competencia1") String competencia1,
                                        @Field("competencia1nivel") String competencia1nivel,
                                        @Field("competencia2") String competencia2,
                                        @Field("competencia2nivel") String competencia2nivel,
                                        @Field("competencia3") String competencia3,
                                        @Field("competencia3nivel") String competencia3nivel,
                                        @Field("vagas") String vagas,
                                        @Field("description") String description,
                                        @Field("id_empresa") String id_empresa,
                                        @Field("contrato") String contrato,
                                        @Field("cidade") String cidade,
                                        @Field("estado") String estado);




    @POST("/cadastrarcurriculo/")
    @FormUrlEncoded
    Observable<String> cadastrarCurriculo(
                                        @Field("name") String name,
                                        @Field("objetivo") String objetivo,
                                        @Field("formacao") String formacao,
                                        @Field("experiencia1") String experiencia1,
                                        @Field("experiencia2") String experiencia2,
                                        @Field("experiencia3") String experiencia3,
                                        @Field("cursos") String cursos,
                                        @Field("links") String links,
                                        @Field("competenciaextra") String competenciaextra,
                                        @Field("id_usuario") String id_usuario,
                                        @Field("competencia1") String competencia1,
                                        @Field("nivel1") String nivel1,
                                        @Field("competencia2") String competencia2,
                                        @Field("nivel2") String nivel2,
                                        @Field("competencia3") String competencia3,
                                        @Field("nivel3") String nivel3);

    @GET("cargosbase")
    Observable<String> getCargoList();


    @POST("buscarvagas")
    @FormUrlEncoded
    Observable<String> buscarvagas(
                                        @Field("cargo1") String cargo1,
                                        @Field("cargo2") String cargo2,
                                        @Field("cargo3") String cargo3,
                                        @Field("competencia1") String competencia1,
                                        @Field("competencia2") String competencia2,
                                        @Field("competencia3") String competencia3,
                                        @Field("cidade") String cidade,
                                        @Field("estado") String estado
                                        );
















}
