package uz.xb.rabbitmq.repository.first;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.xb.rabbitmq.entity.first.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
