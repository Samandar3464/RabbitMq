package uz.xb.rabbitmq.service;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.xb.rabbitmq.configuration.MessageSender;
import uz.xb.rabbitmq.entity.first.Info;
import uz.xb.rabbitmq.entity.first.Users;
import uz.xb.rabbitmq.entity.second.ABS;
import uz.xb.rabbitmq.model.UserRegisterDto;
import uz.xb.rabbitmq.repository.first.InfoRepository;
import uz.xb.rabbitmq.repository.first.UsersRepository;
import uz.xb.rabbitmq.repository.second.ABSRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService  {

    @Qualifier("jdbcUser1")
    private final JdbcTemplate jdbcTemplate1;

    @Qualifier("jdbcUser2")
    private final JdbcTemplate jdbcTemplate2;

    private final ABSRepository absRepository;

    private final InfoRepository infoRepository;

    private final RabbitTemplate rabbitTemplate;
    private final MessageSender messageSender;


    private final UsersRepository usersRepository;

    public UserService(
            JdbcTemplate jdbcTemplate1,
            JdbcTemplate jdbcTemplate2,
            ABSRepository absRepository,
            InfoRepository infoRepository,
            RabbitTemplate rabbitTemplate,
            MessageSender messageSender,
            UsersRepository usersRepository) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
        this.absRepository = absRepository;
        this.infoRepository = infoRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.messageSender = messageSender;
        this.usersRepository = usersRepository;
    }

    public List<ABS> fromPtoS() {
        String query = "select u.id , u.name, s.car_name from users u  join car s on u.id = s.user_id";
        List<Map<String, Object>> maps = jdbcTemplate1.queryForList(query);
        List<ABS> usersList = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            ABS users = new ABS();
            users.setUserId((Integer) map.get("id"));
            users.setName((String) map.get("name"));
            users.setCarName((String) map.get("car_name"));
            usersList.add(users);
        }
        return usersList;
    }

    public List<Info> fromStoP() {
        List<Info> infoList = new ArrayList<>();
        for (ABS abs : absRepository.findAll()) {
            Info info = new Info(abs.getId(), abs.getUserId(), abs.getName(), abs.getCarName());
            infoList.add(info);
            infoRepository.save(info);
        }
        return infoList;
    }

    public ResponseEntity<?> register(UserRegisterDto dto) {
        messageSender.sendMessage(dto);
        return ResponseEntity.ok().body("Message sent to RabbitMQ: " + dto.getName());
    }
    public List<Users> getAll(){
        return  usersRepository.findAll();
    }

}
