package com.org.ags.controllers;

import com.org.ags.model.AccountDetails;
import com.org.ags.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@Tag(name="Account Controller", description = "Account Creation, Status Update, Get All Accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    @Operation(summary = "This end point is used to create new account and send notifications")
    public AccountDetails createNewAccount(@RequestBody AccountDetails accountDetails) {
        return accountService.createAccount(accountDetails);
    }

    @PutMapping("/{accountId}")
    @Operation(summary = "This end point is used to update account details and send notifications")
    public AccountDetails updateAccountDetails(@RequestBody AccountDetails accountDetails, @PathVariable("accountId") Integer accountId) {
        return accountService.updateAccountDetails(accountDetails, accountId);
    }

    @PatchMapping("/{accountId}")
    @Operation(summary = "This end point is used to update status and send notifications")
    public AccountDetails updateStatus(@RequestParam(name="status") String status, @PathVariable("accountId") Integer accountId) {
        return accountService.updateStautus(accountId, status);
    }

    @GetMapping
    @Operation(summary = "This end point is used to Get All account details and send notifications")
    public List<AccountDetails> getAccountDetails() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    @Operation(summary = "This end point is used to Get account details by accountId and send notifications")
    public AccountDetails updateAccountDetails(@PathVariable("accountId") Integer accountId) {
        return accountService.getAccountDetailsByAccountId(accountId);
    }

}
