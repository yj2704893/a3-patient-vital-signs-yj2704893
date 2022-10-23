package ui;

import model.Patient;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Patient p1 = new Patient(0.0f);
        p1.addVitals(40, 1, 6, 0, 0);
        p1.addVitals(15, 1, 1, 1, 1);
        p1.addVitals(35, 140, 60, 2.5, 5.5);
        System.out.println("How are you? " + p1.howDoYouFeel());

        Patient p2 = new Patient(0.0f);
        p2.addVitals(40, 1, 6, 0, 0);
        p2.addVitals(15, 1, 1, 1, 1);
        p2.addVitals(350, 1400, 600, 2000.5, 50000.5);
        System.out.println("How are you? " + p2.howDoYouFeel());




    }
}
