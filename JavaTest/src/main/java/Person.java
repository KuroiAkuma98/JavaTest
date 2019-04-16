import java.util.Date;

public class Person
{
    private String name;
    private String surname;
    private Date birthDate;
    private String pesel;
    private Position position;
    PeselValidator peselValidator;

    Person(String _name, String _surname, Date _birthDate, String _pesel, Position _position) throws IllegalArgumentException
    {
        if(PeselSingletonList.getInstance().getPeselList().contains(pesel))
        {
            throw new IllegalArgumentException("Pesel already exists in pesel list");
        }
        else
        {
            if(!(_name.equals("")) && !(_surname.equals("")) )
            {
                this.name = _name;
                this.surname = _surname;
            }
            else
            {
                throw new IllegalArgumentException("name or surname is blank");
            }
            if(birthDate.getYear() > 18)
            {
                this.birthDate = _birthDate;
            }
            else
            {
                throw new IllegalArgumentException("person is not an adult");
            }
            peselValidator = new PeselValidator(pesel);
            if(peselValidator.isValid())
            {
                this.pesel = _pesel;
            }
            else
            {
                throw new IllegalArgumentException("pesel is not valid");
            }
        }


        this.position = _position;

    }

    public void setName(String _name)
    {
        this.name = _name;
    }
    public void setSurname(String _surname)
    {
        this.surname = _surname;
    }
    public void setBirthDate(Date _date)
    {
        this.birthDate = _date;
    }
    public void setPesel(String _pesel)
    {
        this.pesel = _pesel;
    }
    public void setPosition(Position _position)
    {
        this.position = _position;
    }

    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public Date getBirthDate()
    {
        return birthDate;
    }
    public String getPesel()
    {
        return pesel;
    }
    public Position getPosition()
    {
        return position;
    }

    public String toString()
    {
        String txt = "Name: " + name + "\n" + "Surname: " + surname + "\n" + "Birt date: " + birthDate + "\n" + "Pesel: " + pesel + "\n" + "Position: " + position + "\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this ) return true;
        if(!(obj instanceof Person)) return false;
        Person p = (Person)obj;
        if(p.name == name && p.surname == surname && p.birthDate == birthDate && p.pesel == pesel && p.position == position) return true;
        else return false;
    }

    public void setPeselValidator(PeselValidator peselValidator) {
        this.peselValidator = peselValidator;
    }

    public PeselValidator getPeselValidator() {
        return peselValidator;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
