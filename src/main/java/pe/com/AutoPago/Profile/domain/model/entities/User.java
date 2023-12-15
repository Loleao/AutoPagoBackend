package pe.com.AutoPago.Profile.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String email;

    @Getter
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
