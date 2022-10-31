package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
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
//        assertEquals(0,mockCity().compareTo(cityList.hasCity(city)));
        // add the mocklist city which appear before, should throw an exception
//        City city1 = new City("Edmonton", "Alberta");
//        cityList.hasCity(city1);
//        assertEquals(true, cityList.hasCity(city1));
//        assertThrows( IllegalArgumentException.class, () ->
//        {cityList.hasCity(city1);});

        // add a brand new city here, which does not appear before
        City city2 = new City("Calgary", "Alberta");
        assertEquals(false,list.hasCity(city2));

    }

}
