package com.examplecode.rain.navigationdrawerexample;

/**
 * Created by Rain Suasorn on 10/9/2017.
 */

public class MenuItem {

    private String thai;
    private String enlgish;
    private int image;
    private int audio;
    private String pronunciation;

    public MenuItem(String thai, String enlgish, int image, int audio, String pronunciation) {
        this.thai = thai;
        this.enlgish = enlgish;
        this.image = image;
        this.audio = audio;
        this.pronunciation = pronunciation;
    }

    public String getThai() {
        return thai;
    }

    public String getEnlgish() {
        return enlgish;
    }

    public int getImage() {
        return image;
    }

    public int getAudio() {
        return audio;
    }

    public String getPronunciation(){
        return pronunciation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;

        MenuItem menuItem = (MenuItem) o;

        return enlgish.equals(menuItem.enlgish);

    }

    @Override
    public int hashCode() {
        return enlgish.hashCode();
    }
}
