import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static String ultrasound = "Nightingale";
    private static String ecg = "Seacole";
    private static String masseur = "Seacole";
    private static String dialysis = "Henderson";
    private static Boolean avaliable = true;
    private static int counter = 0;

    public static void main(String[] args) {
        HospitalInformation hos_i= new HospitalInformation();

        JFrame frame = new JFrame("Hospital Environmental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
        frame.setVisible(true);

        ArrayList<Ward> wards = new ArrayList<Ward>();
        wards.add(new Nightingale());
        wards.add(new Barton());
        wards.add(new Seacole());
        wards.add(new Dix());
        wards.add(new Henderson());
        wards.add(new Cavell());
        wards.add(new Breckinridge());
        wards.add(new Sanger());


        CollectPanel collectPanel = new CollectPanel(wards);

        collectPanel.refresh();
        frame.add(collectPanel);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //24 hours output
                int time = HospitalInformation.getHourCount();
                counter += 1;
                if  (counter == 24) {
                    counter = 0;
                    System.out.println("----- 24 Hours LOG -----");
                    for (int i = 0; i < wards.size(); i++) {
                        Ward w = wards.get(i);
                        System.out.printf("%s: Ultrasound=%b Ultrasound activity=%b ECG=%b ECG activity=%b Dialysis=%b Dialysis activity=%b Massage=%b Massage activity=%b%n",
                                w.getWard_name(),
                                w.getUltrasound(),
                                w.getUltrasound_act(),
                                w.getEcg(),
                                w.getEcg_act(),
                                w.getDialysis(),
                                w.getDialysis_act(),
                                w.getMasseur(),
                                w.getMasseur_act());
                    }
                }

                for (Ward ward : wards) {
                    ward.close_equip(time);
                }
                MedicalNotification med_i = HospitalInformation.getMedicalNotificationFromDoctor();
                String bay = med_i.getBay();
                String service = med_i.getService();

                // check not in use
                for (Ward ward : wards) {
                    avaliable = ward.check_not_in_use(service,bay);
                    if (avaliable == false){
                        break;
                    } else{
                        // send porter and update
                        //if (service == "None"){
                        //}else{HospitalInformation.requestPorter(bay, service);}

                        for (Ward ward1 : wards) {
                            ward1.move_bay(service, bay, time);
                        }
                    }
                }
                if (avaliable == true) {
                    if (service == "None"){
                    }else{HospitalInformation.requestPorter(bay, service);}

                }


                collectPanel.refresh();
                frame.repaint();
                HospitalInformation.waitAnHour();


            }
        });
        timer.start();

    }
}
