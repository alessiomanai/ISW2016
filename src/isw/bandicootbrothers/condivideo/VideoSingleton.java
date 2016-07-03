package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;

/*
| SINGLETON che rappresenta il DB Video
| Consiste in un ArrayList di Video
*/
public class VideoSingleton {

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

    private VideoSingleton() { }

    public ArrayList<Video> getVideoList() {
        return videoList;
    }
}
