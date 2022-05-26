package entity;

import java.util.Date;
import java.util.Objects;

public class ReaderEntity extends PersonEntity {

    protected Date registerDate;

    public ReaderEntity() {
        super(0, "Unknown Reader", 0);
    }

    public ReaderEntity(Integer id, String name, Integer age, Date registerDate) {
        super(id, name, age);
        this.registerDate = registerDate;
    }

    // copy constructor
    public ReaderEntity(ReaderEntity readerEntity) {
        super(readerEntity.getId(), readerEntity.getName(), readerEntity.getAge());
        this.registerDate = readerEntity.getRegisterDate();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "\nReaderEntity: \nReader ID: " + id + "\nReader name: " + name + "\nReader age: " + age + "\nReader register date: " + registerDate + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReaderEntity readerEntity = (ReaderEntity) o;
        return registerDate.equals(readerEntity.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registerDate);
    }
}
