package com.dev4tech.group2.littlegeniuses.api.modelmapper.disassembler;

import com.dev4tech.group2.littlegeniuses.api.model.request.UserAccountModelRequest;
import com.dev4tech.group2.littlegeniuses.domain.entity.UserAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountModelRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserAccount toDomainObject(UserAccountModelRequest userAccountModelRequest) {
        return modelMapper.map(userAccountModelRequest, UserAccount.class);
    }

    public void copyToDomainObject(UserAccountModelRequest userAccountModelRequest, UserAccount user) {
        modelMapper.map(userAccountModelRequest, user);
    }

}
