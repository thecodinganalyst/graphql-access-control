package com.hevlar.graphql.service;

import com.hevlar.graphql.model.AccessControl;
import com.hevlar.graphql.repository.AccessControlRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AccessControlService {
    @NonNull
    final AccessControlRepository accessControlRepository;

    public Flux<AccessControl> create(Long role, String entity, String... cols){
        Stream<AccessControl> accessControlStream = Arrays.stream(cols)
                .map(col -> AccessControl.builder()
                        .role(role)
                        .entity(entity)
                        .col(col)
                        .build());
        return Flux.fromStream(accessControlStream).flatMap(this::create);
    }

    public Mono<AccessControl> create(AccessControl accessControl){
        return accessControlRepository.save(accessControl);
    }

    public Flux<AccessControl> list(){
        return accessControlRepository.findAll();
    }

    public Mono<AccessControl> read(Long id){
        return accessControlRepository.findById(id);
    }

    public Mono<AccessControl> update(AccessControl accessControl){
        return accessControlRepository.save(accessControl);
    }

    public void delete(Long id){
        accessControlRepository.deleteById(id);
    }
}
