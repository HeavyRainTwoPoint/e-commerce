package com.bigliang.e_commerce.controller;

import com.bigliang.e_commerce.entity.Activity;
import com.bigliang.e_commerce.po.ActandPrize;
import com.bigliang.e_commerce.po.BackTo;
import com.bigliang.e_commerce.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/23 23:01
 */


@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping("/addAct")
    public Activity addAct(@RequestBody ActandPrize actandPrize) {
        boolean result = activityService.addNewActivity(actandPrize);
//        return result ? new BackTo(true, "成功添加一个活动！", 200)
//                : new BackTo(false, "活动添加失败!", 200);4
        return result ? actandPrize.getActivity() : null;
    }

    @PostMapping("/delAct")
    public BackTo delAct(@RequestBody Map<String, String> map) {
        int result = activityService.delActivity(map);
        return result == 1 ? new BackTo(true, "删除了一个活动！", 200)
                : new BackTo(false, "删除活动失败！", 200);
    }

    @PostMapping("/getAll")
    public List<Activity> getAll() {
        return activityService.getAllActivity();
    }

    @PostMapping("/searchAct")
    public List<Activity> searchAct(@RequestBody Activity activity) {
        return activityService.searchOnLimited(activity);
    }

    @PostMapping("/actDetails")
    public ActandPrize actDetails(@RequestBody Map<String, String> map) {
        return activityService.selectByActID(map.get("actID"));
    }

}
