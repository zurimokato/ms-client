package com.local.ms_client.infrastructure.adapter.in.rest.controller.mapper;

import com.local.ms_client.domain.model.Client;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.request.ClientRequest;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.ClientResponse;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.PageResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ClientRestMapper {

    ClientResponse toResponse(Client source);
    Client toModel(ClientRequest source);
    PageResponse toPageResponse(Page<ClientResponse> source);
}
