public class StaffStudentTest {
    public static void main(String[] args) {

        Staff staff = new Staff("Carlos", "Rua A", "Escola X", 3500.0);

        System.out.println("==== Staff ====");
        System.out.println("Nome: " + staff.getName());
        System.out.println("Endereço: " + staff.getAddress());
        System.out.println("Escola: " + staff.getSchool());
        System.out.println("Salário: " + staff.getPay());

        staff.setAddress("Rua B");
        staff.setSchool("Escola Y");
        staff.setPay(4000.0);

        System.out.println("-- Após alterações --");
        System.out.println(staff.toString());


        Student student = new Student("João", "Rua C", "Computação", 2, 1500.50);

        System.out.println("\n==== Student ====");
        System.out.println("Nome: " + student.getName());
        System.out.println("Endereço: " + student.getAddress());
        System.out.println("Curso: " + student.getProgram());
        System.out.println("Ano: " + student.getYear());
        System.out.println("Mensalidade: " + student.getFee());

        student.setAddress("Rua D");
        student.setProgram("Engenharia");
        student.setYear(3);
        student.setFee(2000.75);

        System.out.println("-- Após alterações --");
        System.out.println(student.toString());
    }
}
