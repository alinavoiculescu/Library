package model;

import java.util.Date;
import java.util.Objects;

public class Student extends Reader {
    private String university;
    private Integer year;

    public Student() {
        super(0, "Unknown Student", 0, null);
    }

    public Student(Integer id, String name, Integer age, Date registerDate, String university, Integer year) {
        super(id, name, age, registerDate);
        this.university = university;
        this.year = year;
    }

    public Student(Reader readerEntity, String university, Integer year) {
        super(readerEntity);
        this.university = university;
        this.year = year;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\nStudent university: " + university + "\nAcademic year: " + year + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student studentEntity = (Student) o;
        return university.equals(studentEntity.university) && year.equals(studentEntity.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, year);
    }
}
