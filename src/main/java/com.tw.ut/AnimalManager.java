package com.tw.ut;


public class AnimalManager {

    private Fridge fridge;

    public AnimalManager(Fridge fridge) {
        this.fridge = fridge;

    }

    public boolean store(Object object) {
        fridge.open();
        try {
            fridge.put(object);
            return true;
        } catch (FridgeFullException e) {
            return false;
        } finally {
            fridge.close();
        }

    }
}