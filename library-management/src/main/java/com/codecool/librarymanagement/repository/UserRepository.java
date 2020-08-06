package com.codecool.librarymanagement.repository;
import com.codecool.librarymanagement.entity.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<BookUser, Long> {

    Optional<BookUser> findByUsername(String username);

   /* @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE BookUser bookuser SET bookuser.rentedBooks=:detailedBook WHERE bookuser.id=:id")
    void rentBook(@Param("id") Long id, @Param("detailedBook") DetailedBook detailedBook);*/

}
