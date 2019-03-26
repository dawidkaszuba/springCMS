package pl.dawidkaszuba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.entity.Category;
import pl.dawidkaszuba.repository.CategoryRepository;

public class StringCategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String id) {
        return this.categoryRepository.findOne(Long.parseLong(id));
    }
}
