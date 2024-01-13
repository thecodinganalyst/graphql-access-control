package com.hevlar.graphql.repository;

import com.hevlar.graphql.model.AccessControl;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessControlRepository extends R2dbcRepository<AccessControl, Long> {
}
