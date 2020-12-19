package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue

    private Long id;

    @ManyToMany(mappedBy = "products")
    private List<Human> humans = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<HumanProduct> humanProducts = new ArrayList<>();

    private String name;



}
