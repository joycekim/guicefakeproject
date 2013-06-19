package com.animalcompany.animalfarm.animals;

import com.animalcompany.animalfarm.DefaultValues;

/* note abstract declaration: abstract classes cannot be instantiated, but can be subclassed */
public class Animal {
    protected String noise;
    protected String type;

    public Animal() {
        this.noise = DefaultValues.ANIMAL_DEFAULT_NOISE.getValue();
        this.type = DefaultValues.ANIMAL_DEFAULT_TYPE.getValue();
    }

    public Animal(String noise, String type) {
        this.noise = noise;
        this.type = type;
    }

    public String getNoise() {
        return noise;
    }

    public String getType() {
        return type;
    }

    public void printAnimalInfo() {
        System.out.println("Your " + getType() + " goes '" + getNoise() + "'");
    }
}
