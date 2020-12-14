/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api.delegate;

import CAAYcyclic.SystemAdiminClient.model.Role;
import java.util.List;

/**
 *
 * @author Youssef
 */
public interface ApiRoleDelegate extends ApiDelegate<Role> {

    @Override
    public void onGetAllSuccess(List<Role> procedures);

    @Override
    public void onGetSuccess(Role procedure);  
        
}
