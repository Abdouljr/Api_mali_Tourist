package com.malitourist.api.repository;

import com.malitourist.api.modele.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String nomRole);
}
