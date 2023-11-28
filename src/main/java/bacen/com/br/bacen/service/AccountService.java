package bacen.com.br.bacen.service;

import bacen.com.br.bacen.dto.Account;
import bacen.com.br.bacen.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account save(Account account) {
        return repository.save(account);
    }

    public Account getCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
