package com.example.myapplicationtest2.CustomClasses;

import java.io.Serializable;
import java.util.List;

public class GeneraCollection implements Serializable {

    private String name;
    private List<book> generaCollection;

    public GeneraCollection(String name, List<book> generaCollection) {
        this.name = name;
        this.generaCollection = generaCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<book> getGeneraCollection() {
        return generaCollection;
    }

    public void setGeneraCollection(List<book> generaCollection) {
        this.generaCollection = generaCollection;
    }
}
