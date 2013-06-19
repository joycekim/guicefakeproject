package com.animalcompany.animalfarm.test;

import com.animalcompany.animalfarm.DefaultValues;
import com.animalcompany.animalfarm.animalmodules.simplebindings.AnimalDefaultsModule;
import com.animalcompany.animalfarm.animalmodules.simplebindings.AnimalDogHutChildModule;
import com.animalcompany.animalfarm.animalmodules.simplebindings.AnimalLinusSubclassModule;
import com.animalcompany.animalfarm.animalmodules.simplebindings.AnimalParentsModule;
import com.animalcompany.animalfarm.animalstats.AnimalStats;
import com.google.inject.CreationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalSimpleBindingsTest {

    /* We have bound AnimalDefaultsModule to the injector. Note that the
    * module's configure is empty - it pulls information from the parents, Home
    * and Animal, if nothing is configured. */
    @Test
    public void testDefaultWorks() throws Exception {
        Injector injector = Guice.createInjector(new AnimalDefaultsModule());
        AnimalStats animalStats = injector.getInstance(AnimalStats.class);

        /* AnimalStats's constructor has been invoked, letting Guice know it should automatically invoke it because
        it has an @Inject annotation. Guice hooks up the constructor's parameters for us so we do not need to
        explicitly call it.
         */

        doBindingTest(animalStats, DefaultValues.ANIMAL_DEFAULT_TYPE.getValue(),
                DefaultValues.ANIMAL_DEFAULT_NOISE.getValue(),
                DefaultValues.HOME_DEFAULT_TYPE.getValue(),
                DefaultValues.HOME_DEFAULT_ADDRESS.getValue());
    }

    /* we have bound classes to themselves, Guice doesn't like this and should throw an exception - note the excepted
    * exception test right next to the @Test annotation - useful to show we expect a CreationException.class */
    @Test (expected = CreationException.class)
    public void testWrongBinding() throws Exception {

        Injector injector = Guice.createInjector(new AnimalParentsModule());
        AnimalStats animalStats = injector.getInstance(AnimalStats.class);

        doBindingTest(animalStats, DefaultValues.ANIMAL_DEFAULT_TYPE.getValue(),
                DefaultValues.ANIMAL_DEFAULT_NOISE.getValue(),
                DefaultValues.HOME_DEFAULT_TYPE.getValue(),
                DefaultValues.HOME_DEFAULT_ADDRESS.getValue());
    }

    /* We have, via the configure function in AnimalDogHutChildModule, requested that Guice build an object graph for us.
    In the module's constructor, we have told Guice that whenever it sees a request for a Home object, it should
    hook it up with a, in this example, Hut object, and whenever it sees a request for an Animal object, it should
    hook it up with a Dog object. Only one test is provided, as testing other similar cases is redundant.
     */
    @Test
    public void testBindingWorks() throws Exception {
        Injector injector = Guice.createInjector(new AnimalDogHutChildModule());
        AnimalStats animalStats = injector.getInstance(AnimalStats.class);

        doBindingTest(animalStats, DefaultValues.ANIMAL_DOG_TYPE.getValue(),
                DefaultValues.ANIMAL_DOG_NOISE.getValue(),
                DefaultValues.HOME_CAGE_TYPE.getValue(),
                DefaultValues.HOME_CAGE_ADDRESS.getValue());
    }

    /* AnimalLinusSubclassModule use a chained linked binding (CockerSpaniel.class inherits from Dog.class, which
    inherits from Animal.class */
    @Test
    public void testSubclassBindingWorks() throws Exception {
        Injector injector = Guice.createInjector(new AnimalLinusSubclassModule());
        AnimalStats animalStats = injector.getInstance(AnimalStats.class);

        doBindingTest(animalStats, DefaultValues.ANIMAL_LINUS_TYPE.getValue(),
                DefaultValues.ANIMAL_LINUS_NOISE.getValue(),
                DefaultValues.HOME_HUT_TYPE.getValue(),
                DefaultValues.HOME_HUT_ADDRESS.getValue());
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
