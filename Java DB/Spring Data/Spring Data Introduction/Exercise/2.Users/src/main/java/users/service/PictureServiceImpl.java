package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.data.repositories.PictureRepository;
import users.service.interfaces.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
}
