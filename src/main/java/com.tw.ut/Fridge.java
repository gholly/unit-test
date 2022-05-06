package com.tw.ut;

import java.util.ArrayList;
import java.util.List;

public class Fridge {

    protected List<Object> elephants = new ArrayList<>();
    protected final int MAX_CAPACITY = 10;
    protected boolean doorOpen;


    public void open() {
        doorOpen = true;
    }

    public void put(Object elephant) {
        if (isFull()) {
            throw new FridgeFullException();
        }
        elephants.add(elephant);
    }

    public void close() {
        doorOpen = false;
    }

    public boolean isFull() {
        return elephants.size() == MAX_CAPACITY;
    }


}
