public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        gender = Character.toLowerCase(gender);
        if(gender != 'f' && gender != 'm') {
            throw new RuntimeException("O Genero deve ser 'F' ou 'M'");
        }
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%c]", name, email, gender);
    }
}
