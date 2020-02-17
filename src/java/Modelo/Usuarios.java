package Modelo;


public class Usuarios {
    
    private int id_u;
    private String nick;
    private String pass;
    private Integer tipo_u;

    public Usuarios() {
    }

    public Usuarios(int id_u, String nick, String pass, Integer tipo_u) {
        this.id_u = id_u;
        this.nick = nick;
        this.pass = pass;
        this.tipo_u = tipo_u;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(Integer tipo_u) {
        this.tipo_u = tipo_u;
    }
  
}
