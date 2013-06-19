package com.animalcompany.animalfarm.animalmodules.simplebindings;

import com.animalcompany.animalfarm.animalhomes.Cage;
import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animals.Animal;
import com.animalcompany.animalfarm.animals.Dog;
import com.google.inject.AbstractModule;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/24/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
/* example of binding a child to parent */
public class AnimalDogHutChildModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Animal.class).to(Dog.class);
        bind(Home.class).to(Cage.class);
    }

}
