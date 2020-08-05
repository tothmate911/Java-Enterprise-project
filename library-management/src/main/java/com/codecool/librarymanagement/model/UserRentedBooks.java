package com.codecool.librarymanagement.model;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRentedBooks {
    private Integer id;
    private String username;
    private List<DetailedBook> books;

}
