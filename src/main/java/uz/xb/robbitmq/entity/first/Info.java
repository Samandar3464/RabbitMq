package uz.xb.robbitmq.entity.first;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private String carName;
}
