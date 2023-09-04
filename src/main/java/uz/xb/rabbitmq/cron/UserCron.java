package uz.xb.rabbitmq.cron;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uz.xb.rabbitmq.configuration.MessageSender;
import uz.xb.rabbitmq.entity.first.Users;
import uz.xb.rabbitmq.service.UserService;


import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCron {

    private final UserService userService;
    private final MessageSender messageSender;

    @Scheduled(cron = "1 * * * * *")
    public void cron() {
        System.out.println("working");
        List<Users> users = userService.getAll();
        users.forEach(obj -> {
            messageSender.sendMessage(obj.getName());
        });
        System.out.println("stopped");
    }
}
