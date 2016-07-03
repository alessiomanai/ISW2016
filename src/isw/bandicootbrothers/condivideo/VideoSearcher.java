package isw.bandicootbrothers.condivideo;


import java.util.ArrayList;
import java.util.Scanner;

public class VideoSearcher
{
    public VideoSearcher() {}

    //Data una lista di video in stampa, serve per far scegliere all'utente a quale video è interessato
    public Video sceltaVideo(ArrayList<Video> listavideo)
    {
        //L'utente inserisce il numero relativo al video nella lista stampata a video
        Scanner in = new Scanner(System.in);
        int scelta = in.nextInt();

        //Controllo sull'input
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

    //Serve a cercare video nel DB tramite una ricerca per matching di stringhe
    public ArrayList<Video> ricercaVideo()
    {
        //Inserisco un pattern per la ricerca
        System.out.println("Pattern: ");

        Scanner in = new Scanner(System.in);
        String pat = in.next();

        ArrayList<Video> listavideo = new ArrayList<Video>();

        //Ricerco nel DB i nomi dei video che "contengono" il pattern inserito
        for (Video v : VideoSingleton.getInstance().getVideoList())
        {
            //E li aggiungo alla lista
            if (v.nome.contains(pat)) {
                listavideo.add(v);
            }
        }
        //che infine restituisco
        return listavideo;
    }


    /*
    | TEST
    | consiste nella funzione precedente, ma con parametri già dati. (Senza Scanner)
    | inoltre, è stato imposto un valore di ritorno (la lunghezza della lista dei video trovati) a fine di testing
    */
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

        return listavideo.size();
    }



}
