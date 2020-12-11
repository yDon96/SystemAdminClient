/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api.delegate;

import CAAYcyclic.SystemAdiminClient.model.User;
import java.util.List;

/**
 *
 * @author Youssef
 */
public interface ApiUserDelegate extends ApiDelegate<User> {
    
    @Override
    void onGetSuccess(User user);
    
    @Override
    void onGetAllSuccess(List<User> users);
    
}
