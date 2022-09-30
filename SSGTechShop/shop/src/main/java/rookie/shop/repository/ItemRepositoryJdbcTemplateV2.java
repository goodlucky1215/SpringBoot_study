package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.ItemEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* NamedParameterJdbcTemplate
* */
@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemRepositoryJdbcTemplateV2 implements ItemRepositoryInterface {

    private final NamedParameterJdbcTemplate template;


    @Override
    public List<ItemEntity> findItemAll() {
        String sql =  "select item_id as id, item_name as name, item_price as price," +
                "item_group as group1, item_quantity as quantity from item";
        try {
            List<ItemEntity> itemEntity = template.query(sql, itemRowMapper());
            log.info("itemEnttity {}",itemEntity);
            return itemEntity;
        }catch (EmptyResultDataAccessException e){ //데이터가 없을 때 에러
            log.error("error : {}",e);
        }
        return null;
    }

    @Override
    public ItemEntity findItem(Long id) {
        String sql = "select item_id as id, item_name as name, item_price as price," +
                "item_group as group1, item_quantity as quantity"+
                " from item where item_id = :id";
        try {
            Map<String, Object> param = new HashMap(){{ put("id",id); }};
            ItemEntity itemEntity = template.queryForObject(sql,param, itemRowMapper());
            return itemEntity;
        }catch (EmptyResultDataAccessException e){ //데이터가 없을 때 에러

        }
        return null;
    }

    private RowMapper<ItemEntity> itemRowMapper() {
        return BeanPropertyRowMapper.newInstance(ItemEntity.class);
    }
}
