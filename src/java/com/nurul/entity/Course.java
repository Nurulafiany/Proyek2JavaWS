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
import javax.xml.bind.annotation.XmlTransient;

/**
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course", catalog = "ujitarobby_attendance_system"
)
public class Course implements java.io.Serializable {

    private String id;
    private Department department;
    private String name;
    private short theoryCredits;
    private Short practicumCredits;
    private Set<ClassSchedule> classSchedules = new HashSet<ClassSchedule>(0);

    public Course() {
    }

    public Course(String id, Department department, String name,
            short theoryCredits) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.theoryCredits = theoryCredits;
    }

    public Course(String id, Department department, String name,
            short theoryCredits, Short practicumCredits,
            Set<ClassSchedule> classSchedules) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.theoryCredits = theoryCredits;
        this.practicumCredits = practicumCredits;
        this.classSchedules = classSchedules;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false, length = 5)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "theory_credits", nullable = false)
    public short getTheoryCredits() {
        return this.theoryCredits;
    }

    public void setTheoryCredits(short theoryCredits) {
        this.theoryCredits = theoryCredits;
    }

    @Column(name = "practicum_credits")
    public Short getPracticumCredits() {
        return this.practicumCredits;
    }

    public void setPracticumCredits(Short practicumCredits) {
        this.practicumCredits = practicumCredits;
    }

    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<ClassSchedule> getClassSchedules() {
        return this.classSchedules;
    }

    public void setClassSchedules(Set<ClassSchedule> classSchedules) {
        this.classSchedules = classSchedules;
    }

}
