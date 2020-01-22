package fr.pops.gbfRando.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pops.gbfRando.business.entity.Chara;

@Repository
public interface CharacterRepository extends JpaRepository<Chara, Integer> {

	List<Chara> findByElement(String element);
}
