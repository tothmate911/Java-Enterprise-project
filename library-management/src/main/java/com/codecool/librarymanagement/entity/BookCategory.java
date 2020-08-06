package com.codecool.librarymanagement.entity;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BookCategory {

    public BookCategory(String categoryName) {
        this.name = categoryName;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Singular
    @OneToMany(mappedBy = "bookCategory", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<DetailedBook> detailedBooks;

}


