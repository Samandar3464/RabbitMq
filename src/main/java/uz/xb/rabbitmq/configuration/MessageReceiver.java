package uz.xb.rabbitmq.configuration;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Component;
import uz.xb.rabbitmq.entity.first.Users;
import uz.xb.rabbitmq.entity.second.ABS;
import uz.xb.rabbitmq.repository.first.UsersRepository;
import uz.xb.rabbitmq.repository.second.ABSRepository;

@Component
public class MessageReceiver implements MessageListener {
    private final UsersRepository usersRepository;
    private final ABSRepository absRepository;
    public MessageReceiver(UsersRepository usersRepository, ABSRepository absRepository) {
        this.usersRepository = usersRepository;
        this.absRepository = absRepository;
    }

//    @RabbitListener(queues = "register")   // bitta stringni RabbitMq dan olish
//    public void receiveMessage(String message) {
//        System.out.println("Received message: " + message +"RabbitWorking");
//        usersRepository.save(new Users(message));
//        // Process the message as needed
//    }


    @Override
    public void onMessage(Message message) {  // Objecti RabbitMq dan olish
        Users users = (Users) SerializationUtils.deserialize(message.getBody());
        System.out.println("Received message: " + message + "RabbitWorking");
        absRepository.save(new ABS(users.getName()));
    }
}
