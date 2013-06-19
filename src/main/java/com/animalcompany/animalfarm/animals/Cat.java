package com.animalcompany.animalfarm.animals;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cat extends Animal {

    public Cat() {
        this.noise = DefaultValues.ANIMAL_CAT_NOISE.getValue();
        this.type = DefaultValues.ANIMAL_CAT_TYPE.getValue();
    }

    public Cat(String noise, String type) {
        super(noise, type);
    }
}
