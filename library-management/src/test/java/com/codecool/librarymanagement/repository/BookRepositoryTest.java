package com.codecool.librarymanagement.repository;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void saveOneSimple() {
        DetailedBook detailedBook = DetailedBook.builder()
                .title("title")
                .subtitle("subtitle")
                .build();
        bookRepository.save(detailedBook);
        assertThat(bookRepository.findAll())
                .hasSize(1);
    }

    @Test
    public void transientShouldNotBeSaved() {
        DetailedBook detailedBook = DetailedBook.builder()
                .title("title")
                .subtitle("subtitle")
                .error("this is a transient field")
                .build();

        bookRepository.save(detailedBook);
        entityManager.clear();

        List<DetailedBook> detailedBookList = bookRepository.findAll();
        assertThat(detailedBookList).allMatch(book -> book.getError() == null);
    }

}
