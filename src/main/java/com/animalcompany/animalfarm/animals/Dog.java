package com.animalcompany.animalfarm.animals;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Dog extends Animal {

    public Dog() {
        this.noise = DefaultValues.ANIMAL_DOG_NOISE.getValue();
        this.type = DefaultValues.ANIMAL_DOG_TYPE.getValue();
    }

    public Dog(String noise, String type) {
        super(noise, type);
    }
}
