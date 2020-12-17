package hellojpa.testdomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Human> humans = new ArrayList<>();


    public void addMember(Human human) {
        human.setTeam(this);
        humans.add(human);
    }
}
