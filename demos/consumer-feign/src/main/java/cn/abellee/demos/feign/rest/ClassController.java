package cn.abellee.demos.feign.rest;

import cn.abellee.core.domain.vo.Result;
import cn.abellee.demos.feign.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/classes")
    public Result hello(@RequestParam String name) {
        return classService.users(name);
    }

    @PostMapping("/classes")
    public Result hello(@RequestBody Map map) {
        return classService.users(map);
    }

}
