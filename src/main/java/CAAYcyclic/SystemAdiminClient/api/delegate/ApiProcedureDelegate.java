/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.api.delegate;

import CAAYcyclic.SystemAdiminClient.model.Procedure;
import java.util.List;

/**
 *
 * @author Youssef
 */
public interface ApiProcedureDelegate extends ApiDelegate<Procedure> {

    @Override
    public void onGetAllSuccess(List<Procedure> procedures);

    @Override
    public void onGetSuccess(Procedure procedure);

    
    
        
}
