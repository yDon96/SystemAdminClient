/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.component.jtable;

import javax.swing.JTable;

/**
 *
 * @author Youssef
 */
public interface ITableDelegate {
    
    void didSelectRowAt(JTable jTable, Integer selectedIndexRow);

    void didDeselectRowAt(JTable jTable, Integer deselectedIndexRow);

}
