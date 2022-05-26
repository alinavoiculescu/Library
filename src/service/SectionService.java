package service;

import entity.SectionEntity;
import model.Section;
import repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;

public class SectionService {

    public static List<Section> getAllSections() {

        List<SectionEntity> sectionEntities = SectionRepository.findAll();
        List<Section> result = new ArrayList<>();

        for (SectionEntity sectionEntity : sectionEntities) {
            result.add(new Section(sectionEntity.getId(), sectionEntity.getName()));
        }

        return result;
    }

    public static Section getSection(Integer sectionId) {

        SectionEntity sectionEntity = SectionRepository.findSection(sectionId);

        return new Section(sectionEntity.getId(), sectionEntity.getName());
    }

    public static void addSection(Section section) {

        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setId(section.getId());
        sectionEntity.setName(section.getName());

        SectionRepository.addSection(sectionEntity);
    }

    public static void deleteSection(String name) {

        SectionRepository.deleteSection(name);
    }
}
