package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.data.repositories.TownRepository;
import users.service.interfaces.TownService;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl ( TownRepository townRepository ) {
        this.townRepository = townRepository;
    }

}
