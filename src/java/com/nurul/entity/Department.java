package com.nurul.entity;
// Generated Apr 12, 2018 3:41:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name="department"
    ,catalog="ujitarobby_attendance_system"
)
public class Department  implements java.io.Serializable {


     private int id;
     private Faculty faculty;
     private short code;
     private String name;
     private Set<Lecturer> lecturers = new HashSet<Lecturer>(0);
     private Set<Student> students = new HashSet<Student>(0);
     private Set<Course> courses = new HashSet<Course>(0);

    public Department() {
    }

	
    public Department(int id, Faculty faculty, short code, String name) {
        this.id = id;
        this.faculty = faculty;
        this.code = code;
        this.name = name;
    }
    public Department(int id, Faculty faculty, short code, String name, Set<Lecturer> lecturers, Set<Student> students, Set<Course> courses) {
       this.id = id;
       this.faculty = faculty;
       this.code = code;
       this.name = name;
       this.lecturers = lecturers;
       this.students = students;
       this.courses = courses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="faculty_id", nullable=false)
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Lecturer> getLecturers() {
        return this.lecturers;
    }
    
    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }




}


