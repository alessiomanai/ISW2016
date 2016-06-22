package isw.bandicootbrothers.condivideo;

import java.util.Scanner;

public class Video
{
    public String nome; //nome del video
    public String autore;
    public int durata; //in secondi

    private boolean vietato = false;

    public Video(String nome, String autore, int durata)
    {
        this.nome = nome;
        this.autore = autore;
        this.durata = durata;
    }

    public Video() {}

    public void play()
    {
        System.out.println("Stai guardando " + this.nome +
                " pubblicato da " + this.autore +
                "/n/nQuesto video ha una durata di " + this.durata);
    }

    public void condividi()
    {
        int scelta;

        System.out.println("Scegli un operazione:" +
                "/n1 - Condividi su Facebook" +
                "/n2 - Condividi su Twitter" +
                "/n3 - Condividi su Instagram" +
                "/n4 - Condividi su Pinterest" +
                "/n5 - Condividi via email" +
                "/n6 - Ottieni link");

        Scanner in = new Scanner(System.in);
        scelta = in.nextInt();

        switch (scelta)
        {
            case (1): { System.out.println("Video condiviso sul tuo profilo Facebook"); break; }
            case (2): { System.out.println("Video condiviso sul tuo profilo Twitter"); break; }
            case (3): { System.out.println("Video condiviso sul tuo profilo Instagram"); break; }
            case (4): { System.out.println("Video condiviso sul tuo profilo Pinterest"); break; }
            case (5): { System.out.println("Creata una mail di bozza con il link del video"); break; }
            case (6): { System.out.println("Link copiato negli appunti"); }
        }
    }
}
