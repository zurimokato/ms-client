package com.local.ms_client.infrastructure.adapter.out.database.entity;


import com.local.ms_client.domain.enums.StateEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientEntity {
    @Id
    private Long id;
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    private String email;
    private String phone;
    private String address;
    @Column(name = "store_id")
    private Long storeId;
    @Enumerated(EnumType.STRING)
    private StateEnum status;
}
