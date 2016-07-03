package isw.bandicootbrothers.condivideo;


import java.util.ArrayList;
import java.util.Scanner;

public class VideoSearcher
{
    public VideoSearcher() {}

    public ArrayList<Video> ricercaVideo()
    {
        System.out.println("Pattern: ");

        Scanner in = new Scanner(System.in);
        String pat = in.next();

        ArrayList<Video> listavideo = new ArrayList<Video>();

        //Questo for è da sostituire con un costrutto che coinvolge un iterator.
        for (Video v : VideoSingleton.getInstance().getVideoList())
        {
            if (v.nome.contains(pat)) {
                listavideo.add(v);
            }
        }

        return listavideo;
    }


    //Per i test: consiste nella funzione precedente, ma con parametri già dati. (Senza Scanner)
    public int ricercaVideoT(String pat)
    {
        ArrayList<Video> listavideo = new ArrayList<Video>();

        //Questo for è da sostituire con un costrutto che coinvolge un iterator.
        for(Video v : VideoSingleton.getInstance().getVideoList())
        {
            if(v.nome.contains(pat))
            {
                listavideo.add(v);
            }
        }

        if(listavideo.size() > 0)
        {
            System.out.println("\nTrovati " + listavideo.size() + " video:");

            int a = 0;

            for(Video v : listavideo)
            {
                System.out.println("Video numero " + a + " - Nome:\t" + v.nome);
                a++;
            }
        }
        else
        {
            System.out.println("Nessun video corrispondente alla ricerca!");
        }

        return listavideo.size();
    }


    public Video sceltaVideo(ArrayList<Video> listavideo)
    {
        Scanner in = new Scanner(System.in);
        int scelta = in.nextInt();

        if(scelta == -1)
        {
            return null;
        }
        else
        {
            if(scelta >= 0 && scelta < listavideo.size())
            {
                return listavideo.get(scelta);
            }
        }

        return null;
    }



}
