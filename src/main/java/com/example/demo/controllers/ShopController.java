package com.example.demo.controllers;

import com.example.demo.models.Shop;
import com.example.demo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping
    public String showShops(Model model) {
        List<Shop> shops = shopService.getShopList();
        model.addAttribute("shops", shops);
        return "manage-shops";
    }

    @RequestMapping("/add")
    public String showAddShopForm(Model model) {
        Shop shop = new Shop();
        model.addAttribute("shop", shop);
        return "edit-shop";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitAddShopForm(@ModelAttribute("edit-shop") Shop shop) {
        shopService.saveShop(shop);
        return "redirect:/shops";
    }

    @RequestMapping("/edit/{id}")
    public String showEditShopForm(@PathVariable(value = "id") int id, Model model) {
        Shop shop = shopService.getShopById(id);
        model.addAttribute("shop", shop);
        return "edit-shop";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String submitEditShopForm(@ModelAttribute("edit-shop") Shop shop) {
        shopService.saveShop(shop);
        return "redirect:/shops";
    }

    @RequestMapping("/delete/{id}")
    public String deleteShop(@PathVariable(value = "id") int id) {
        shopService.deleteShopById(id);
        return "redirect:/shops";
    }

}
