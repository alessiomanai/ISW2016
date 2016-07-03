package isw.bandicootbrothers.condivideo;

public class VideoPlayer
{
    public VideoPlayer() {}

    public boolean play(Video v)
    {
        if(v.vietato)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
