package pl.dawidkaszuba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dawidkaszuba.entity.Author;
import pl.dawidkaszuba.repository.AuthorRepository;

public class StringAuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author convert(String id) {
        return this.authorRepository.findOne(Long.parseLong(id));
    }
}
