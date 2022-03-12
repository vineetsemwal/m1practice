package exp;

public class StringEx {


    public static void main(String[] args){
        StringEx demo=new StringEx();
        String input="Arpit.MehtaID123456DTIT80L";
        Employee employee= demo.convert(input);
        System.out.println("firstname="+employee.getFirstName()+" lastname="+employee.getLastName());
        System.out.println("dept="+employee.getDepartment() +" id="+employee.getId() );
        System.out.println("salary="+employee.getSalary());
    }


    public Employee convert(String input){
        Employee employee=new Employee();
        int startIDIndex=input.indexOf("ID");
        String name=input.substring(0,startIDIndex);
        int dotIndex= name.indexOf(".");
        String firstName=name.substring(0,dotIndex);
        String lastName=name.substring(dotIndex+1,startIDIndex);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        int deptLiteralIndex=input.indexOf("DT");
        String idText=input.substring(startIDIndex+2,deptLiteralIndex);
        int id=Integer.parseInt(idText);
        employee.setId(id);
        int deptValueEndIndex=deptLiteralIndex+4;
        String deptName=input.substring(deptLiteralIndex+2,deptValueEndIndex);
        employee.setDepartment(deptName);
        String salaryText=input.substring(deptValueEndIndex,input.length()-1);
        double salaryValue=Double.parseDouble(salaryText);
        salaryValue=salaryValue*100000;
        employee.setSalary(salaryValue);
        return employee;



    }

}
