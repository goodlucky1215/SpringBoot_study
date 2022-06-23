package jpabasic.ex1hellojpa.co;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "TEAM_ID")
    //private Team team;

    //@Enumerated(EnumType.STRING)
    //private  MemberType type;

    //public void changeTeam(Team team){
     //   this.team = team;
    //    team.getMembers().add(this);
    //}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getUsername() {
    //    return username;
    //}

    //public void setUsername(String username) {
     //   this.username = username;
   // }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
