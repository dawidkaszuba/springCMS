package pl.dawidkaszuba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.dao.AuthorDao;
import pl.dawidkaszuba.entity.Author;

public class StringAuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String id) {
        return this.authorDao.findById(Long.parseLong(id));
    }
}
