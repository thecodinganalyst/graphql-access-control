package com.hevlar.graphql.repository;

import com.hevlar.graphql.model.Role;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends R2dbcRepository<Role, Long> {
}
