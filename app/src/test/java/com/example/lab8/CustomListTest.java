package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import android.util.Log;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * test whether we have the city
     */
    @Test
    void testHasCity(){
        list = MockCityList();
        // a new city which does not appear before, it should be FALSE for hascity method
        City city2 = new City("RedDeer", "Alberta");
        assertEquals(false,list.hasCity(city2));

    }

    @Test
    void testDeleteCity() {
        list = MockCityList();

        assertEquals(0, list.getCities().size());
        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.getCities().size());
        // index 0 first one is the mockcity (edmonton)
        City city1 = (City) list.getCities().get(0);
        list.delete(city1);
        // the size should equal to 0
        assertEquals(0, list.getCities().size());
        // does not include this city any more in the list
        assertFalse(list.getCities().contains(city1));

////         case where the city is not in the list, but we want to test the exception throw
//        cityList.delete(city1);
//        assertThrows( IllegalArgumentException.class, () -> {
//            cityList.delete(city1); });
    }


}
