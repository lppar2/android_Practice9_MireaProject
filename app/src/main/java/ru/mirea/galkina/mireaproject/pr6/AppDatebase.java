package ru.mirea.galkina.mireaproject.pr6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.galkina.mireaproject.pr8.Kittens;
import ru.mirea.galkina.mireaproject.pr8.KittensDao;

@Database(entities = {Story.class, Kittens.class}, version = 3)
public abstract class AppDatebase extends RoomDatabase{
    public abstract StoryDao storyDao();
    public abstract KittensDao kittensDao();
}