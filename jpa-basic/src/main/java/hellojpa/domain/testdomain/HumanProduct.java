package hellojpa.domain.testdomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_order")
@Getter @Setter
public class HumanProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "human_id")
    private Human human;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int orderAmount;
    private int orderDate;
}
