package com.example.dndsfx;

import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SoundManager
{
    public static Map<String, Integer> sounds = new HashMap<String, Integer>();


    public SoundManager()
    {
        LoadSounds();
    }

    private void LoadSounds()
    {
        sounds.put("Taverna",R.raw.tavern);
        sounds.put("Lluvia",R.raw.rain);
    }
}
