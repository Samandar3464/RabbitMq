package uz.xb.rabbitmq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uz.xb.rabbitmq.configuration.MessageSender;
import uz.xb.rabbitmq.entity.first.Info;
import uz.xb.rabbitmq.entity.second.ABS;
import uz.xb.rabbitmq.model.UserRegisterDto;
import uz.xb.rabbitmq.service.UserService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api"
        ,
produces = MediaType.APPLICATION_JSON_VALUE,
consumes = MediaType.APPLICATION_JSON_VALUE
)
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

//    @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody UserRegisterDto dto){
//        return userService.register(dto);
//    }


    private final MessageSender messageSender;

    @PostMapping("/send")
    public String sendMessage(@RequestBody UserRegisterDto dto) {
        messageSender.sendMessage(dto.getName());
        return "Message sent to RabbitMQ: " + dto.getName();
    }
}
