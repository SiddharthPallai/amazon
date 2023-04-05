package com.epicminds.training.controller;

import com.epicminds.training.model.Item;
import com.epicminds.training.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import javax.validation.Valid;

/**
 * @author Sidharth
 */

@Controller
@RequestMapping("/items/")
public class ItemWebController {

    @Autowired
    ItemService itemService;

    @GetMapping("list")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "index";
    }

    @GetMapping("addItemForm")
    public String showAddItemForm(Item item) {
        return "add-Item";
    }

    @PostMapping("add")
    public String createItem(@Valid Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Item";
        }
        itemService.addItem(item);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    //public String showUpdateForm(@PathVariable("id") int id, Model model) {
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "edit-Item";
    }

    @PostMapping("update/{id}")
    //public String updateItem(@PathVariable("id") int id, @Valid Item item, BindingResult result,
     //                           Model model) {
    public String updateItem(@PathVariable("id") String id, @Valid Item item, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            item.setId(id);
            return "edit-Item";
        }

        itemService.updateItem(id,item);
        model.addAttribute("items", itemService.getItems());
        return "index";
    }

    @GetMapping("delete/{id}")
    //public String deleteItem(@PathVariable("id") int id, Model model) {
    public String deleteItem(@PathVariable("id") String id, Model model) {
        itemService.deleteItem(id);
        model.addAttribute("items", itemService.getItems());
        return "index";
    }
}
