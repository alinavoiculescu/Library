package service;

import entity.AuthorEntity;
import model.Author;
import repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    public static List<Author> getAllAuthors() {

        List<AuthorEntity> authorEntities = AuthorRepository.findAll();
        List<Author> result = new ArrayList<>();

        for (AuthorEntity authorEntity : authorEntities) {
            result.add(new Author(authorEntity.getId(), authorEntity.getName(), authorEntity.getAge()));
        }

        return result;
    }

    public static Author getAuthor(Integer authorId) {

        AuthorEntity authorEntity = AuthorRepository.findAuthor(authorId);

        return new Author(authorEntity.getId(), authorEntity.getName(), authorEntity.getAge());
    }

    public static void addAuthor(Author author) {

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(author.getId());
        authorEntity.setName(author.getName());
        authorEntity.setAge(author.getAge());

        AuthorRepository.addAuthor(authorEntity);
    }

    public static void deleteAuthor(String name) {

        AuthorRepository.deleteAuthor(name);
    }

    public static void updateAuthorsName(String name, String newName) {

        AuthorRepository.updateAuthorsName(name, newName);
    }

    public static void updateAuthorsAge(String name, Integer newAge) {

        AuthorRepository.updateAuthorsAge(name, newAge);
    }
}
