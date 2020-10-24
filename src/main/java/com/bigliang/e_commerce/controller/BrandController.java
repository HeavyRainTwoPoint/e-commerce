package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Brand;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.po.BrandandGoods;
import com.bigliang.e_commerce.service.BrandService;
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
 * @date 2020/10/8 17:29
 */

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/getAll")
    public List<Brand> getAll() {
        return brandService.getAllBrand();
    }

    @PostMapping("/addBrand")
    public BackTo addBrand(@RequestBody Brand brand) {
        if (brand.getBrandName().trim().equals("")) {
            return new BackTo(false, "品牌名不能为空！", 500);
        }
        int result = brandService.addBrand(brand);
        if (result == 1) {
            return new BackTo(true, "成功添加品牌：" + brand.getBrandName(), 200);
        } else {
            return new BackTo(false, "品牌【" + brand.getBrandName() + "】添加失败！", 200);
        }
    }

    @PostMapping("/updateName")
    public BackTo updateName(@RequestBody Map<String, String> map){
        int result = brandService.updateBrand(map);
        if (result == 1) {
            return new BackTo(true, "已将品牌【" + map.get("oldName") + "】修改为【" + map.get("newName") + "】", 200);
        } else {
            return new BackTo(false, "重命名【" + map.get("oldName") + "】失败！", 200);
        }
    }

    @PostMapping("/getGBB")
    public BrandandGoods getGBB(@RequestBody Map<String, String> map) {
        String brandName = map.get("brandName");
        if (brandName != null) {
            return brandService.getGoodsByBrand(brandName);
        } else {
            return null;
        }

    }
}
