public class AuthorTest
{
    public static void main(String[] args) {

        Author barros = new Author("Geovanna Barros", "geobarros@aluno.ifsp.edu.br", 'F');
        System.out.println(barros.toString());
        System.out.println(barros.getName());
        System.out.println(barros.getEmail());
        System.out.println(barros.getGender());

        barros.setEmail("geobarrosz@aluno.ifsp.edu.br");
        System.out.println(barros.getEmail());

    }
}
