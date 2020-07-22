package com.codecool.librarymanagement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BookCategory {


    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category name;

    @Singular
    @OneToMany(mappedBy = "bookCategory", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<DetailedBook> detailedBooks;


}


