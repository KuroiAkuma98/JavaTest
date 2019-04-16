import java.util.ArrayList;
import java.util.List;

public class Localisation
{
    private String name;
    private String city;
    private List<Department> departmentList;

    Localisation(String _name, String _city,List<Department> _departmentList)
    {
        this.name = _name;
        this.city = _city;
        this.departmentList = new ArrayList<Department>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getCity() {
        return city;
    }
    public String getName() {
        return name;
    }
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    @Override
    public String toString() {
        String txt = "Name: " + name + "\n" + "City: " + city + "\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Localisation)) return false;
        Localisation l = (Localisation) obj;
        if(l.name == name && l.city == city && l.departmentList == departmentList) return true;
        else return false;
    }

    public void addDepartment(Department department) throws IllegalArgumentException
    {
        for(Department d: departmentList)
        {
            if ((d.getDepartmentType() == department.getDepartmentType()))
            {
                throw new IllegalArgumentException("Already exists!");
            }
            else
            {
                departmentList.add(department);
            }
        }
    }

    public void removeDepartment(Department department)
    {
        departmentList.remove(department);
    }

    public  void shiftDepartment(Department department, Localisation localisation)
    {
        if(this.departmentList.contains(department))
        {
            localisation.addDepartment(department);
            removeDepartment(department);
        }
    }
}
