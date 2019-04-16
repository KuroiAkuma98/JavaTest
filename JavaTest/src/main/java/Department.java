import java.util.ArrayList;
import java.util.List;

public class Department
{
    private String name;
    private DepartmentType departmentType;
    private List<Person> personList;

    Department(String _name, DepartmentType _departmentType,List<Person> _personList)
    {
        this.name = _name;
        this.departmentType = _departmentType;
        this.personList = new ArrayList<Person>();
    }

    public String toString()
    {
        String txt = "Name: " + name + "\n" + "Department type: " + departmentType + "\n";
        return txt;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String getName()
    {
        return name;
    }
    public DepartmentType getDepartmentType() {
        return departmentType;
    }
    public List<Person> getPersonList()
    {
        return personList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Department)) return false;
        Department d = (Department)obj;
        if(d.name == name && d.departmentType == departmentType && d.personList == personList) return true;
        else return false;
    }

    public void addPerson(Person person)
    {
        if((person.getPosition() == Position.TRAINING_MANAGER || person.getPosition() == Position.HR_ANALYST) && this.getDepartmentType() == DepartmentType.HR)
        {
            personList.add(person);
        }
        else if((person.getPosition() == Position.MARKETING_CONSULTANT || person.getPosition() == Position.MARKETING_RESEARCH_SPECIALIST) && this.getDepartmentType() == DepartmentType.MARKETING)
        {
            personList.add(person);
        }
        else if((person.getPosition() == Position.CPP_DEVELOPER || person.getPosition() == Position.JAVA_DEVELOPER) && this.getDepartmentType() == DepartmentType.DEVELOPMENT)
        {
            personList.add(person);
        }
    }

    public void removePerson(Person person)
    {
        personList.remove(person);
    }

    public void shiftPerson(Person person, Department department)
    {
        if(this.personList.contains(person))
        {
            department.addPerson(person);
            removePerson(person);
        }
    }
}
