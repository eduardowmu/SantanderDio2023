package dio.me.edu.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numBank;
    private String agency;
    @Column(scale = 13, precision = 2)
    private BigDecimal balance;
    @Column(name = "additional_limit", scale = 13, precision = 2)
    private BigDecimal limit;
}