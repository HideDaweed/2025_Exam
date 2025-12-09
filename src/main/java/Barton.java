public class Barton extends Ward{
    public  Barton(){
        this.ward_name="Barton";
        this.ultrasound = false;
        this.dialysis = false;
        this.ecg = false;
        this.masseur = false;
        this.ultrasound_act=false;
        this.dialysis_act=false;
        this.masseur_act=false;
        this.ecg_act=false;

        this.ultrasound_start_time = 0;
        this.ecg_start_time = 0;
        this.dialysis_start_time = 0;
        this.masseur_start_time=0;
    }
}
