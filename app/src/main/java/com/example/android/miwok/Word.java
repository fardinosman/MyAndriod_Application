package com.example.android.miwok;

public class Word {

        String mDefaultTranslation;

        String mMiwokTranslation;
        int imageSrc;
        int audioSrc;

       public Word(String defaultTranslation, String miwokTranslation,int audiosrc){
        this.mDefaultTranslation= defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.audioSrc=  audiosrc;


    }

        public Word(String defaultTranslation, String miwokTranslation, int imgSrc,int audiosrc){
            this.mDefaultTranslation= defaultTranslation;
            this.mMiwokTranslation = miwokTranslation;
            this.imageSrc= imgSrc;
            this.audioSrc=  audiosrc;


        }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Android version number
     */
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getimageSrc() {
        return imageSrc;
    }

    public int getmAudioResourceId(){return audioSrc;}
}


