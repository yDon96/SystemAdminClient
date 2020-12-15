/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api.callback;

import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import retrofit2.Callback;

/**
 *
 * @author Youssef
 */
public abstract class MyCallback<T> implements Callback<T>{
    
    private ApiDelegate apiDelegate;
    
    public void setApiDelegate(ApiDelegate apiDelegate){
        this.apiDelegate = apiDelegate;
    }

    public ApiDelegate getApiDelegate() {
        return apiDelegate;
    }
    
    
}
