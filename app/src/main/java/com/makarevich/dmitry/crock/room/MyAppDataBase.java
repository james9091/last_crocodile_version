package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Words.class, Rus_H.class, Rus_M.class, Rus_Animal.class, Rus_Planet.class, Rus_Professions.class, Rus_Transport.class,
        Eng_Easy.class, Eng_Medium.class, Eng_Hard.class, Eng_Animal.class, Eng_Planet.class, Eng_Professions.class, Eng_Transport.class,
        De_Easy.class, De_Medium.class, De_Hard.class, De_Animal.class, De_Planet.class, De_Professions.class, De_Transport.class,
        Es_Easy.class, Es_Medium.class, Es_Hard.class, Es_Animal.class, Es_Planet.class, Es_Professions.class, Es_Transport.class}, version = 1)
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract InterFace myinterface();
}
