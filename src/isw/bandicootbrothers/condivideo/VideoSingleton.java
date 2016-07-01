package isw.bandicootbrothers.condivideo;


import java.util.ArrayList;

public class VideoSingleton {
    /*
    | La clase VideoSongleton funge da DATABASE DEI VIDEO.
    | Esso è rappresentato da una singleton accessibile da qualsiasi punto del programma.
    | Tale singleton è un arrayList di Video.
    |
    | Il database è stato popolato a mano da un costrutto Factory.
    */

    //Rendo la classe una singleton
    private static VideoSingleton singleton;

    //Arraylist che conterrà i video.
    private ArrayList<Video> videoList = new ArrayList<Video>();

    //Istanzio il metodo getInstance della singleton
    public static VideoSingleton getInstance() {
        if (singleton == null) {
            singleton = new VideoSingleton();
        }
        return singleton;
    }

    //La factory popola l'array-database
    private VideoSingleton() {

    }

    public ArrayList<Video> getVideoList() {
        return videoList;
    }
}
