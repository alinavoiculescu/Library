package entity;

import java.util.Objects;

public abstract class PersonEntity implements Comparable<PersonEntity> {
    protected Integer id;
    protected String name;
    protected Integer age;

    public PersonEntity(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity personEntity = (PersonEntity) o;
        return id.equals(personEntity.id) && name.equals(personEntity.name) && age.equals(personEntity.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public int compareTo(PersonEntity o) {
        if (!this.name.equals(o.getName())) {
            //order by name
            return this.name.compareTo(o.getName());
        } else {
            //if same name, then order by id
            return this.id.compareTo(o.getId());
        }
    }
}
