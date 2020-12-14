/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

/**
 *
 * @author Youssef
 */
public class Role implements Parcelable{
    
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getParcelableDescription() {
        return "role";
    }

    @Override
    public Parcel convertToParcel() {
        Parcel parcel = new Parcel();
        parcel.writeInteger(id);
        parcel.writeString(name);
        return parcel;
    }

    @Override
    public void createFromParcel(Parcel parcel) {
        this.id = parcel.readInteger();
        this.name = parcel.readString();
    }
    
    
}
