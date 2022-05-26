package model;

import java.util.Objects;

public abstract class Person implements Comparable<Person> {
    protected Integer id;
    protected String name;
    protected Integer age;

    public Person(Integer id, String name, Integer age) {
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
        Person person = (Person) o;
        return id.equals(person.id) && name.equals(person.name) && age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public int compareTo(Person o) {
        if (!this.name.equals(o.getName())) {
            //order by name
            return this.name.compareTo(o.getName());
        } else {
            //if same name, then order by id
            return this.id.compareTo(o.getId());
        }
    }
}
