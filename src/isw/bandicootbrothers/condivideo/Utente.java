package isw.bandicootbrothers.condivideo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alessio on 22/06/16.
 */
public class Utente
{
    Video videoInteressato = new Video();

    public Utente()
    {};

    //Video visualizzaVideo();

    void ricercaVideo(String pat)
    {
        ArrayList<Video> listavideo = new ArrayList<Video>();

        //Questo for è da sostituire con un costrutto che coinvolge un iterator.
        for(Video v : VideoFactory.getInstance().getVideoList())
        {
            if(v.nome.contains(pat))
            {
                listavideo.add(v);
            }
        }

        if(listavideo.size() > 0)
        {
            System.out.println("Trovati " + listavideo.size() + " video:");

            int a = 0;

            for(Video v : listavideo)
            {
                System.out.println(a + " - Nome video:/t" + v.nome);
                a++;
            }

            System.out.println("/nTi interessa qualcuno di questi video? /n "+
            "Inserisci il numero del video interessato o premi 'x' per tornare indietro");

            Scanner in = new Scanner(System.in);
            a = in.nextInt();

            if(Integer.toString(a) == "x")
            {
                return;
            }
            else
            {
                if(a >= 0 && a <= listavideo.size())
                {
                    videoInteressato = listavideo.get(a);
                    return;
                }
                else
                {
                    System.out.println("Il video indicato non esiste!");
                    return;
                }
            }
        }
        else
        {
            System.out.println("nessun video corrispondente alla ricerca!");
            return;
        }
    }

    //ArrayList<Video> cercaVideo(){};
}
