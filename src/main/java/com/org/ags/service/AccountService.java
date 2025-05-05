package com.org.ags.service;

import com.org.ags.model.AccountDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    AccountDetails createAccount(AccountDetails accountDetails);

    AccountDetails getAccountDetailsByAccountId(Integer accountId);

    List<AccountDetails> getAllAccounts();

    AccountDetails updateAccountDetails(AccountDetails accountDetails,Integer accountId);

    AccountDetails updateStautus(Integer accountId, String status);

    void notifyCreditCardDept(AccountDetails accountDetails);

    void sendEmailNotification(AccountDetails accountDetails);

    void sendSMSNotification(AccountDetails accountDetails);

}
