package com.animalcompany.animalfarm.animalmodules.morecomplexbindings;

import com.animalcompany.animalfarm.DefaultValues;
import com.animalcompany.animalfarm.animalhomes.Cage;
import com.animalcompany.animalfarm.animalhomes.Hole;
import com.animalcompany.animalfarm.animalhomes.Home;
import com.animalcompany.animalfarm.animalhomes.Hut;
import com.animalcompany.animalfarm.animals.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/24/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalComplexBindingsModule extends AbstractModule {

    /* now we want to build a real farm - we want to be able to have each of the animals: a generic animal,
    a cat, a cocker spaniel, a dog, a smurf, and we want to be able to have each of a homes: a generic home,
    a cage, a hole and a hut. The way we configured things in the simplebindings will no longer work. we now
    need an optional binding annotation (used the built-in ones. Guice will create a key-pair, specified by the
    combination of the specified annotation and type.
     */
    @Override
    protected void configure() {
        bind(Animal.class).annotatedWith(Names.named("Linus")).to(CockerSpaniel.class);
        bind(Animal.class).annotatedWith(Names.named("Dog")).to(Dog.class);
        bind(Animal.class).annotatedWith(Names.named("Cat")).to(Cat.class);
        bind(Animal.class).annotatedWith(Names.named("Animal")).to(Animal.class);
        bind(Animal.class).annotatedWith(Names.named("Smurf")).to(Smurf.class);

        bind(Home.class).annotatedWith(Names.named("Home")).to(Home.class);
        bind(Home.class).annotatedWith(Names.named("Cage")).to(Cage.class);
        bind(Home.class).annotatedWith(Names.named("Hole")).to(Hole.class);
        bind(Home.class).annotatedWith(Names.named("Hut")).to(Hut.class);

        bind(String.class).annotatedWith(Names.named("Fake String"))
                .toInstance(DefaultValues.FAKE_INSTANCE_STRING.getValue());
    }

    /* showcases how to use provides and how to pass arguments, configured above. Note that the Animal type is the
    parent of all the other parameter types and cocker Spaniel inherits from Dog

    Note: you may not and should not throw exceptions from Providers - read documentation,*/
    @Provides
    Map<String, Animal> getAnimalFarm(@Named("Dog") Animal dog, @Named("Cat") Animal cat,
                                         @Named("Smurf") Animal smurf, @Named("Animal") Animal animal,
                                         @Named("Linus") Animal cockerSpaniel) {
        Map<String, Animal> animals = new HashMap<String, Animal>();

        animals.put("Animal", animal);

        animals.put("Dog", dog);
        animals.put("Cat", cat);
        animals.put("Smurf", smurf);
        animals.put("Animal", animal);

        animals.put("Linus", cockerSpaniel);

        return animals;
    }


}
