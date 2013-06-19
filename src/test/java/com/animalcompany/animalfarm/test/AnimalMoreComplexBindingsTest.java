package com.animalcompany.animalfarm.test;

import com.animalcompany.animalfarm.DefaultValues;
import com.animalcompany.animalfarm.animalmodules.morecomplexbindings.AnimalComplexBindingsModule;
import com.animalcompany.animalfarm.animals.Animal;
import com.animalcompany.animalfarm.animalstats.AnimalStats;
import com.animalcompany.animalfarm.animalstats.DogStats;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalMoreComplexBindingsTest {

    /* AnimalComplexBindingsModule now uses BindingAnnotations (build-in).
    Read the notes in AnimalComplexBindingsModule */
    @Test
    public void testAnnotatedBinding() throws Exception {
        Injector injector = Guice.createInjector(new AnimalComplexBindingsModule());
        AnimalStats animalStats = injector.getInstance(DogStats.class);

        doBindingTest(animalStats, DefaultValues.ANIMAL_DOG_TYPE.getValue(),
                DefaultValues.ANIMAL_DOG_NOISE.getValue(),
                DefaultValues.HOME_HUT_TYPE.getValue(),
                DefaultValues.HOME_HUT_ADDRESS.getValue());
    }

    /* tests AnimalComplexBindingsModule provides method */
    @Test
    public void testProvides() {
       Map<String, Animal> animals = Guice.createInjector(new AnimalComplexBindingsModule())
               .getInstance(Key.get(new TypeLiteral<Map<String, Animal>>() {}));

       assertEquals(animals.size(), 5);

       assertTrue(animals.containsKey("Animal"));
       assertTrue(animals.containsKey("Dog"));
       assertTrue(animals.containsKey("Cat"));
       assertTrue(animals.containsKey("Smurf"));
       assertTrue(animals.containsKey("Linus"));

       assertEquals(animals.get("Animal").getType(), DefaultValues.ANIMAL_DEFAULT_TYPE.getValue());
       assertEquals(animals.get("Dog").getType(), DefaultValues.ANIMAL_DOG_TYPE.getValue());
       assertEquals(animals.get("Cat").getType(), DefaultValues.ANIMAL_CAT_TYPE.getValue());
       assertEquals(animals.get("Smurf").getType(), DefaultValues.ANIMAL_SMURF_TYPE.getValue());
       assertEquals(animals.get("Linus").getType(), DefaultValues.ANIMAL_LINUS_TYPE.getValue());
    }

    /* tests an instance binding - per docs:
    "Avoid using .toInstance with objects that are complicated to create, since it can slow down application startup.
    You can use an @Provides method instead." */
    @Test
    public void testInstanceBinding() {
        String fakeString = Guice.createInjector(new AnimalComplexBindingsModule())
                .getInstance(new Key<String>(Names.named("Fake String")) {});

        System.out.println(fakeString);
        assertEquals(fakeString, DefaultValues.FAKE_INSTANCE_STRING.getValue());
    }

    private void doBindingTest(AnimalStats animalStats, String type, String noise, String material, String address) {
        System.out.println();
        animalStats.getAnimal().printAnimalInfo();
        animalStats.getHome().printHomeInfo();

        assertEquals(type, animalStats.getAnimal().getType());
        assertEquals(noise, animalStats.getAnimal().getNoise());
        assertEquals(material, animalStats.getHome().getType());
        assertEquals(address, animalStats.getHome().getAddress());
    }
}
