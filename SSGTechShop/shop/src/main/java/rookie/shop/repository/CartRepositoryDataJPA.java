package rookie.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rookie.shop.entity.MemberEntity;

public interface CartRepositoryDataJPA extends JpaRepository<MemberEntity, Long> {
}
