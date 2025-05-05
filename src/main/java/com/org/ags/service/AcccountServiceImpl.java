package com.org.ags.service;

import com.org.ags.entity.AccountDetailsEntity;
import com.org.ags.kafkaproducer.MessageProducer;
import com.org.ags.model.AccountDetails;
import com.org.ags.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    private MessageProducer messageProducer;


    @Override
    public AccountDetails createAccount(AccountDetails accountDetails) {
        AccountDetails accountDetails1 = modelMapper.map(accountRepository.save(modelMapper.map(accountDetails, AccountDetailsEntity.class)), AccountDetails.class);
        notifyCreditCardDept(accountDetails1);
        sendEmailNotification(accountDetails1);
        sendSMSNotification(accountDetails1);
        return accountDetails1;
    }

    @Override
    public AccountDetails getAccountDetailsByAccountId(Integer accountId) {
        return modelMapper.map(accountRepository.getReferenceById(accountId), AccountDetails.class);
    }

    @Override
    public List<AccountDetails> getAllAccounts() {
        return modelMapper.map(accountRepository.findAll(), new TypeToken<List<AccountDetails>>() {}.getType());
    }

    @Override
    public AccountDetails updateAccountDetails(AccountDetails accountDetails, Integer accountId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(accountDetails);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return modelMapper.map(accountRepository.findById(accountId), AccountDetails.class);
    }

    @Override
    public AccountDetails updateStautus(Integer accountId, String status) {
        AccountDetailsEntity entity = accountRepository.findById(accountId).get();
        entity.setStatus(status);
        AccountDetails accountDetails = modelMapper.map(accountRepository.save(entity), AccountDetails.class);
        sendEmailNotification(accountDetails);
        sendSMSNotification(accountDetails);
        return accountDetails;
    }

    @Override
    public void notifyCreditCardDept(AccountDetails accountDetails) {
        messageProducer.sendMessage("creditCard-topic", accountDetails.toString());
    }

    @Override
    public void sendEmailNotification(AccountDetails accountDetails) {
        messageProducer.sendMessage("email-topic", accountDetails.toString());
    }

    @Override
    public void sendSMSNotification(AccountDetails accountDetails) {
        messageProducer.sendMessage("sms-topic", accountDetails.toString());
    }
}
