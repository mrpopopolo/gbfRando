package fr.pops.gbfRando.business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Chara {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String element;

	private String rarity;

	// Limited, Summer...
	private String version;

	@Lob
	private byte[] Picture;

	public Chara() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getId() {
		return this.id;
	}

	public byte[] getPicture() {
		return this.Picture;
	}

	public void setPicture(byte[] picture) {
		this.Picture = picture;
	}

	public String getRarity() {
		return this.rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

}
