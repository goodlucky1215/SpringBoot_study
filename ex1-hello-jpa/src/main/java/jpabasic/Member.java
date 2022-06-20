package jpabasic;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Enumerated(EnumType.STRING)
    private  MemberType type;

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
