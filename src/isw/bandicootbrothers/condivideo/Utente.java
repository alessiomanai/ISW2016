package isw.bandicootbrothers.condivideo;

public class Utente {

    String nome;
    String password;
    int age;

    Video videoInteressato;

    public Utente() {}

    public Utente(String nome, String password, int age)
    {
        this.nome = nome;
        this.password = password;
        this.age = age;
    }

}
