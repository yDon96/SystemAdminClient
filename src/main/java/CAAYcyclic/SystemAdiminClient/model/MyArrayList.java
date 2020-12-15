/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 * @param <E>
 */
public class MyArrayList<E extends Parcelable> extends ArrayList<E> implements Parcelable{
    
    Class<E> objectClass;
    
    public MyArrayList(){}
    
    public MyArrayList(List<E> elementList){
        this.addAll(elementList);
    }
        
    @Override
    public String getParcelableDescription() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Parcel convertToParcel() {
        Parcel parcel = new Parcel();
        for(E element: this){
            parcel.writeParcel(element.convertToParcel());
        }
        return parcel;
    }
    
    public void createFromParcel(Parcel parcel, Class<E> objectClass) {
        this.objectClass = objectClass;
        createFromParcel(parcel);
    }

    @Override
    public void createFromParcel(Parcel parcel) {
        ArrayList<Parcel> parcels = parcel.readParcels();
        for(Parcel element: parcels){
            E genericElement;
            try {
                genericElement = generateGeneric();
            } catch (InstantiationException ex) {
                Logger.getLogger(MyArrayList.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MyArrayList.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            genericElement.createFromParcel(element);
            this.add(genericElement);
        }
    }
    
    private E generateGeneric() throws InstantiationException, IllegalAccessException {
        return objectClass.newInstance();
    }

    @Override
    public Object[] convetToObjectArray() {
        Object[] object = new Object[this.size()];
        for(E element: this){
            Integer index = this.indexOf(element);
            object[index] = element.convetToObjectArray();
        }
        return object;
    }
    
}
