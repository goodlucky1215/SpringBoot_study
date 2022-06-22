package jpabasic;

import javax.persistence.*;
import java.util.List;

public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;


    @JoinColumn(name = "id")
    @OneToMany
    private List<Member> members;

    public List<Member> getMembers() {
        return members;
    }
}
