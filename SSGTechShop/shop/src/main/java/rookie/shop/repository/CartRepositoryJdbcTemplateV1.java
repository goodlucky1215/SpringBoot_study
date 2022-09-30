package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;

import java.sql.PreparedStatement;
import java.util.List;

//@Repository
//@RequiredArgsConstructor
public class CartRepositoryJdbcTemplateV1 implements CartRepositoryInterface {

    //private final JdbcTemplate template;
    private JdbcTemplate template;

    @Override
    public List<CartEntity> findCartAll(MemberEntity memberEntity) {
        return null;
    }

    @Override
    public void cartItemDelete(CartEntity cartEntity) {

    }

    @Override
    public CartEntity findItemCart(ItemEntity itemEntity, MemberEntity memberEntity) {
        return null;
    }

    @Override
    public void cartSave(CartEntity cartEntity) {
        String sql = "insert into Cart(item_id, member_id, cart_quantity)" +
                " values(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, cartEntity.getItem().getId());
            ps.setLong(2, cartEntity.getMember().getId());
            ps.setInt(3, cartEntity.getQuantity());
            return ps;
        }, keyHolder);
    }
}
