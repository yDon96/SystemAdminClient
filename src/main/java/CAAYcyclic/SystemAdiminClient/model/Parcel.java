/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Youssef
 */
public class Parcel {
    
    protected ArrayList<String> stringList;
    protected ArrayList<Integer> integerList;
    protected ArrayList<String[]> stringArrayList;
    protected ArrayList<Parcel> parcelList;
    
    public void writeString(String string){
        if(stringList == null){
            stringList = new ArrayList<>();
        }
        stringList.add(string);
    }
    
    public void writeInteger(Integer integer){
        if(integerList == null){
            integerList = new ArrayList<>();
        }
        integerList.add(integer);
    }
    
    public void writeStringArray(String[] integer){
        if(stringArrayList == null){
            stringArrayList = new ArrayList<>();
        }
        stringArrayList.add(integer);
    }
    
    public void writeParcel(Parcel parcel){
        if(parcelList == null){
            parcelList = new ArrayList<>();
        }
        parcelList.add(parcel);
    }
    
    public String readString(){
        return getValueFromArrayList(stringList);
    }
    
    public Integer readInteger(){
        return getValueFromArrayList(integerList);
    }
    
    public String[] readStringArray(){
        return getValueFromArrayList(stringArrayList);
    }
    
    public Parcel readParcel(){
        return getValueFromArrayList(parcelList);
    }
    
    public ArrayList<Parcel> readParcels(){
        return parcelList;
    }
    
    private <T> T getValueFromArrayList(ArrayList<T> arrayList){
        if(arrayList != null && arrayList.size() > 0){
            return arrayList.remove(0);
        }
        
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.stringList);
        hash = 89 * hash + Objects.hashCode(this.integerList);
        hash = 89 * hash + Objects.hashCode(this.stringArrayList);
        hash = 89 * hash + Objects.hashCode(this.parcelList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parcel other = (Parcel) obj;
        if (!Objects.equals(this.stringList, other.stringList)) {
            return false;
        }
        if (!Objects.equals(this.integerList, other.integerList)) {
            return false;
        }
        if (!Objects.equals(this.stringArrayList, other.stringArrayList)) {
            return false;
        }
        if (!Objects.equals(this.parcelList, other.parcelList)) {
            return false;
        }
        return true;
    }
    
    
}
