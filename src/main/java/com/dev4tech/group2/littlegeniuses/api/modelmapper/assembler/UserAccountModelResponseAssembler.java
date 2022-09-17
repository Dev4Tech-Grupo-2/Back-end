package com.dev4tech.group2.littlegeniuses.api.modelmapper.assembler;

import com.dev4tech.group2.littlegeniuses.api.model.response.UserAccountModelResponse;
import com.dev4tech.group2.littlegeniuses.domain.entity.UserAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserAccountModelResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UserAccountModelResponse toModel(UserAccount user) {
        return modelMapper.map(user, UserAccountModelResponse.class);
    }

    public Page<UserAccountModelResponse> toCollectionModel(Page<UserAccount> users) {
        return users.map(this::toModel);
    }

}
