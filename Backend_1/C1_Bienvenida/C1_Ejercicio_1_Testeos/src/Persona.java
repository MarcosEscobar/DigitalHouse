public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    public Persona(String name, String surname, String email, int edad) {
        this.nombre = name;
        this.apellido = surname;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public boolean esMayor(){
        return this.edad >18;
    }
}
