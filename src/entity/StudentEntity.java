package entity;

import java.util.Date;
import java.util.Objects;

public class StudentEntity extends ReaderEntity {
    private String university;
    private Integer year;

    public StudentEntity() {
        super(0, "Unknown Student", 0, null);
    }

    public StudentEntity(Integer id, String name, Integer age, Date registerDate, String university, Integer year) {
        super(id, name, age, registerDate);
        this.university = university;
        this.year = year;
    }

    public StudentEntity(ReaderEntity readerEntity, String university, Integer year) {
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
        return "\nStudentEntity: \nStudent university: " + university + "\nAcademic year: " + year + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentEntity studentEntity = (StudentEntity) o;
        return university.equals(studentEntity.university) && year.equals(studentEntity.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, year);
    }
}
