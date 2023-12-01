package bacen.com.br.bacen.service;

import bacen.com.br.bacen.dto.Account;
import bacen.com.br.bacen.dto.ActiveRequest;
import bacen.com.br.bacen.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account save(Account account) {
        return repository.save(account);
    }

    @Transactional
    public ResponseEntity<Account> updateActiveStatus(Long id, ActiveRequest request) {
        Optional<Account> accountOptional = repository.findById(id);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setActive(request.getActive());
            return ResponseEntity.ok((repository.save(account)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Account getCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
