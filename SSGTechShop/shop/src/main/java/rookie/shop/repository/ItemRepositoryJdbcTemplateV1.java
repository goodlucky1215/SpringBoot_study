package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.ItemEntity;

import java.util.List;

//@Repository
//@RequiredArgsConstructor
public class ItemRepositoryJdbcTemplateV1 implements ItemRepositoryInterface {

    //private final JdbcTemplate template;
    private JdbcTemplate template;


    @Override
    public List<ItemEntity> findItemAll() {
        String sql =  "select item_id, item_name, item_price, item_quantity, item_group from item";
        try {
            List<ItemEntity> itemEntity = template.query(sql, itemRowMapper());
            return itemEntity;
        }catch (EmptyResultDataAccessException e){ //데이터가 없을 때 에러

        }
        return null;
    }

    @Override
    public ItemEntity findItem(Long id) {
        String sql = "select item_id, item_name, item_price, item_quantity, item_group " +
                " from item where item_id = ?";
        try {
            ItemEntity itemEntity = template.queryForObject(sql, itemRowMapper() ,id);
            return itemEntity;
        }catch (EmptyResultDataAccessException e){ //데이터가 없을 때 에러

        }
        return null;
    }

    private RowMapper<ItemEntity> itemRowMapper() {
        return ((rs, rowNum) -> {
           ItemEntity itemEntity = new ItemEntity();
           itemEntity.setId(rs.getLong("item_id"));
           itemEntity.setName(rs.getString("item_name"));
           itemEntity.setPrice(rs.getInt("item_price"));
           itemEntity.setQuantity(rs.getInt("item_quantity"));
           itemEntity.setGroup(rs.getString("item_group"));
           return itemEntity;
        });
    }
}
