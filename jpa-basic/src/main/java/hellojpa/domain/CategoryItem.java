package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class CategoryItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name ="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
