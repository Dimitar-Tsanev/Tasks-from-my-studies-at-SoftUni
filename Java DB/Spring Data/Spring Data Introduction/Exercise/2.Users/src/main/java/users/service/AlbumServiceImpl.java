package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.data.repositories.AlbumRepository;
import users.service.interfaces.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
}
