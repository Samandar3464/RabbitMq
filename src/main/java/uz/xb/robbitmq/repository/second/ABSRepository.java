package uz.xb.robbitmq.repository.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.xb.robbitmq.entity.second.ABS;

@Repository
public interface ABSRepository extends JpaRepository<ABS, Integer> {
}
