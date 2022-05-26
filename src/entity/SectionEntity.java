package entity;

import java.util.Objects;

public class SectionEntity {
    private Integer id;
    private String name;

    public SectionEntity() {
        this.id = 0;
        this.name = "Unknown Section";
    }

    public SectionEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SectionEntity(String name) {
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
        return "\nSectionEntity: \nSection id: " + id + "\nSection name: " + name + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionEntity sectionEntity = (SectionEntity) o;
        return id.equals(sectionEntity.id) && name.equals(sectionEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
