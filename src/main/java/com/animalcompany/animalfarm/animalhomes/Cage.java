package com.animalcompany.animalfarm.animalhomes;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cage extends Home {

    public Cage() {
        address = DefaultValues.HOME_CAGE_ADDRESS.getValue();
        type = DefaultValues.HOME_CAGE_TYPE.getValue();
    }

    public Cage(String address, String material) {
        super(address, material);
    }
}
