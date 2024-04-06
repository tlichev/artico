package com.artico.artico.controllers;

import com.artico.artico.models.Product;
import com.artico.artico.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    @GetMapping("/")
    public String home(Model model) {
        List<Product> randomProducts = productService.getRandomProducts(2);

        model.addAttribute("products", randomProducts);
        return "index";
    }

    @GetMapping("/404")
    public String show404() {
        return "404";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
