/**
 * Created by Luca on 30/06/2016.
 */
public class VideoPlayer
{
    public VideoPlayer() {}

    public void play(Video v)
    {
        System.out.println("\n>>>>>>>> Inizio Riproduzione Video <<<<<<<\n");

        System.out.println("Stai guardando " + v.nome +
                " pubblicato da " + v.autore +
                "\nQuesto video ha una durata di " + v.durata + " secondi");

        if(v.vietato == true)
        {
            System.out.println("Questo video ha dei contenuti espliciti:" +
                    "\nNon è riproducibile da utenti minorenni e utenti non registrati");
        }
        else
        {
            System.out.println("Questo video NON ha dei contenuti espliciti:" +
                    "\nE' riproducibile da qualsiasi utente");
        }

        System.out.println("\n>>>>>>>>> Fine Riproduzione Video <<<<<<<<");
    }
}
