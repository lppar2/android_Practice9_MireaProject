package ru.mirea.galkina.mireaproject.pr8;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Kittens {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String breed;
    public String color;
    public String age;
}
