package com.codecool.librarymanagement.repository;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<DetailedBook, Long> {

    List<DetailedBook> findAllByOrderByTitle();

    List<DetailedBook> findAllByBookCategoryOrderByTitle(BookCategory category);

    //List<DetailedBook> findAllByBookCategory(BookCategory category);

    List<DetailedBook> findAllByBookCategory_Name(String name);

    List<DetailedBook> findAllByTitleContainingIgnoreCase(String searchedString);

    List<DetailedBook> findAllByBookCategoryAndTitleContaining(BookCategory category, String searchedString);

    List<DetailedBook> findByIsbn13(String isbn13);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE DetailedBook d SET d.available=:available WHERE d.isbn13=:isbn13")
    void updateAvailable(@Param("isbn13") String isbn13, @Param("available") Boolean available);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE DetailedBook d SET d.duedate=:duedate WHERE d.isbn13=:isbn13")
    void updateDuedate(@Param("isbn13") String isbn13, @Param("duedate") Date date);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE DetailedBook detailedBook SET detailedBook.bookUser.id=: userId WHERE detailedBook.isbn13 =: isbn13")
    void updateUserId(@Param("book_user_id") String  userName, @Param("isbn13") String isbn13);

}
