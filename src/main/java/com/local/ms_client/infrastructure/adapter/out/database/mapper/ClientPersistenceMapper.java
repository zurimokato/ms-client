package com.local.ms_client.infrastructure.adapter.out.database.mapper;

import com.local.ms_client.domain.model.Client;
import com.local.ms_client.infrastructure.adapter.out.database.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientPersistenceMapper {

    Client toModel(ClientEntity entity);
    ClientEntity toEntity(Client client);
}
