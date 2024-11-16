package bg.softuni.lecture.data.service;

import bg.softuni.lecture.data.entities.Label;
import bg.softuni.lecture.data.entities.Shampoo;
import bg.softuni.lecture.data.repositories.ShampooRepository;
import bg.softuni.lecture.data.service.interfaces.LabelService;
import bg.softuni.lecture.data.service.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static bg.softuni.lecture.data.entities.Size.*;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;
    private final LabelService labelService;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, LabelService labelService) {
        this.shampooRepository = shampooRepository;
        this.labelService = labelService;
    }

    @Override
    public List<Shampoo> getShampooBySize ( String size ) {
        return shampooRepository.findAllBySizeOrderById ( valueOf ( size ) );
    }

    public List<Shampoo> getShampooBySizeOrLabel ( String size, Label label ) {
        return shampooRepository.findAllBySizeOrLabelOrderByPriceAsc ( valueOf ( size ), label );
    }

    @Override
    public List<Shampoo> getShampooByPriceGreaterThan ( double price ) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc ( BigDecimal.valueOf ( price ));
    }

    @Override
    public Integer getShampooCountWithPriceLowerThan ( Double price ) {
        return shampooRepository.countAllByPriceLessThan ( BigDecimal.valueOf ( price ) );
    }

    @Override
    public List<Shampoo> getShampooWithIngredientCount ( int count ) {
        return shampooRepository.findAllByIngredientsCount ( count );
    }
}
