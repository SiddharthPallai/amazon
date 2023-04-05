package com.epicminds.training.services;

import com.epicminds.training.exception.ItemNotFoundException;
import com.epicminds.training.model.Item;
//import com.epicminds.training.model.ItemType;

import java.util.List;

/**
 * @author Sidharth
 */
public interface ItemService {
    Item addItem(Item item);
    //1:1 UND
    //ItemType addItemType(ItemType itemType);

    //Item getItemById(Integer id) throws ItemNotFoundException;
    Item getItemById(String id) throws ItemNotFoundException;

    List<Item> getItems();
    //List<ItemType> getItemTypes();
    //List<ItemType> getItemsByItemType(String type);

    //Item updateItem(Integer itemId, Item item) throws ItemNotFoundException;
    Item updateItem(String itemId, Item item) throws ItemNotFoundException;

    //void deleteItem(Integer itemId) throws ItemNotFoundException;
    void deleteItem(String itemId) throws ItemNotFoundException;
}
