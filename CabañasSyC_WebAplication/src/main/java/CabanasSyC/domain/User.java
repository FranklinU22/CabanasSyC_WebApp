package CabanasSyC.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users") 
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=" idUser")
    private Long idUser;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "idNationality")
    private Nationality idNationality;
    
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol idRol;

    public User(String email, String password, Rol idRol){
        this.email = email;
        this.password = password;
        this.idRol = idRol;
    }
}
