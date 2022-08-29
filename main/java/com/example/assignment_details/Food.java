package com.example.assignment_details;

public class Food {
    private String name, cook_time, prep_time, ingred, steps;

    public Food(){

    }

    public Food(String name, String cook_time, String prep_time, String ingred, String steps){
        this.name = name;
        this.cook_time = cook_time;
        this.prep_time = prep_time;
        this.ingred = ingred;
        this.steps = steps;
    }

    public String getFoodname() {
        return name;
    }

    public void setFoodname(String name) {
        this.name = name;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public String getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(String prep_time) {
        this.prep_time = prep_time;
    }

    public String getIngred() {
        return ingred;
    }

    public void setIngred(String ingred) {
        this.ingred = ingred;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
