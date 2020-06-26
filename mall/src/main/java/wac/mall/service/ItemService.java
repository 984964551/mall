package wac.mall.service;

import wac.mall.domain.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findbyorderid(Integer order_id);

}
