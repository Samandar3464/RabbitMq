package uz.xb.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue("register", false);
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("register", message);
    }
}

