package tomi.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class ScreeActivity implements Serializable {


    @PrimaryKey(autoGenerate = true)
    public int Id;

    public String aika;

    public ScreeActivity(String aika) {
        this.aika = aika;
    }
}
