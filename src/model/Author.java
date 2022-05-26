package model;

public class Author extends Person {

    public Author() {
        super(0, "Unknown name", 0);
    }

    public Author(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    // copy constructor
    public Author(Author author) {
        super(author.getId(), author.getName(), author.getAge());
    }

    @Override
    public String toString() {
        String string = "\nAuthor ID: " + id + "\nAuthor name: " + name;

        if (age != 0) {
            string += "\nAuthor age: " + age + "\n";
        } else {
            string += "\nAuthor age: Unknown/Dead\n";
        }

        return string;
    }
}
