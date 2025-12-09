import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollectPanel extends JPanel {
    private ArrayList<WardPanel> wardPanels;
    private ArrayList<Ward> wards_list_1;
    public  CollectPanel(ArrayList<Ward> wards_list) {
        this.wards_list_1 = wards_list;
        this.wardPanels = new ArrayList<WardPanel>();
        setLayout(new GridLayout(1, 8));
        for (int i = 0; i < wards_list.size(); i++) {
            Ward w = wards_list.get(i);
            WardPanel p = new WardPanel();
            p.create_panel(w);
            wardPanels.add(p);
            add(p);
        }
    }
    public void refresh(){
        for (int i = 0; i < wards_list_1.size(); i++) {
            wardPanels.get(i).create_panel(wards_list_1.get(i));
        }
    }
}
