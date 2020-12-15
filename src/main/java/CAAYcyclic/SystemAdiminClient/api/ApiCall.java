/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api;

import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.model.User;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 *
 * @author Youssef
 */
public interface ApiCall {
    
    @GET("/procedure/{id}")
    public Call<Procedure> getProcedure(@Path("id") String id);
    
    @GET("/procedures")
    public Call<List<Procedure>> getAllProcedure();
    
    @PUT("/procedure/{id}")
    public Call<ResponseBody> putProcedure(@Path("id") Integer id,@Query("description") String description);
    
    @POST("/procedure")
    public Call<ResponseBody> postProcedure(@Body Procedure procedure);
    
    @GET("/user/{id}")
    public Call<User> getUser(@Path("id") String id);
    
    @GET("/users")
    public Call<List<User>> getAllUser();
    
    @PUT("/user/{id}/assign-role")
    public Call<ResponseBody> putRoleToUser(@Path("id") Integer id,@Query("role") String role);
    
    @POST("/user")
    public Call<ResponseBody> postUser(@Body User user);
    
    @GET("/roles")
    public Call<List<String>> getAllRole();
    
    @POST("/role")
    public Call<ResponseBody> postRole(@Query("role") String role);
    
    @GET("/competencies")
    public Call<List<String>> getAllCompetency();
    
    @POST("/competency")
    public Call<ResponseBody> postCompetency(@Query("competency") String competency);
}
