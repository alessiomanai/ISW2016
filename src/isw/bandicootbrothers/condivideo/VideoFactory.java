package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;

public class VideoFactory
{
    private static VideoFactory singleton;

    public static VideoFactory getInstance()
    {
        if (singleton == null) {
            singleton = new VideoFactory();
        }
        return singleton;
    }

    private ArrayList<Video> videoList = new ArrayList<Video>();

    private VideoFactory()
    {
        videoList.add(new Video("Acqua corrente",   "Alessio",  87));
        videoList.add(new Video("Ma anche no",      "Emanuel",  121));
        videoList.add(new Video("Mobbasta",         "Corrado",  56));
        videoList.add(new Video("Babbi l'orsetto",  "Andrea",   211));
        videoList.add(new Video("La villa di Lato", "Luca",     54));
        videoList.add(new Video("Il buio",          "Alessio",  9));
        videoList.add(new Video("Rocchio 47",       "Emanuel",  45));
        videoList.add(new Video("Italiano Medio",   "Corrado",  21));
        videoList.add(new Video("Ahia",             "Andrea",   197));
        videoList.add(new Video("urgenze",          "Luca",     55));
        videoList.add(new Video("Djanni",           "Alessio",  79));
        videoList.add(new Video("Leghifascisti",    "Emanuel",  33));
        videoList.add(new Video("Salveenee",        "Corrado",  34));
        videoList.add(new Video("Renzie",           "Andrea",   16));
        videoList.add(new Video("Brava Giovanna",   "Andrea",   122));
    }
}
