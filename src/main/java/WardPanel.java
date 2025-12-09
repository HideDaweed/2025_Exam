import java.awt.*;
import javax.swing.*;

public class WardPanel extends JPanel {
    private JLabel ward_name;
    private JLabel ultrasound;
    private JLabel ecg;
    private JLabel dialysis;
    private JLabel masseur;
    private JLabel ultrasound_act;
    private JLabel ecg_act;
    private JLabel dialysis_act;
    private JLabel masseur_act;

    public WardPanel() {
        ward_name = new JLabel();
        ultrasound = new JLabel();
        ecg = new JLabel();
        dialysis = new JLabel();
        masseur = new JLabel();

        ultrasound_act = new JLabel();
        ecg_act = new JLabel();
        dialysis_act = new JLabel();
        masseur_act = new JLabel();

        add(ward_name);

        add(ultrasound);
        add(ecg);
        add(dialysis);
        add(masseur);

        add(ultrasound_act);
        add(ecg_act);
        add(dialysis_act);
        add(masseur_act);
    }
    public void create_panel(Ward w) {
        setLayout(new GridLayout(9, 1));
        ward_name.setText("Ward: " + w.getWard_name());
        ultrasound.setText("Ultrasound: " +String.valueOf(w.getUltrasound()));
        ultrasound_act.setText("Ultrasound Status: " +String.valueOf(w.getUltrasound_act()));
        ecg.setText("ECG: " +String.valueOf(w.getEcg()));
        ecg_act.setText("ECG Status: " +String.valueOf(w.getEcg_act()));
        dialysis.setText("Dialysis: " +String.valueOf(w.getDialysis()));
        dialysis_act.setText("Dialysis Status: " +String.valueOf(w.getDialysis_act()));
        masseur.setText("Masseur: " +String.valueOf(w.getMasseur()));
        masseur_act.setText("Masseur Status: " +String.valueOf(w.getMasseur_act()));
    }
}
