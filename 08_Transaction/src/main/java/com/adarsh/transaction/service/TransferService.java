package com.adarsh.transaction.service;

import com.adarsh.transaction.entity.Account;
import com.adarsh.transaction.entity.TransferRecord;
import com.adarsh.transaction.repository.AccountRepository;
import com.adarsh.transaction.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository,
                           AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount) throws Throwable {

        Account fromAccount =
                accountRepository.findById(fromAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Account toAccount =
                accountRepository.findById(toAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        accountRepository.saveAndFlush(fromAccount);

        toAccount.creditAccount(amount);
        accountRepository.saveAndFlush(toAccount);

        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));
        transferRepository.flush();

        throw new RuntimeException("Some Error Occured");
    }
}
