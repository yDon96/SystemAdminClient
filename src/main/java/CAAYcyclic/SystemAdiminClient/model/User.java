/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Youssef
 */
public class User implements Parcelable{
    
    Integer userId;
    String name;
    String surname;
    LocalDate dateOfBirth;
    String role;
    Set<String> competencies;

    public User(Integer user_id, String name, String surname, LocalDate dob, String role) {
        this.userId = user_id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.role = role;
    }

    public User(String name, String surname, LocalDate dob, String role) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.role = role;
    }

    public User(String name, String surname, LocalDate dob) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dob;
    }

    public User(String name, String surname, String dob) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public User(String name, String surname, String dob, String role) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.role = role;

    }

    public User() {
    }

    public Integer getUser_id() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dateOfBirth;
    }

    public String getDobString() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getRole() {
        return role;
    }

    public void setUser_id(Integer user_id) {
        this.userId = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(LocalDate dob) {
        this.dateOfBirth = dob;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompetencies(Set<String> competencies) {
        this.competencies = competencies;
    }

    public Set<String> getCompetencies() {
        return competencies;
    }

    @Override
    public String getParcelableDescription() {
        return "User";
    }

    @Override
    public Parcel convertToParcel() {
        Parcel parcel = new Parcel();
        parcel.writeInteger(userId);
        parcel.writeString(name);
        parcel.writeString(surname);
        String date = null;
        if (dateOfBirth != null) {
            date = dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        parcel.writeString(date);
        parcel.writeString(role);
        parcel.writeStringArray(competencies.toArray(new String[competencies.size()]));
        return parcel;
    }

    @Override
    public void createFromParcel(Parcel parcel) {
        this.userId = parcel.readInteger();
        this.name = parcel.readString();
        this.surname = parcel.readString();
        String date = parcel.readString();
        if (date != null) {
            this.dateOfBirth = LocalDate.parse((date), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        this.role = parcel.readString();
        String[] competencyArray = parcel.readStringArray();
        if (competencyArray != null) {
            this.competencies = new HashSet<>();
            for (String value : competencyArray) {
                this.competencies.add(value);
            }
        }
    }

    public Object[] convetToObjectArray() {
        String date = null;
        if (dateOfBirth != null) {
            date = dateOfBirth.format(DateTimeFormatter.ISO_DATE);
        }
        return new Object[]{userId, name, surname, date, role};
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.userId);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.surname);
        hash = 43 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 43 * hash + Objects.hashCode(this.role);
        hash = 43 * hash + Objects.hashCode(this.competencies);
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.competencies, other.competencies)) {
            return false;
        }
        return true;
    }
    
    
}
