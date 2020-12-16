/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.enumeration;

/**
 *
 * @author Youssef
 */
public enum DataPanelTitle {
    USER("User"),
    PROCEDURE("Procedure"),
    ROLE("Role"),
    COMPETENCY("Competency");

    public final String value;

    private DataPanelTitle(String value) {
        this.value = value;
    }
}
