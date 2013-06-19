package com.animalcompany.animalfarm;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 5/23/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DefaultValues {
    ANIMAL_DEFAULT_NOISE("oink oink"),
    ANIMAL_DEFAULT_TYPE("pig"),
    ANIMAL_CAT_NOISE("ribbit... oops... meowww"),
    ANIMAL_CAT_TYPE("tiger"),
    ANIMAL_DOG_NOISE("bow wow woof woof"),
    ANIMAL_DOG_TYPE("rottweiler"),
    ANIMAL_SMURF_NOISE("hey... I'm a SMURF not an animal!"),
    ANIMAL_SMURF_TYPE("Smurfette"),
    ANIMAL_LINUS_NOISE("treats please"),
    ANIMAL_LINUS_TYPE("cocker spaniel"),

    HOME_DEFAULT_ADDRESS("the Upper East Side"),
    HOME_DEFAULT_TYPE("house"),
    HOME_CAGE_ADDRESS("The House"),
    HOME_CAGE_TYPE("wire cage"),
    HOME_HOLE_ADDRESS("In The Ditch"),
    HOME_HOLE_TYPE("deep dark hole"),
    HOME_HUT_ADDRESS("The Hill"),
    HOME_HUT_TYPE("wood shack"),

    FAKE_INSTANCE_STRING("Here is your fake string");

    private String value;

    private DefaultValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
