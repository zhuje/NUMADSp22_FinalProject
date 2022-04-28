package edu.neu.madcourse.numadsp22_finalproject;

// This class will hold all the properties of a verb
public class Verb {
    // this is the word itself in Kanji
    private String verbKanji;
    // this is the word in hiragana
    private String verbKana;
    // this is the word in romanji
    private String verbRoman;
    // this is translation of word
    private String verbTranslation;
    // this is the character picture int
    private int characterPicture;
    // this is the url for the audio
    private String audioURL;

    // Constructor for verbs
    public Verb(String verbKanji, String verbKana, String verbRoman, String verbTranslation,
                int characterPicture, String audioURL) {
        this.verbKanji = verbKanji;
        this.verbKana = verbKana;
        this.verbRoman = verbRoman;
        this.verbTranslation = verbTranslation;
        this.characterPicture = characterPicture;
        this.audioURL = audioURL;
    }

    // getter and setters
    public String getVerbKanji() {
        return verbKanji;
    }

    public String getVerbKana() {
        return verbKana;
    }

    public String getVerbRoman() {
        return verbRoman;
    }

    public String getVerbTranslation() {
        return verbTranslation;
    }

    public int getCharacterPicture() {
        return characterPicture;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setVerbKanji(String verbKanji) {
        this.verbKanji = verbKanji;
    }

    public void setVerbKana(String verbKana) {
        this.verbKana = verbKana;
    }

    public void setVerbRoman(String verbRoman) {
        this.verbRoman = verbRoman;
    }

    public void setVerbTranslation(String verbTranslation) {
        this.verbTranslation = verbTranslation;
    }

    public void setCharacterPicture(int characterPicture) {
        this.characterPicture = characterPicture;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }
}
