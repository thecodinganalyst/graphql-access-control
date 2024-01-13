package com.hevlar.graphql.service;

import com.hevlar.graphql.model.Role;
import com.hevlar.graphql.repository.RoleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RoleService {
    @NonNull
    final RoleRepository roleRepository;

    public Mono<Role> create(Role role){
        return roleRepository.save(role);
    }

    public Mono<Role> read(Long id){
        return roleRepository.findById(id);
    }

    public Flux<Role> list(){
        return roleRepository.findAll();
    }

    public Mono<Role> update(Role role){
        return roleRepository.save(role);
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}
