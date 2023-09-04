package uz.xb.robbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.xb.robbitmq.entity.first.Info;
import uz.xb.robbitmq.entity.second.ABS;
import uz.xb.robbitmq.service.UserService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final UserService userService;

    @GetMapping
    public List<ABS> get() {
       return userService.fromPtoS();
    }
    @GetMapping("/a")
    public List<Info> getA() {
        return userService.fromStoP();
    }
}
