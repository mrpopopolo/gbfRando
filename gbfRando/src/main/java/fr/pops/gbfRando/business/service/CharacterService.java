package fr.pops.gbfRando.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pops.gbfRando.business.entity.Chara;
import fr.pops.gbfRando.persistence.CharacterRepository;

@Service
public class CharacterService {

	@Autowired
	CharacterRepository charaRep;

	public void createChara(Chara chara) {
		this.charaRep.save(chara);
	}

	public Chara readChara(Integer id) {
		return this.charaRep.getOne(id);
	}

	public List<Chara> randomTeam(String element) {
		List<Chara> list = this.charaRep.findByElement(element);
		Random rand = new Random();
		int x;
		List<Chara> randomized = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			x = rand.nextInt(list.size());
			randomized.add(list.get(x));
			list.remove(x);
		}
		return randomized;
	}
}
