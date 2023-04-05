package com.epicminds.training.repository;

import com.epicminds.training.model.Item;
//import com.epicminds.training.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sidharth
 */
@Repository
//public interface ItemRepo extends JpaRepository<Item, Integer> {
public interface ItemRepo extends MongoRepository<Item, String> {

  Item findByName(String name);
  List<Item> findByNameContainingIgnoreCase(String name);
}
