package CabanasSyC.domain;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cabins")

public class Cabin implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCabin")
    private Long idCabin;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cabinType")
    private CabinType cabinType;
    
    @OneToMany(mappedBy = "cabin", cascade = CascadeType.ALL)
    private List<CabinImage> images;
}
