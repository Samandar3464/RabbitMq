//package uz.xb.rabbitmq.service;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//import uz.xb.rabbitmq.entity.first.Users;
//import uz.xb.rabbitmq.repository.first.UsersRepository;
//
//@Component
//public class MessageReceiver {
//private final UsersRepository usersRepository;
//
//    public MessageReceiver(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//    @RabbitListener(queues = "register")
//    public void receiveMessage(String message) {
//        System.out.println("Received message: " + message +"RabbitWorking");
//        usersRepository.save(new Users(message));
//        // Process the message as needed
//    }
//}
