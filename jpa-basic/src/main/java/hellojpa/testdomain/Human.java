package hellojpa.testdomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Human {
    @Id
    @GeneratedValue
    @Column(name = "human_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    private String name;


    public void changeTeam(Team team) {
        this.team = team;
        team.getHumans().add(this);
    }
}
