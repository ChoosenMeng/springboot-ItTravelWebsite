package com.itbaizhan.travel.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Product;
import com.itbaizhan.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/frontdesk/product")
public class FrontdeskProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询旅游线路
     *
     * @param cid     线路类别id
     * @param productName 线路名
     * @param page     页数
     * @param size     每页条数
     * @return
     */
    @RequestMapping("/routeList")
    public ModelAndView findProduct(Integer cid,
                                    String productName,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Product> productPage = productService.findProduct(cid, productName, page, size);
        modelAndView.addObject("productPage", productPage);
        modelAndView.addObject("cid", cid);
        modelAndView.addObject("productName", productName);
        modelAndView.setViewName("/frontdesk/route_list");
        return modelAndView;
    }

    // 线路详情
    @RequestMapping("/routeDetail")
    public ModelAndView findOne(Integer pid){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findOne(pid);

        modelAndView.addObject("product",product);
        modelAndView.setViewName("/frontdesk/route_detail");
        return modelAndView;
    }

}

