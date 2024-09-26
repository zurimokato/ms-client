package com.local.ms_client.infrastructure.adapter.in.rest.controller.response;

import com.local.ms_client.domain.enums.StateEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String email;
    private String phone;
    private String address;
    private Long storeId;
    private StateEnum status;
}
