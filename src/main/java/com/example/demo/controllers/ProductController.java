package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.models.Shop;
import com.example.demo.services.ProductService;
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
@RequestMapping("/shops/products")
public class ProductController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{shopId}")
    public String showShopProducts(@PathVariable(value = "shopId") int shopId, Model model) {
        Shop shop = shopService.getShopById(shopId);
        List<Product> products = shop.getProducts();
        model.addAttribute("shop", shop);
        model.addAttribute("products", products);
        return "manage-products";
    }

    @RequestMapping("/delete/{shopId}/{productId}")
    public String deleteProduct(@PathVariable(value = "shopId") int shopId, @PathVariable(value = "productId") int productId) {
        Product product = productService.getProductById(productId);
        product.setDeleted(true);
        productService.saveProduct(product);
        return "redirect:/shops/products/" + shopId;
    }

    @RequestMapping("/add/{shopId}")
    public String addProduct(@PathVariable(value = "shopId") int shopId, Model model) {
        Shop shop = shopService.getShopById(shopId);
        Product product = new Product();
        model.addAttribute("shop", shop);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @RequestMapping(value = "/add/{shopId}", method = RequestMethod.POST)
    public String submitAddProductFrom(@ModelAttribute("edit-product") Product product, @PathVariable(value = "shopId") int shopId) {
        Shop shop = shopService.getShopById(shopId);
        product.setPrice(product.getPrice() * 100);
        product.setShop(shop);
        productService.saveProduct(product);
        return "redirect:/shops/products/" + shopId;
    }

    @RequestMapping("/edit/{shopId}/{productId}")
    public String editProduct(@PathVariable(value = "shopId") int shopId, @PathVariable(value = "productId") int productId, Model model) {
        Shop shop = shopService.getShopById(shopId);
        Product product = productService.getProductById(productId);
        model.addAttribute("shop", shop);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @RequestMapping(value = "/edit/{shopId}/{productId}", method = RequestMethod.POST)
    public String submitEditProductForm(@ModelAttribute("edit-product") Product product, @PathVariable(value = "productId") int productId,
                                        @PathVariable(value = "shopId") int shopId) {
        Product productFromDb = productService.getProductById(productId);
        productFromDb.setName(product.getName());
        productFromDb.setPrice(product.getPrice() * 100);
        productService.saveProduct(productFromDb);
        return "redirect:/shops/products/" + shopId;
    }

}
