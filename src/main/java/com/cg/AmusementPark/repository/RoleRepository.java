package com.cg.AmusementPark.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.AmusementPark.entities.ERole;
import com.cg.AmusementPark.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole name);

}
