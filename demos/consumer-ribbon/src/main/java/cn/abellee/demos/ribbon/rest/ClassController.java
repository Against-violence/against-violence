package cn.abellee.demos.ribbon.rest;

import cn.abellee.core.domain.vo.Result;
import cn.abellee.demos.ribbon.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping("/classes")
    public Result hello(@RequestParam String name) {
        return classService.users(name);
    }

    @PostMapping("/classes")
    public Result hello(@RequestBody Map<String, String> params) {
        return classService.users(params);
    }

}
