/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api;

import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.model.Role;
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
    
    @POST("/procedure")
    public Call<ResponseBody> postProcedure(@Body Procedure procedure);
    
    @GET("/user/{id}")
    public Call<User> getUser(@Path("id") String id);
    
    @GET("/users")
    public Call<List<User>> getAllUser();
    
    @POST("/user")
    public Call<ResponseBody> postUser(@Body User user);
    
    @GET("/roles")
    public Call<List<Role>> getAllRole();
    
    @POST("/role")
    public Call<ResponseBody> postRole(@Body String procedure);
}
