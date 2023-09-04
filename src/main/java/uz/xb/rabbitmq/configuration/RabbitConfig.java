package uz.xb.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit // Enable RabbitMQ annotations
public class RabbitConfig { // RabbitMq dan objectni olish ucun Object (Serializable) classdan implement olgan bo'lishi kerak

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(
            ConnectionFactory connectionFactory, MessageReceiver messageListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(new Queue("register")); // Replace with your queue name
        container.setMessageListener(messageListener);
        return container;
    }

    // Other RabbitMQ configuration, if needed
}
