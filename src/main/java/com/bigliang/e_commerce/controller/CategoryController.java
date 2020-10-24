package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Category;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.po.CategoryandGoods;
import com.bigliang.e_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/8 17:30
 */

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public BackTo addCategory(@RequestBody Category category) {
        int result = categoryService.addCategory(category);
        return result == 1 ? new BackTo(true, "成功添加一个分类", 200) : new BackTo(false, "添加失败！请重试！", 500);
    }

    @PostMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/updateName")
    public  BackTo updaeName(@RequestBody Map<String,String> map) {
        int result = categoryService.updateCategory(map);
        if (result == 1) {
            return new BackTo(true, "已将【" + map.get("oldName") + "】修改为【" + map.get("newName") +"】", 200);
        } else {
            return new BackTo(false, "重命名【" + map.get("oldName") + "】失败！", 200);
        }
    }

    @PostMapping("/getGBC")
    public CategoryandGoods getGBC(@RequestBody Map<String, String> map) {
        return categoryService.getGoodsByCategory(map.get("categoryID"));
    }
}
