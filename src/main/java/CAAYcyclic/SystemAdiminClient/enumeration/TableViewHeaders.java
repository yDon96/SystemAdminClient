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
public enum TableViewHeaders {
    PROCEDURE( new String[] {"Id", "Title", "Description"}),
    USER( new String[] {"Id", "Name", "Surname", "Date of Birth"}),
    ROLE( new String[] {"Id", "Name"});

    public final String[] value;

    private TableViewHeaders(String[] value) {
        this.value = value;
    }
}
