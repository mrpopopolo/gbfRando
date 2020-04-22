package fr.pops.gbfRando.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.pops.gbfRando.business.entity.Chara;
import fr.pops.gbfRando.business.entity.User;
import fr.pops.gbfRando.business.service.CharacterService;
import fr.pops.gbfRando.business.service.UserService;

@Controller
public class IndexController {

	@Autowired
	CharacterService charaServ;
	
	@Autowired
	UserService userServ;

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login(User user) {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String testLogin(User user) {
		if(this.userServ.validate(user))
			{return "index.html";}
		return "index.html";
	}

	@GetMapping("/charaForm")
	public String charaForm(Chara chara) {
		return "newchara.html";
	}

	@PostMapping("/addChara")
	public String addChara(Chara chara, @RequestParam(value = "getPic") MultipartFile pic, Model model) {
		try {
			chara.setPicture(pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.charaServ.createChara(chara);
		return "redirect:/";
	}

	@GetMapping("/rando/{element}")
	public String rando(Model model, @PathVariable(value = "element") String element) {
		Base64.Encoder encoder = Base64.getEncoder();
		List<String[]> encodings = new ArrayList<>();
		for (Chara chara : this.charaServ.randomTeam(element)) {
			String encoding = "data:image/png;base64," + encoder.encodeToString(chara.getPicture());
			encodings.add(new String[] { chara.getName(), encoding });
		}
		model.addAttribute("charas", encodings);
		return "rando.html";
	}
}
