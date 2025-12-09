public class Seacole extends Ward{
    public  Seacole(){
        this.ward_name="Seacole";
        this.ultrasound = false;
        this.dialysis = false;
        this.ecg = true;
        this.masseur = true;
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
