package com.animalcompany.animalfarm.animalstats;

import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animals.Animal;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/24/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmurfStats extends AnimalStats {
    @Inject
    public SmurfStats(@Named("Smurf") Animal animal, @Named("Hut") Home home) {
        super(animal, home);
    }
}
