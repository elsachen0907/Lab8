package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This is used to check whether thew given city belongs in the list
     * @param city
     * @return boolean true of false
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
//            System.out.println("The city belongs here");
            return true;
        }else {
//            System.out.println("The city does not belong here");
            return false;
        }
    }

    /**
     * This is to delete a city item form the list
     * @param city
     */
    public void delete(City city) {
        if (cities.contains(city)==false) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This is to count the total number of cities in the list.
     * @return the total count
     */
    public int countCities(){
        List list = cities;
        int countCity;
        countCity = list.size();
        return countCity;
//        return 1;
    }
}
