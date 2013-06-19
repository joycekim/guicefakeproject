package com.animalcompany.animalfarm.animals;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/24/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class CockerSpaniel extends Dog {

    public CockerSpaniel () {
        this.noise = DefaultValues.ANIMAL_LINUS_NOISE.getValue();
        this.type = DefaultValues.ANIMAL_LINUS_TYPE.getValue();
    }

    public CockerSpaniel (String noise, String type) {
        super(noise, type);
    }
}
