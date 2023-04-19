package com.itbaizhan.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Category;
import com.itbaizhan.travel.pojo.Product;
import com.itbaizhan.travel.service.CategoryService;
import com.itbaizhan.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/backstage/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        Page<Product> productPage = productService.findPage(page, size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productPage", productPage);
        modelAndView.setViewName("/backstage/product_all");
        return modelAndView;
    }

    @RequestMapping("/addPage")
    public ModelAndView addPage() {
        // 查询所有产品类别
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("/backstage/product_add");
        return modelAndView;
    }


    @RequestMapping("/add")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/backstage/product/all";
    }

}

