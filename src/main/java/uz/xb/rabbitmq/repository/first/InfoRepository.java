package uz.xb.rabbitmq.repository.first;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.xb.rabbitmq.entity.first.Info;

public interface InfoRepository extends JpaRepository<Info, Integer> {
}
