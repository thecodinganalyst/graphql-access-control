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
        Role adminRole = createRole("admin");
        createAccessControl(adminRole, "Product", "id", "name", "price", "cost");

        Role userRole = createRole("user");
        createAccessControl(userRole, "Product", "id", "name", "price");
    }

    private void createAccessControl(Role role, String entity, String... cols) {
        List<AccessControl> accessControlList = accessControlService
                .create(role.getId(), entity, cols)
                .collectList()
                .block();
    }

    private Role createRole(String roleName) {
        return roleService.create(
                Role.builder()
                        .name(roleName)
                        .build()
        ).block();
    }
}
