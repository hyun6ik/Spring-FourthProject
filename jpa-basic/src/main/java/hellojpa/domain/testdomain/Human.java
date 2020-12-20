package hellojpa.domain.testdomain;

import hellojpa.domain.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Human {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "human")
    private List<HumanProduct> humanProducts = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products = new ArrayList<>();

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "favorite_food",joinColumns =
        @JoinColumn(name = "member_id")
    )
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "address", joinColumns =
//        @JoinColumn(name = "member_id")
//    )
//    private List<Address> addressHistory = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "human_id")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public void changeTeam(Team team) {
        this.team = team;
        team.getHumans().add(this);
    }
}
