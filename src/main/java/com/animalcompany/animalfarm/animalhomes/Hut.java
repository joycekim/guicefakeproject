package com.animalcompany.animalfarm.animalhomes;

import com.animalcompany.animalfarm.DefaultValues;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hut extends Home {

    public Hut() {
        address = DefaultValues.HOME_HUT_ADDRESS.getValue();
        type = DefaultValues.HOME_HUT_TYPE.getValue();
    }

    public Hut(String address, String material) {
        super(address, material);
    }
}
