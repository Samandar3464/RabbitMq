package uz.xb.robbitmq.repository.first;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.xb.robbitmq.entity.first.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
