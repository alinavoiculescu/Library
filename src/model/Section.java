package model;

import java.util.Objects;

public class Section {
    private Integer id;
    private String name;

    public Section() {
        this.id = 0;
        this.name = "Unknown Section";
    }

    public Section(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Section(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "\nSection id: " + id + "\nSection name: " + name + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id.equals(section.id) && name.equals(section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
