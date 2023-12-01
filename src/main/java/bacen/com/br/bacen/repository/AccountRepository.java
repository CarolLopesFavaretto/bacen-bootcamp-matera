package bacen.com.br.bacen.repository;

import bacen.com.br.bacen.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCpf(String cpf);

    Account save(Account account);
}
