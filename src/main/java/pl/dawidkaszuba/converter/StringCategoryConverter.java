package pl.dawidkaszuba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.dao.CategoriesDao;
import pl.dawidkaszuba.entity.Category;

public class StringCategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoriesDao categoriesDao;

    @Override
    public Category convert(String id) {
        return this.categoriesDao.findBuId(Long.parseLong(id));
    }
}
