package com.animalcompany.animalfarm.animalhomes;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hole extends Home {

    public Hole() {
        address = DefaultValues.HOME_HOLE_ADDRESS.getValue();
        type = DefaultValues.HOME_HOLE_TYPE.getValue();
    }

    public Hole(String address, String material) {
        super(address, material);
    }
}
