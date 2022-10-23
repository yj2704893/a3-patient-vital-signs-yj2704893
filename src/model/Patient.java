package model;
import java.util.ArrayList;

public class Patient {
    float age;


    VitalSigns currentvitalSigns;
    ArrayList<VitalSigns> vitalSignsHistory;


    public Patient(float age){
        this.age = age;
        vitalSignsHistory = new ArrayList<VitalSigns>();
    }

    public boolean isPatientNormal(){
        return currentvitalSigns.areVitalsNormal(age);


    }

    public void addVitals(int rr, int hr, int bp, double w_in_k, double w_in_p){
        vitalSignsHistory.add(currentvitalSigns);
        currentvitalSigns = new VitalSigns(rr, hr, bp, w_in_k, w_in_p, this);

        
    }

    public String howDoYouFeel() {
        if (isPatientNormal()){
            return "I'm feeling well";
        }else{
            return "I'm not good";
        }
    }

    public float getAge() {
        return age;
    }





}
