package uz.xb.rabbitmq.entity.second;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "abs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ABS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private String carName;

    public ABS(String message) {
        this.name = message;
    }
}
