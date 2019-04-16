

import java.util.ArrayList;
import java.util.List;

public class Company
{
    private Person CEO;
    private Person CTO;
    private Person CFO;
    private List<Localisation> localisationList;

    public void setCEO(Person CEO) {
        this.CEO = CEO;
    }
    public void setCTO(Person CTO) {
        this.CTO = CTO;
    }
    public void setCFO(Person CFO) {
        this.CFO = CFO;
    }
    public void setLocalisationList(List<Localisation> localisationList) {
        this.localisationList = new ArrayList<Localisation>();
    }

    public Person getCEO() {
        return CEO;
    }
    public Person getCFO() {
        return CFO;
    }
    public Person getCTO() {
        return CTO;
    }
    public List<Localisation> getLocalisationList() {
        return localisationList;
    }

    @Override
    public String toString() {
        String txt = "CEO: " + CEO + "\n" + "CTO: " + CTO + "\n" + "CFO: " + CFO + "\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Company)) return false;
        Company c = (Company) obj;
        if(c.CEO == CEO && c.CFO == CFO && c.CTO == CTO && c.localisationList == localisationList) return true;
        else return false;
    }

    public void addLocalisation(Localisation l)
    {
        localisationList.add(l);
    }
}
