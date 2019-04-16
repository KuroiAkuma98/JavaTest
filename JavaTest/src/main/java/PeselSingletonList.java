import java.util.ArrayList;

public class PeselSingletonList
{
    private ArrayList<String> peselList;
    private static  PeselSingletonList instance = new PeselSingletonList();

    public static PeselSingletonList getInstance()
    {
        return instance;
    }

    private PeselSingletonList()
    {
        peselList = new ArrayList<String>();
    }

    public ArrayList<String> getPeselList() {
        return peselList;
    }
}
