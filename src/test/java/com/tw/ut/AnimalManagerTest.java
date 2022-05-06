package com.tw.ut;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class AnimalManagerTest {


    //stub -- 控制doc（依赖组件）对sut(被测对象) 的间接输入

    @Test
    public void should_store_elephant_to_fridge_when_fridge_is_not_full_using_stub() {

        Fridge stubFridge = Mockito.mock(Fridge.class);

        doNothing().when(stubFridge).put("an elephant.");
        AnimalManager animalManager = new AnimalManager(stubFridge);

        boolean isStored = animalManager.store("an elephant.");

        assertTrue(isStored);

    }


    //spy
    @Test
    public void should_store_elephant_to_fridge_when_fridge_is_not_full_using_spy() {

        Fridge spyFridge = Mockito.spy(Fridge.class);

        AnimalManager animalManager = new AnimalManager(spyFridge);
        Object elephant = "an elephant.";

        boolean isStored = animalManager.store(elephant);
        ArgumentCaptor<Object> arg = ArgumentCaptor.forClass(Object.class);
        Mockito.verify(spyFridge).put(arg.capture());

        assertTrue(isStored);
        Assert.assertTrue(spyFridge.elephants.contains(elephant));
        assertEquals(arg.getValue(), elephant);
    }

    //mock object

    @Test
    public void should_store_elephant_to_fridge_when_fridge_is_not_full_using_mock() {

        Fridge mockFridge = Mockito.mock(Fridge.class);

        doNothing().when(mockFridge).put("an elephant.");
        AnimalManager animalManager = new AnimalManager(mockFridge);

        boolean isStored = animalManager.store("an elephant.");

        assertTrue(isStored);
        verify(mockFridge).open();
        verify(mockFridge).close();

    }


    //dummy
    @Test
    public void should_store_elephant_to_fridge_when_fridge_is_not_full_using_dummy() {

        Elephant dummyElephant = Mockito.mock(Elephant.class);  //dummyElephant只是一个参数，没有起到影响业务功能的作用，占位符
        Fridge mockFridge = Mockito.mock(Fridge.class);

        doNothing().when(mockFridge).put(dummyElephant);
        AnimalManager animalManager = new AnimalManager(mockFridge);

        boolean isStored = animalManager.store(dummyElephant);

        assertTrue(isStored);

    }


}
