package bg.softuni.lecture.data.service;

import bg.softuni.lecture.data.entities.Label;
import bg.softuni.lecture.data.repositories.LabelRepository;
import bg.softuni.lecture.data.service.interfaces.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {
    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public Optional<Label> getByID ( Long id ) {
        return labelRepository.findById ( id );
    }

    @Override
    public Optional<Label> getByTitle ( String name ) {
        return labelRepository.findByTitle ( name );
    }

}
