package CabanasSyC.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cabintypes")

public class CabinType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCabinType")

    private Long idCabinType;
    
    private String name;
    @Column(name="numberOfBeds")
    private int numberOfBeds;
    private int capacity;
    private double price;
}
