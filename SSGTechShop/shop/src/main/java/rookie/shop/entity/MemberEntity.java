package rookie.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//사용자 테이블
@Entity(name = "Member")
@Setter @Getter
public class MemberEntity {

    public MemberEntity() {

    }

    public MemberEntity(Long id){
        this.id = id;
    }


    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="member_name")
    private String name;
}
