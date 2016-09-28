/**
 * Created by Edward on 20-Sep-16.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Console;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "userForm")
@SessionScoped
public class userForm implements Serializable{

    private List<User> users;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private int id;

    public String post(){

        FacesContext context = FacesContext.getCurrentInstance();
        User user = new User(name,lastname,username,password);

        if (id != -1)
            user.setId(id);

        //anadir contacto a db

        context.getExternalContext().getSessionMap().put("user",user);

        ClearForm();

        return "productosDisponibles?faces-redirect=true";
    }
    public void ClearForm(){
        setId(-1);
        name = "";
        lastname = "";
        username = "";
        password = "";

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
