package bacen.com.br.bacen.controller;

import bacen.com.br.bacen.dto.Account;
import bacen.com.br.bacen.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService service;

    private static Map<String, Account> cacheAccount = new HashMap<>();


    @PostMapping
    public ResponseEntity<Account> newAccount(@RequestBody Account account) {
        cacheAccount.put(account.getCpf(), account);
        Account accountCreated = service.save(account);
        return ResponseEntity.ok(accountCreated);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Account> getAccount(@PathVariable String cpf) {
        Account account = cacheAccount.get(cpf);
        if (account == null) {
            log.info("Buscando Conta com chavePix {} na base de dados...", cpf);
            return ResponseEntity.ok(service.getCpf(cpf));
        }
        log.info("A Conta com chavePix {} encontrada no cache.", cpf);
        return ResponseEntity.ok(account);
    }
}

