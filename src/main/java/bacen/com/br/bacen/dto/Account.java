package bacen.com.br.bacen.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMERO")
    private String numberAccount;
    @Column(name = "AGENCIA")
    private String agency;
    @Column(name = "PIX")
    private String cpf;
    @Column(name = "SALDO")
    private BigDecimal balance = BigDecimal.ZERO;
}
