package net.BasicSpringApp.Gipost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.BasicSpringApp.Gipost.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
