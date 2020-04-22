package fr.pops.gbfRando.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pops.gbfRando.business.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findOneByUsername(String username);
}
