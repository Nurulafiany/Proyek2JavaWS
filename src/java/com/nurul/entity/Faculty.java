package com.nurul.entity;
// Generated Apr 12, 2018 3:41:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Faculty generated by hbm2java
 */
@Entity
@Table(name="faculty"
    ,catalog="ujitarobby_attendance_system"
)
public class Faculty  implements java.io.Serializable {


     private int id;
     private short code;
     private String name;
     private Set<Department> departments = new HashSet<Department>(0);

    public Faculty() {
    }

	
    public Faculty(int id, short code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    public Faculty(int id, short code, String name, Set<Department> departments) {
       this.id = id;
       this.code = code;
       this.name = name;
       this.departments = departments;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="code", nullable=false)
    public short getCode() {
        return this.code;
    }
    
    public void setCode(short code) {
        this.code = code;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="faculty")
    public Set<Department> getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }




}


