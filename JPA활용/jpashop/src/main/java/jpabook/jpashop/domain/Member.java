package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //member라는 것에 의해서 맵핑이 되는 다는 거임.
    //mappedBy를 하는 순간 난 이제 거울일 뿐이야!!! 다대일 중에 다(FK)가 변경되면 같이 변경됨.
    //여기를 변경한다고해서 변경되지 않는다.
    private List<Order> order = new ArrayList<>();

}
