import java.util.Objects;

public abstract class Ward {
    protected String ward_name;
    protected Boolean ultrasound;
    protected Boolean ecg;
    protected Boolean dialysis;
    protected Boolean masseur;
    protected Boolean ultrasound_act;
    protected Boolean ecg_act;
    protected Boolean masseur_act;
    protected Boolean dialysis_act;
    protected int ultrasound_start_time;
    protected int ecg_start_time;
    protected int dialysis_start_time;
    protected int masseur_start_time;

    public Boolean getDialysis() {
        return dialysis;
    }
    public Boolean getMasseur() {
        return masseur;
    }
    public Boolean getUltrasound() {
        return ultrasound;
    }
    public String getWard_name() {
        return ward_name;
    }
    public Boolean getEcg() {
        return ecg;
    }
    public Boolean getUltrasound_act() {
        return ultrasound_act;
    }
    public Boolean getEcg_act() {
        return ecg_act;
    }
    public Boolean getMasseur_act() {
        return masseur_act;
    }
    public Boolean getDialysis_act() {
        return dialysis_act;
    }
    public int getUltrasound_start_time() {
        return ultrasound_start_time;
    }
    public int getEcg_start_time() {
        return ecg_start_time;
    }
    public int getDialysis_start_time() {
        return  dialysis_start_time;
    }
    public int getMasseur_start_time() {
        return masseur_start_time;
    }

    public void inactive_bay(String service, String ward, int time){

        //this.getWard_name().equals(ward)
        if (this.getWard_name().equals(ward)){
            if (Objects.equals(service, "Ultrasound")){
                this.ultrasound = false;
                this.ultrasound_act = false;
            } else if (Objects.equals(service, "Dialysis")){
                this.dialysis = false;
                this.dialysis_act = false;
            } else if (Objects.equals(service, "Massage")){
                this.masseur = false;
                this.masseur_act = false;
            } else if (Objects.equals(service, "ECG")){
                this.ecg = false;
                this.ecg_act = false;
            }
        }
    }

    public void update_bay(String service, String ward, int time){

        //this.getWard_name().equals(ward)
        if (this.getWard_name().equals(ward)){
            if (Objects.equals(service, "Ultrasound")){
                this.ultrasound = true;
                this.ultrasound_act = true;
                this.ultrasound_start_time = time;
            } else if (Objects.equals(service, "Dialysis")){
                this.dialysis = true;
                this.dialysis_act = true;
                this.dialysis_start_time = time;
            } else if (Objects.equals(service, "Massage")){
                this.masseur = true;
                this.masseur_act = true;
                this.masseur_start_time = time;
            } else if (Objects.equals(service, "ECG")){
                this.ecg = true;
                this.ecg_act = true;
                this.ecg_start_time = time;
            }
        }
    }
    public void move_bay(String service, String ward, int time){
        inactive_bay(service, ward, time);
        update_bay(service, ward, time);
    }
    public void close_equip(int time){
        if (time - this.ultrasound_start_time >= 3){
            this.ultrasound_act = false;
        } else if (time - this.dialysis_start_time >= 4){
            this.dialysis_act = false;
        } else if (time - this.masseur_start_time >= 2){
            this.masseur_act = false;
        } else if (time - this.ecg_start_time >= 1){
            this.ecg_act = false;
        }
    }
    public Boolean check_not_in_use(String service, String ward){
        if (this.ecg_act == false){
            return true;
        } else if (this.dialysis_act == false){
            return true;
        } else if (this.masseur_act == false){
            return true;
        } else if (this.ultrasound_act == false){
            return true;
        } else {return  false;}
    }
}
