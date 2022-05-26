package service;

import entity.ReaderEntity;
import model.Reader;
import repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

public class ReaderService {

    public static ArrayList<Reader> getAllReaders() {

        ArrayList<ReaderEntity> readerEntities = ReaderRepository.findAll();
        ArrayList<Reader> result = new ArrayList<>();

        for (ReaderEntity readerEntity : readerEntities) {
            result.add(new Reader(readerEntity.getId(), readerEntity.getName(), readerEntity.getAge(), readerEntity.getRegisterDate()));
        }

        return result;
    }

    public static Reader getReader(Integer readerId) {

        ReaderEntity readerEntity = ReaderRepository.findReader(readerId);

        return new Reader(readerEntity.getId(), readerEntity.getName(), readerEntity.getAge(), readerEntity.getRegisterDate());
    }

    public static void addReader(Reader reader) {

        ReaderEntity readerEntity = new ReaderEntity();
        readerEntity.setId(reader.getId());
        readerEntity.setName(reader.getName());
        readerEntity.setAge(reader.getAge());
        readerEntity.setRegisterDate(reader.getRegisterDate());

        ReaderRepository.addReader(readerEntity);
    }

    public static void deleteReader(String name) {

        ReaderRepository.deleteReader(name);
    }

    public static void updateReadersName(String name, String newName) {

        ReaderRepository.updateReadersName(name, newName);
    }

    public static void updateReadersAge(String name, Integer newAge) {

        ReaderRepository.updateReadersAge(name, newAge);
    }
}
