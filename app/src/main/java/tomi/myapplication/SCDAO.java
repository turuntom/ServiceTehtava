package tomi.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SCDAO {

    @Query("Select * from ScreeActivity") List<ScreeActivity> lista();

    @Insert
    void InsertScreeAction(ScreeActivity screeActivity);

}
