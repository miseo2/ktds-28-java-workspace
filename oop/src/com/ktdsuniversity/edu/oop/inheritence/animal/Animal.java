package com.ktdsuniversity.edu.oop.inheritence.animal;

public class Animal {
	
	private String animalSpecies; // 종
	private String name;
	private int age;
	private String sex;
	private double weight;
	private double tall;
	private int leg;
	
	public Animal (String animalSpecies,
					String name,
					int age,
					String sex,
					double weight,
					double tall,
					int leg) {
		this.animalSpecies = animalSpecies;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.tall = tall;
		this.leg = leg;
	}
	
	public String getAnimalSpecies() {
	    return this.animalSpecies;
	}
	
	public String getName() {
	    return this.name;
	}

	public int getAge() {
	    return this.age;
	}

	public String getSex() {
	    return this.sex;
	}

	public double getWeight() {
	    return this.weight;
	}

	public double getTall() {
	    return this.tall;
	}

	public int getLeg() {
	    return this.leg;
	}




}
