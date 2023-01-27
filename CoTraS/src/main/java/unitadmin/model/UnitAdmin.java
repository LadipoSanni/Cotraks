package unitadmin.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import user.model.User;
import user.model.UserType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class UnitAdmin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private UserType staffType;
}
