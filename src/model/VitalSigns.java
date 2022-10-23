package model;

import java.util.ArrayList;

public class VitalSigns {
    Patient patient;
    ArrayList<VitalSignMetric> metrics;
    // int respiratoryRate;
    // int heartRate;
    // int bloodPressure;
    // float weightinKilo;
    // float weightinPounds;

    public VitalSigns(int rr, int hr, int bp, double w_in_k, double w_in_p, Patient p){

        metrics = new ArrayList<VitalSignMetric>();
        metrics.add(new VitalSignMetric("Respiratory Rate", rr));
        metrics.add(new VitalSignMetric("Heart Rate", hr));
        metrics.add(new VitalSignMetric("Blood Pressure", bp));
        metrics.add(new VitalSignMetric("Weight in KG", w_in_k));
        metrics.add(new VitalSignMetric("Weight in lbs", w_in_p));
        patient = p;

        // respiratoryRate = rr;
        // heartRate = hr;
        // bloodPressure = bp;
        // weightinKilo = w_in_k;
        // weightinPounds = w_in_p;
    }

    public boolean areVitalsNormal(float age){
        boolean result = true;

        for (VitalSignMetric vsign : metrics)
            if (!isVitalSignNormal(vsign)) result = false;
        // if (!isheartRateNormal(age)) result = false;
        // if (!isbloodPressureNormal(age)) result = false;
        // if (!isWeightInKgNormal(age)) result = false;
        // if (!isWeightInLbsNormal(age)) result = false;
        return result;
        }
        


    public boolean isVitalSignNormal(VitalSignMetric metric){
        boolean result = true;
        float age = patient.getAge();
        // System.out.println("Age: " + age);
        if (metric.getName() == "Respiratory Rate"){
        if ((age == 0.0f) && ((metric.getValue()<30) || (metric.getValue()>50))) result = false;
        if ((inAgeRange(age, 0, 12)) && (inRange(metric.getValue(), 20, 30))) result = false;
        if ((age >= 13.0f) && (inRange(metric.getValue(), 12, 20))) result = false;
        // System.out.println("resp rate: " + result);
        }

        if (metric.getName() == "Heart Rate"){
            if ((age == 0.0f) && ((metric.getValue()<120) || (metric.getValue()>160))) result = false;
            if ((inAgeRange(age, 0, 1)) && (inRange(metric.getValue(), 80, 140))) result = false;
            if ((inAgeRange(age, 1, 3)) && (inRange(metric.getValue(), 80, 130))) result = false;
            if ((inAgeRange(age, 3, 5)) && (inRange(metric.getValue(), 80, 120))) result = false;
            if ((inAgeRange(age, 5, 12)) && (inRange(metric.getValue(), 70, 110))) result = false;
            if ((age >= 13.0f) && (inRange(metric.getValue(), 55, 105))) result = false;
            // System.out.println("heart rate: " + result);
            }
        
        if (metric.getName() == "Blood Pressure"){
            if ((age == 0.0f) && ((metric.getValue()<50) || (metric.getValue()>70))) result = false;
            if ((inAgeRange(age, 0, 1)) && (inRange(metric.getValue(), 4, 10))) result = false;
            if ((inAgeRange(age, 1, 3)) && (inRange(metric.getValue(), 10, 14))) result = false;
            if ((inAgeRange(age, 3, 5)) && (inRange(metric.getValue(), 14, 18))) result = false;
            if ((inAgeRange(age, 5, 12)) && (inRange(metric.getValue(), 20, 42))) result = false;
            if ((age >= 13.0f) && (metric.getValue()<50)) result = false;
            // System.out.println("blood pressure: " + result);
            }
            
        if (metric.getName() == "Weight in KG"){
            if ((age == 0.0f) && ((metric.getValue()<2) || (metric.getValue()>3))) result = false;
            if ((inAgeRange(age, 0, 1)) && (inRange(metric.getValue(), 4, 10))) result = false;
            if ((inAgeRange(age, 1, 3)) && (inRange(metric.getValue(), 10, 14))) result = false;
            if ((inAgeRange(age, 3, 5)) && (inRange(metric.getValue(), 14, 18))) result = false;
            if ((inAgeRange(age, 5, 12)) && (inRange(metric.getValue(), 20, 42))) result = false;
            if ((age >= 13.0f) && (metric.getValue()<50)) result = false;
            // System.out.println("KG: " + result);
            }

        if (metric.getName() == "Weight in lbs"){
            if ((age == 0.0f) && ((metric.getValue()<4.5) || (metric.getValue()>7))) result = false;
            if ((inAgeRange(age, 0, 1)) && (inRange(metric.getValue(), 9, 22))) result = false;
            if ((inAgeRange(age, 1, 3)) && (inRange(metric.getValue(), 22, 31))) result = false;
            if ((inAgeRange(age, 3, 5)) && (inRange(metric.getValue(), 31, 40))) result = false;
            if ((inAgeRange(age, 5, 12)) && (inRange(metric.getValue(), 41, 92))) result = false;
            if ((age >= 13.0f) && (metric.getValue()<110)) result = false;
            // System.out.println("lbs: " + result);
            }

        return result;
    }

    public boolean inRange(double d, double min, double max){
        if ((d < min) || (d > max)) return false;
        else return true;
    }

    public boolean inAgeRange(double age, double min, double max){
        if((age>min) && (age<=max))return true;
        else return false;
    }

/***
    public boolean isheartRateNormal(float age){
        boolean result = true;
        if ((age == 0.0f) && ((heartRate<=120) || (heartRate>160))) result = false;
        if (((age > 0.0f) && (age <= 1.0f)) || ((heartRate<80) && (heartRate>140))) result = false;
        if (((age > 1.0f) && (age <= 3.0f)) || ((heartRate<80) && (heartRate>130))) result = false;
        if (((age > 3.0f) && (age <= 5.0f)) || ((heartRate<80) && (heartRate>120))) result = false;
        if (((age > 5.0f) && (age <= 12.0f)) || ((heartRate<70) && (heartRate>110))) result = false;
        if ((age >= 13.0f) && ((heartRate<55) || (heartRate>105))) result = false;
        return result;
    }

    public boolean isbloodPressureNormal(float age){
        boolean result = true;
        if ((age == 0.0f) && ((bloodPressure<=50) || (bloodPressure>70))) result = false;
        if (((age > 0.0f) && (age <= 1.0f)) || ((bloodPressure<70) && (bloodPressure>100))) result = false;
        if (((age > 1.0f) && (age <= 3.0f)) || ((bloodPressure<80) && (bloodPressure>110))) result = false;
        if (((age > 3.0f) && (age <= 5.0f)) || ((bloodPressure<80) && (bloodPressure>110))) result = false;
        if (((age > 5.0f) && (age <= 12.0f)) || ((bloodPressure<70) && (bloodPressure>120))) result = false;
        if ((age >= 13.0f) && ((bloodPressure<110) || (bloodPressure>120))) result = false;
        return result;
    }

    public boolean isWeightInKgNormal(float age){
        boolean result = true;
        if ((age == 0.0f) && ((weightinKilo<=2) || (weightinKilo>3))) result = false;
        if (((age > 0.0f) && (age <= 1.0f)) || ((weightinKilo<4.0f) && (weightinKilo>10.0f))) result = false;
        if (((age > 1.0f) && (age <= 3.0f)) || ((weightinKilo<10.0f) && (weightinKilo>14.0f))) result = false;
        if (((age > 3.0f) && (age <= 5.0f)) || ((weightinKilo<14.0f) && (weightinKilo>18.0f))) result = false;
        if (((age > 5.0f) && (age <= 12.0f)) || ((weightinKilo<20.0f) && (weightinKilo>42.0f))) result = false;
        if ((age >= 13.0f) && (weightinKilo>50.0f)) result = false;
        return result;
    }

    public boolean isWeightInLbsNormal(float age){
        boolean result = true;
        if ((age == 0.0f) && ((weightinPounds<=4.5f) || (weightinPounds>7.0f))) result = false;
        if (((age > 0.0f) && (age <= 1.0f)) || ((weightinPounds<9.0f) && (weightinPounds>22.0f))) result = false;
        if (((age > 1.0f) && (age <= 3.0f)) || ((weightinPounds<22.0f) && (weightinPounds>31.0f))) result = false;
        if (((age > 3.0f) && (age <= 5.0f)) || ((weightinPounds<31.0f) && (weightinPounds>40.0f))) result = false;
        if (((age > 5.0f) && (age <= 12.0f)) || ((weightinPounds<41.0f) && (weightinPounds>92.0f))) result = false;
        if ((age >= 13.0f) && (weightinPounds>110.0f)) result = false;
        return result;
    }



        if ((age == 0.0f) && (inRange(respiratoryRate, 30, 50))) result = false;
        if ((age > 0.0f) && (age <= 12.0f) && (inRange(respiratoryRate, 20, 30))) result = false;
        if ((age >=13.0f)  && (inRange(respiratoryRate, 12, 20))) result = false;
        
***/




}
