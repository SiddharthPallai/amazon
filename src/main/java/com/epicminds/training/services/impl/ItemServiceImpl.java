package com.epicminds.training.services.impl;

import com.epicminds.training.exception.ItemNotFoundException;
import com.epicminds.training.model.Item;
//import com.epicminds.training.model.ItemType;
import com.epicminds.training.repository.ItemRepo;
//import com.epicminds.training.repository.ItemTypeRepo;
import com.epicminds.training.services.ItemService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Sidharth
 */
@Service
@CommonsLog
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;
    //@Autowired
    //ItemTypeRepo itemTypeRepo;

    @Override
    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    //public Item getItemById(Integer itemId) {
    public Item getItemById(String itemId) {
        return itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item (" + itemId + ") found")
        );
    }

    @Override
    public List<Item> getItems() {
        return itemRepo.findAll();
    }

    @Override
    //public Item updateItem(Integer itemId, Item item) {
    public Item updateItem(String itemId, Item item) {
        Item item1 = itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item (" + itemId + ") found")
        );
        item1.setName(Objects.isNull(item.getName()) ? item1.getName() : item.getName());
        item1.setQuantity(Objects.isNull(item.getQuantity()) ? item1.getQuantity() : item.getQuantity());
        item1.setPrice(Objects.isNull(item.getPrice()) ? item1.getPrice() : item.getPrice());
        return itemRepo.save(item1);
    }

    @Override
    //public void deleteItem(Integer itemId) {
    public void deleteItem(String itemId) {
        Item it = itemRepo.findById(itemId).orElseThrow(
                () -> new ItemNotFoundException("No such item found by id = " + itemId)
        );
        itemRepo.delete(it);
    }

}
