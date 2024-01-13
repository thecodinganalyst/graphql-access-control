package com.hevlar.graphql;

import com.hevlar.graphql.model.AccessControl;
import com.hevlar.graphql.model.Role;
import com.hevlar.graphql.service.AccessControlService;
import com.hevlar.graphql.service.RoleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApplicationStartup implements ApplicationRunner {

    @NonNull
    final RoleService roleService;

    @NonNull
    final AccessControlService accessControlService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role adminRole = roleService.create(
                Role.builder()
                        .name("admin")
                        .build()
        ).block();

        assert adminRole != null;
        List<AccessControl> adminAccessControlList = accessControlService.create(
                adminRole.getId(),
                        "Product",
                        "id", "name", "price", "cost")
                .collectList().block();

        Role anonymousRole = roleService.create(
                Role.builder()
                        .name("anonymous")
                        .build()
        ).block();
        List<AccessControl> anonymousAccessControlList = accessControlService.create(
                        adminRole.getId(),
                        "Product",
                        "id", "name", "price")
                .collectList().block();
    }
}
