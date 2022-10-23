package model;

public class VitalSignMetric {
    String name;
    double value;



    public String getName() {
        return name;
    }


    public double getValue() {
        return value;
    }





    public VitalSignMetric(String n, double w_in_k){
        name = n;
        value = w_in_k;


    }

}
