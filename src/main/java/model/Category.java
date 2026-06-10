package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {

    /*
    This is an entity class.
    It represents one row in the table "category" in the database
     */

    @EqualsAndHashCode.Include
    private Long id;
    // Wrapper classer are used - values can be NULL

    @NonNull
    private String name;

    @Override
    public String toString() {
        return id + ": " + name;
    }

    public static void main(String[] args) {
        Category cat = new Category(1L, "Education");
        System.out.println(cat);

    }

    // Aufgabe: online: project lombok - was kann - interessieren

}
