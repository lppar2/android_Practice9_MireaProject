package ru.mirea.galkina.mireaproject.pr8;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.galkina.mireaproject.pr6.App;
import ru.mirea.galkina.mireaproject.pr6.AppDatebase;

public class KittensViewModel extends ViewModel {
    private final LiveData<List<Kittens>> kittens;
    private final AppDatebase appDatabase = App.instance.getDatabase();
    private final KittensDao kittensDao = appDatabase.kittensDao();

    public KittensViewModel(){
        kittens = kittensDao.getAllKittens();
    }

    public void addKitten(Kittens kitten){
        kittensDao.insert(kitten);
    }

    public LiveData<List<Kittens>> getKittensLiveData(){
        return kittens;
    }
    public List<Kittens> getKittens(){
        return kittens.getValue();
    }
}
