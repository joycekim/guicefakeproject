package com.animalcompany.animalfarm.animalmodules.simplebindings;

import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animalhomes.Hut;
import com.animalcompany.animalfarm.animals.Animal;
import com.animalcompany.animalfarm.animals.CockerSpaniel;
import com.google.inject.AbstractModule;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/24/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalLinusSubclassModule extends AbstractModule {

    /* created chained dependency - CockerSpaniel inherits from Dog, which inherits from Animal */
    @Override
    protected void configure() {
        bind(Animal.class).to(CockerSpaniel.class);
        bind(Home.class).to(Hut.class);
    }
}
