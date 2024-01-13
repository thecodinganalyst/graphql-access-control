package com.hevlar.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("ACCESS_CONTROL")
public class AccessControl {
    @Id
    Long id;
    Long role;
    String entity;
    String col;
}
