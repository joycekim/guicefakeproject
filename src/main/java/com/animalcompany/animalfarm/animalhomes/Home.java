package com.animalcompany.animalfarm.animalhomes;

import com.animalcompany.animalfarm.DefaultValues;
import com.google.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home {
    protected String address;
    protected String type;

    @Inject
    public Home() {
        address = DefaultValues.HOME_DEFAULT_ADDRESS.getValue();
        type = DefaultValues.HOME_DEFAULT_TYPE.getValue();
    }

    public Home(String address, String material) {
        this.address = address;
        this.type = material;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public void printHomeInfo() {
        System.out.println("Your animal lives in a " + type + " located at " + address);
    }
}
