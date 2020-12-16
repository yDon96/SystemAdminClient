/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.component.Jcombobox;

import javax.swing.JComboBox;

/**
 *
 * @author Youssef
 */
public interface IComboBoxDelegate {
    
    void didSelectRowAt(JComboBox combobox, Integer selectedIndexRow);

    void didDeselectRowAt(JComboBox combobox, Integer deselectedIndexRow);

}
