package com.animalcompany.animalfarm;

/**
 * Created with IntelliJ IDEA.
 * User: joyce
 * Date: 6/11/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMain<T> {
    private Class<T> testClass;

    public TestMain(Class<T> testClass) {
        this.testClass = testClass;
    }

    public T create() throws IllegalAccessException, InstantiationException {
        return testClass.newInstance();
    }

    public static void main(String[] args) {

    }
}
