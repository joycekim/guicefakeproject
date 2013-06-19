package com.animalcompany.animalfarm.animals;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Smurf extends Animal {

    public Smurf () {
        this.noise = DefaultValues.ANIMAL_SMURF_NOISE.getValue();
        this.type = DefaultValues.ANIMAL_SMURF_TYPE.getValue();
    }

    public Smurf(String noise, String type) {
        super(noise, type);
    }
}
