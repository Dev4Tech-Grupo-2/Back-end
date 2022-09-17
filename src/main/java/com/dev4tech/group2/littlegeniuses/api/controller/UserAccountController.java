package com.dev4tech.group2.littlegeniuses.api.controller;

import com.dev4tech.group2.littlegeniuses.api.model.request.PasswordModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.UserAccountModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.UserAccountWithPasswordModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.UserAccountModelResponse;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler.UserAccountModelResponseAssembler;
import com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler.UserAccountModelRequestDisassembler;
import com.dev4tech.group2.littlegeniuses.config.security.CheckSecurity;
import com.dev4tech.group2.littlegeniuses.domain.entity.UserAccount;
import com.dev4tech.group2.littlegeniuses.domain.repository.UserAccountRepository;
import com.dev4tech.group2.littlegeniuses.domain.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountModelResponseAssembler userAccountModelResponseAssembler;

    @Autowired
    private UserAccountModelRequestDisassembler userAccountModelRequestDisassembler;

    @CheckSecurity.Users.CanConsult
    @GetMapping
    public Page<UserAccountModelResponse> findAll(@PageableDefault(value = 10) Pageable pageable) {
        Page<UserAccount> userAccounts = userAccountRepository.findAll(pageable);

        Page<UserAccountModelResponse> userAccountModelResponse = userAccountModelResponseAssembler.toCollectionModel(userAccounts);

        return userAccountModelResponse;
    }

    @CheckSecurity.Users.CanConsult
    @GetMapping(path = "/{id}")
    public UserAccountModelResponse findById(@PathVariable Long id) {
        UserAccount userAccount = userAccountService.findById(id);

        return userAccountModelResponseAssembler.toModel(userAccount);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserAccountModelResponse insert(@RequestBody @Valid UserAccountWithPasswordModelRequest userAccountModelRequest) {
        UserAccount userAccount = userAccountModelRequestDisassembler.toDomainObject(userAccountModelRequest);

        userAccount = userAccountService.save(userAccount);

        UserAccountModelResponse userAccountModelResponse = userAccountModelResponseAssembler.toModel(userAccount);

        return userAccountModelResponse;
    }

    @CheckSecurity.Users.CanEdit
    @PutMapping(value = "/{id}")
    public UserAccountModelResponse update(@PathVariable Long id, @RequestBody @Valid UserAccountModelRequest userAccountModelRequest) {
        UserAccount currentUserAccount = userAccountService.findById(id);

        userAccountModelRequestDisassembler.copyToDomainObject(userAccountModelRequest, currentUserAccount);

        currentUserAccount = userAccountService.save(currentUserAccount);

        UserAccountModelResponse userAccountModelResponse = userAccountModelResponseAssembler.toModel(currentUserAccount);

        return userAccountModelResponse;
    }

    @CheckSecurity.Users.CanEdit
    @PutMapping("/{userId}/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@PathVariable Long userId, @RequestBody @Valid PasswordModelRequest password) {
        userAccountService.changePassword(userId, password.getCurrentPassword(), password.getNewPassword());
    }

    @CheckSecurity.Users.CanEdit
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userAccountService.delete(id);
    }

}
