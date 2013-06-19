package com.animalcompany.animalfarm.animalmodules.simplebindings;

import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animals.Animal;
import com.google.inject.AbstractModule;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalParentsModule extends AbstractModule {

    /* this will create a runtime error - cannot bind to self */
    @Override
    protected void configure() {
        bind(Home.class).to(Home.class);
        bind(Animal.class).to(Animal.class);
    }
}
