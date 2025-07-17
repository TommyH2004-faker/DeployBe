package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByNameRole(String nameRole);

    public Role findBynameRole(String nameRole);
}
