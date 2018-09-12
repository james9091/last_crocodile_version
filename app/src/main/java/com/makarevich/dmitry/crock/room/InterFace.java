package com.makarevich.dmitry.crock.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface InterFace {
    ////////////////////////////////////////////////////////////// Russian
    @Insert
    public void addWord(Words words);

    @Query("select * from rus_easy")
    public List<Words> getEasy_rus();

    @Insert
    public void addMediumRus(Rus_M rus_m);

    @Query("select * from rus_medium")
    public List<Rus_M> getMedium_rus();

    @Insert
    public void addHardRus(Rus_H rus_h);

    @Query("select * from rus_hard")
    public List<Rus_H> getHard_rus();

    @Insert
    public void addRusAnimal(Rus_Animal rus_animal);

    @Query("select * from rus_animal")
    public List<Rus_Animal> getAnimal_rus();

    @Insert
    public void addRusPlanet(Rus_Planet rus_planet);

    @Query("select * from rus_planet")
    public List<Rus_Planet> getPlanet_rus();

    @Insert
    public void addRusProfessions(Rus_Professions rus_professions);

    @Query("select * from rus_professions")
    public List<Rus_Professions> getProfessions_rus();

    @Insert
    public void addRusTransport(Rus_Transport rus_transport);

    @Query("select * from rus_transport")
    public List<Rus_Transport> getTransport_rus();

    ///////////////////////////////////////////////////////////////// English
    @Insert
    public void addEasyEng(Eng_Easy eng_easy);

    @Query("select * from eng_easy")
    public List<Eng_Easy> getEasy_eng();

    @Insert
    public void addMediumEng(Eng_Medium eng_medium);

    @Query("select * from eng_medium")
    public List<Eng_Medium> getMedium_eng();

    @Insert
    public void addHardEng(Eng_Hard eng_hard);

    @Query("select * from eng_hard")
    public List<Eng_Hard> getHard_eng();

    @Insert
    public void addEngAnimal(Eng_Animal eng_animal);

    @Query("select * from eng_animal")
    public List<Eng_Animal> getAnimal_eng();

    @Insert
    public void addEngTransport(Eng_Transport eng_transport);

    @Query("select * from eng_transport")
    public List<Eng_Transport> getTransport_eng();

    @Insert
    public void addEngPlanet(Eng_Planet eng_planet);

    @Query("select * from eng_planet")
    public List<Eng_Planet> getPlanet_eng();

    @Insert
    public void addEngProfessions(Eng_Professions eng_professions);

    @Query("select * from eng_professions")
    public List<Eng_Professions> getProfessions_eng();

    ////////////////////////////////////////////////////////////// Deutch
    @Insert
    public void addDeEasy(De_Easy de_easy);

    @Query("select * from de_easy")
    public List<De_Easy> getDeutch_easy();

    @Insert
    public void addDeMedium(De_Medium de_medium);

    @Query("select * from de_medium")
    public List<De_Medium> getDeutch_medium();

    @Insert
    public void addDeHard(De_Hard de_hard);

    @Query("select * from de_hard")
    public List<De_Hard> getDeutch_hard();

    @Insert
    public void addDeAnimal(De_Animal de_animal);

    @Query("select * from de_animal")
    public List<De_Animal> getDeutch_animal();

    @Insert
    public void addDePlanet(De_Planet de_planet);

    @Query("select * from de_planet")
    public List<De_Planet> getDeutch_planet();

    @Insert
    public void addDeProfessions(De_Professions de_professions);

    @Query("select * from de_professions")
    public List<De_Professions> getDeutch_professions();

    @Insert
    public void addDeTransport(De_Transport de_transport);

    @Query("select * from de_transport")
    public List<De_Transport> getDeutch_transport();

    ////////////////////////////////////////////////////////////// Spain
    @Insert
    public void addEsEasy(Es_Easy es_easy);

    @Query("select * from es_easy")
    public List<Es_Easy> getSpain_easy();

    @Insert
    public void addEsMedium(Es_Medium es_medium);

    @Query("select * from es_medium")
    public List<Es_Medium> getSpain_medium();

    @Insert
    public void addEsHard(Es_Hard es_hard);

    @Query("select * from es_hard")
    public List<Es_Hard> getHard_spain();

    @Insert
    public void addEsAnimal(Es_Animal es_animal);

    @Query("select * from es_animal")
    public List<Es_Animal> getAnimal_spain();

    @Insert
    public void addEsPlanet(Es_Planet es_planet);

    @Query("select * from es_planet")
    public List<Es_Planet> getPlanet_spain();

    @Insert
    public void addEsProfessions(Es_Professions es_professions);

    @Query("select * from es_professions")
    public List<Es_Professions> getProfesions_spain();

    @Insert
    public void addEsTransport(Es_Transport es_transport);

    @Query("select * from es_transport")
    public List<Es_Transport> getTransport_spain();

}
