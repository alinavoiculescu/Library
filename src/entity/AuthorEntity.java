package entity;

public class AuthorEntity extends PersonEntity {

    public AuthorEntity() {
        super(0, "Unknown name", 0);
    }

    public AuthorEntity(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    // copy constructor
    public AuthorEntity(AuthorEntity authorEntity) {
        super(authorEntity.getId(), authorEntity.getName(), authorEntity.getAge());
    }

    @Override
    public String toString() {
        String string = "\nAuthorEntity ID: " + id + "\nAuthorEntity name: " + name;

        if (age != null) {
            string += "\nAuthorEntity age: " + age + "\n";
        } else {
            string += "\nAuthorEntity age: Unknown/Dead\n";
        }

        return string;
    }
}
