package rookie.shop.repository;

import rookie.shop.entity.ItemEntity;

import java.util.List;

public interface ItemRepositoryInterface {

    public List<ItemEntity> findItemAll();

    public ItemEntity findItem(Long id);
}
