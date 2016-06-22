package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;

public class VideoFactory
{
    private static VideoFactory singleton;

    private ArrayList<Video> videoList = new ArrayList<Video>();

    public static VideoFactory getInstance()
    {
        if (singleton == null) {
            singleton = new VideoFactory();
        }
        return singleton;
    }

    private VideoFactory()
    {
        getVideoList().add(new Video("Acqua corrente",   "Alessio",  87));
        getVideoList().add(new Video("Ma anche no",      "Emanuel",  121));
        getVideoList().add(new Video("Mobbasta",         "Corrado",  56));
        getVideoList().add(new Video("Babbi l'orsetto",  "Andrea",   211));
        getVideoList().add(new Video("La villa di Lato", "Luca",     54));
        getVideoList().add(new Video("Il buio",          "Alessio",  9));
        getVideoList().add(new Video("Rocchio 47",       "Emanuel",  45));
        getVideoList().add(new Video("Italiano Medio",   "Corrado",  21));
        getVideoList().add(new Video("Ahia",             "Andrea",   197));
        getVideoList().add(new Video("urgenze",          "Luca",     55));
        getVideoList().add(new Video("Djanni",           "Alessio",  79));
        getVideoList().add(new Video("Leghifascisti",    "Emanuel",  33));
        getVideoList().add(new Video("Salveenee",        "Corrado",  34));
        getVideoList().add(new Video("Renzie",           "Andrea",   16));
        getVideoList().add(new Video("Brava Giovanna",   "Andrea",   122));
    }


    public ArrayList<Video> getVideoList()
    {
        return videoList;
    }

}
