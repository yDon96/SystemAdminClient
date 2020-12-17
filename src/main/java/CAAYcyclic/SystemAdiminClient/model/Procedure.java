/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 *
 * @author Youssef
 */
public class Procedure implements Parcelable{
    
    Integer id;
    String title;
    String description;
    Set<String> competencies;

    public Procedure(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Procedure() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<String> competencies) {
        this.competencies = competencies;
    }

    @Override
    public String getParcelableDescription() {
        return "Procedure";
    }

    @Override
    public Parcel convertToParcel() {
        Parcel parcel = new Parcel();
        parcel.writeInteger(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeStringArray(competencies.toArray(new String[competencies.size()]));
        return parcel;
    }

    @Override
    public void createFromParcel(Parcel parcel) {
        this.id = parcel.readInteger();
        this.title = parcel.readString();
        this.description = parcel.readString();
        String[] competencyArray = parcel.readStringArray();
        if(competencyArray != null){
            this.competencies = new HashSet<>();
            for(String value:competencyArray )
                this.competencies.add(value);
        }
    }
    
    @Override
    public Object[] convetToObjectArray(){
        return new Object[] {id , title, description};
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.competencies);
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
        final Procedure other = (Procedure) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.competencies, other.competencies)) {
            return false;
        }
        return true;
    }
    
    
    
}
