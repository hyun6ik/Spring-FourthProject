package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Human {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
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



    public void changeTeam(Team team) {
        this.team = team;
        team.getHumans().add(this);
    }
}
