/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api;

import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.api.delegate.MyCallback;
import CAAYcyclic.SystemAdiminClient.api.model.LocalDateDeserializer;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.api.model.ServerSettings;
import CAAYcyclic.SystemAdiminClient.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import CAAYcyclic.SystemAdiminClient.api.model.LocalDateSerializer;
import CAAYcyclic.SystemAdiminClient.model.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import retrofit2.Call;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *
 * @author Youssef
 */
public class ApiManager {

    private Integer seconds = 10;
    private ApiCall apiCall;
         
    private static ApiManager istance = null;
    private static final Logger LOG = Logger.getLogger(ApiManager.class.getName());

        
    public static ApiManager getIstance() {
        if(istance==null)
            istance = new ApiManager();
        return istance;
    }
     
    public ApiManager() {
        LOG.log(java.util.logging.Level.CONFIG, "Init ApiManager");
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .setLenient()
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(seconds,TimeUnit.SECONDS)
            .readTimeout(seconds,TimeUnit.SECONDS)
            .writeTimeout(seconds,TimeUnit.SECONDS)
            .build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(new ServerSettings().getUrl())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

        apiCall = retrofit.create(ApiCall.class);
    }
    
    
    
    public void createUser(User user,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Post user: {0}.", user.getName() + " "  + user.getSurname());
        postCallback.setApiDelegate(apiDelegate);
        Call<ResponseBody> call = apiCall.postUser(user);
        call.enqueue(postCallback);
    }
    
    public void createRole(String role,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Post role: {0}.", role);
        postCallback.setApiDelegate(apiDelegate);
        Call<ResponseBody> call = apiCall.postRole(role);
        call.enqueue(postCallback);
    }
    
    public void getUser(Integer id,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Get user with id: {0}.", String.valueOf(id));
        getUserCallback.setApiDelegate(apiDelegate);
        Call<User> call = apiCall.getUser(String.valueOf(id));
        call.enqueue(getUserCallback);
    }
    
    public void getUsers(ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Get all users.");
        getUsersCallback.setApiDelegate(apiDelegate);
        Call<List<User>> call = apiCall.getAllUser();
        call.enqueue(getUsersCallback);
    }
    
    public void createProcedure(Procedure procedure,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Post procedure: {0}.", procedure.getTitle());
        postCallback.setApiDelegate(apiDelegate);
        Call<ResponseBody> call = apiCall.postProcedure(procedure);
        call.enqueue(postCallback);
    }
    
    public void getProcedure(Integer id,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Get procedure with id: {0}.", String.valueOf(id));
        getProcedureCallback.setApiDelegate(apiDelegate);
        Call<Procedure> call = apiCall.getProcedure(String.valueOf(id));
        call.enqueue(getProcedureCallback);
    }
    
    public void getProcedures(ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Get all procedure.");
        getProceduresCallback.setApiDelegate(apiDelegate);
        Call<List<Procedure>> call = apiCall.getAllProcedure();
        call.enqueue(getProceduresCallback);
    }
    
    public void assingRole(Integer userId,String role,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Assign role to user with id: {0}.",String.valueOf(userId));
        postCallback.setApiDelegate(apiDelegate);
        Call<ResponseBody> call = apiCall.putRoleToUser(userId, role);
        call.enqueue(postCallback);
    }
    
    public void postRole(String role,ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Creating role: {0}.",role);
        postCallback.setApiDelegate(apiDelegate);
        Call<ResponseBody> call = apiCall.postRole(role);
        call.enqueue(postCallback);
    }
    
    public void getRoles(ApiDelegate apiDelegate){
        LOG.log(java.util.logging.Level.CONFIG, "Get all roles.");
        getRolesCallback.setApiDelegate(apiDelegate);
        Call<List<String>> call = apiCall.getAllRole();
        call.enqueue(getRolesCallback);
    }
    
    private MyCallback<ResponseBody> postCallback = new MyCallback<ResponseBody>(){

        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Post response is successful.");
                ResponseBody body = response.body();
                if(response != null){
                    getApiDelegate().onCreateSuccess();
                }
            } else {
                LOG.log(java.util.logging.Level.SEVERE, "Post response is not successful.");
                getApiDelegate().onFailure("Creation response is not successful.");
            }
        };

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Post response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
    private MyCallback<User> getUserCallback = new MyCallback<User>(){
        @Override
        public void onResponse(Call<User> call, Response<User> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Get user response is successful.");
                User user = response.body();
                if(user != null){
                    getApiDelegate().onGetSuccess(user);
                }
            } else {
               LOG.log(java.util.logging.Level.SEVERE, "Get user response is not successful.");
               getApiDelegate().onFailure("Could not get user.");
            }
        };

        @Override
        public void onFailure(Call<User> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Get user response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
    private MyCallback<List<User>> getUsersCallback = new MyCallback<List<User>>(){
        @Override
        public void onResponse(Call<List<User>> call, Response<List<User>> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Get users response is successful.");
                List<User> users = response.body();
                LOG.log(java.util.logging.Level.CONFIG, "Get {0} users.", String.valueOf(users.size()));
                if(users != null){
                    getApiDelegate().onGetAllSuccess(users);
                }
            } else {
                LOG.log(java.util.logging.Level.SEVERE, "Get users response is not successful.");
                getApiDelegate().onFailure("Could not get users.");
            }
        };

        @Override
        public void onFailure(Call<List<User>> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Get users response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
    private MyCallback<Procedure> getProcedureCallback = new MyCallback<Procedure>(){
        @Override
        public void onResponse(Call<Procedure> call, Response<Procedure> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Get procedure response is successful.");
                Procedure procedure = response.body();
                if(procedure != null){
                    getApiDelegate().onGetSuccess(procedure);
                }
            } else {
               LOG.log(java.util.logging.Level.SEVERE, "Get procedure response is not successful.");
               getApiDelegate().onFailure("Could not get procedure.");
            }
        };

        @Override
        public void onFailure(Call<Procedure> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Get procedure response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
    
    private MyCallback<List<Procedure>> getProceduresCallback = new MyCallback<List<Procedure>>(){
        @Override
        public void onResponse(Call<List<Procedure>> call, Response<List<Procedure>> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Get procedures response is successful.");
                List<Procedure> procedures = response.body();
                LOG.log(java.util.logging.Level.CONFIG, "Get {0} procedures.", String.valueOf(procedures.size()));
                if(procedures != null){
                    getApiDelegate().onGetAllSuccess(procedures);
                }
            } else {
                LOG.log(java.util.logging.Level.SEVERE, "Get procedures response is not successful.");
                getApiDelegate().onFailure("Could not get procedures.");
            }
        };

        @Override
        public void onFailure(Call<List<Procedure>> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Get procedures response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
    private MyCallback<List<String>> getRolesCallback = new MyCallback<List<String>>(){
        @Override
        public void onResponse(Call<List<String>> call, Response<List<String>> response){
            if (response.isSuccessful()) {
                LOG.log(java.util.logging.Level.CONFIG, "Get roles response is successful.");
                List<String> rolesValue = response.body();
                LOG.log(java.util.logging.Level.CONFIG, "Get {0} roles.", String.valueOf(rolesValue.size()));
                if(rolesValue != null){
                    ArrayList<Role> roles = new ArrayList<>();
                    for(String value:rolesValue){
                        Role role = new Role();
                        role.setName(value);
                        roles.add(role);
                    }
                    getApiDelegate().onGetAllSuccess(roles);
                }
            } else {
                LOG.log(java.util.logging.Level.SEVERE, "Get roles response is not successful.");
                getApiDelegate().onFailure("Could not get roles.");
            }
        };

        @Override
        public void onFailure(Call<List<String>> call, Throwable t){
            LOG.log(java.util.logging.Level.SEVERE, "Get roles response is not successful, message: {0}.", t.getMessage());
            getApiDelegate().onFailure(t.getMessage());
        };
    };
    
}
