package com.itbaizhan.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Permission;
import com.itbaizhan.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    //遍历所有权限
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size){
        Page<Permission> permissionPage = permissionService.findPage(page,size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionPage",permissionPage);
        modelAndView.setViewName("/backstage/permission_all");
        return modelAndView;
    }

    //新增权限
    @RequestMapping("/add")
    public String add(Permission permission){
        permissionService.add(permission);
        return"redirect:/backstage/permission/all";
    }

    //跳转到修改权限页面
    @RequestMapping("/edit")
    public ModelAndView edit(Integer pid) {
        Permission permission = permissionService.findById(pid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("/backstage/permission_edit");
        return modelAndView;
    }
    //修改权限
    @RequestMapping("/update")
    public String update(Permission permission) {
        permissionService.update(permission);
        return "redirect:/backstage/permission/all";
    }

    //删除权限
    @RequestMapping("/delete")
    public String delete(Integer pid){
        permissionService.delete(pid);
        return "redirect:/backstage/permission/all";
    }


}
