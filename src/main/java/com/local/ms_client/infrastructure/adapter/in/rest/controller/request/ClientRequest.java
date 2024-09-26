package com.local.ms_client.infrastructure.adapter.in.rest.controller.request;

import com.local.ms_client.domain.enums.StateEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientRequest {

    private Long id;
    @NotNull
    @NotBlank
    private String name;
    private String secondName;
    @NotNull
    @NotBlank
    private String lastName;
    private String secondLastName;
    private String email;
    @NotNull
    @NotBlank
    private String phone;
    private String address;
    @NotNull
    private Long storeId;
    private StateEnum status;
}
