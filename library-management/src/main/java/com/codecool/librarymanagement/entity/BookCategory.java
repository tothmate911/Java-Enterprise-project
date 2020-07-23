package com.codecool.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
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
    @JsonIgnore
    private Set<DetailedBook> detailedBooks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCategory that = (BookCategory) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                Objects.equals(detailedBooks, that.detailedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, detailedBooks);
    }
}


