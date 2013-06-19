package com.animalcompany.animalfarm.animalstats;

import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animals.Animal;
import com.google.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalStats {
    protected Animal animal;
    protected Home home;

    protected AnimalStats() {}

    @Inject
    public AnimalStats(Animal animal, Home home) {
        this.animal = animal;
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

    public Animal getAnimal() {
        return animal;
    }
}

