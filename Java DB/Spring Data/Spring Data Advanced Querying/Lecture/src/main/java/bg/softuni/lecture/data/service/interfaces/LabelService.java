package bg.softuni.lecture.data.service.interfaces;

import bg.softuni.lecture.data.entities.Label;

import java.util.Optional;

public interface LabelService {
    Optional<Label> getByID( Long id);

    Optional<Label> getByTitle (String name);
}
