package com.springDeD.createPg;


import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;
public class Pg {
    private String id = UUID.randomUUID().toString();
    private String name;

    private int[] arrayStatistiche = {1,2,3,4,5,6,7,8,9};
    @NotEmpty
    public Pg(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getArrayStatistiche() {
        return arrayStatistiche;
    }

    public void setArrayStatistiche(int[] arrayStatistiche) {
        this.arrayStatistiche = arrayStatistiche;
    }
}
