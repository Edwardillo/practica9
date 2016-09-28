import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

/**
 * Created by Edward on 22-Sep-16.
 */
@ManagedBean(name = "loginForm")
@SessionScoped
public class loginForm implements Serializable{
    private String username;
    private String password;

    public String post() throws ValidatorException{
        FacesContext context = FacesContext.getCurrentInstance();
        User u;
        if(context.getExternalContext().getSessionMap().get("user") != null){
            u = (User)context.getExternalContext().getSessionMap().get("user");
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                return "productosDisponibles?faces-redirect=true";
        }

        if(username.equals("admin")) {
            u = new User("admin","admin","admin","admin");
            context.getExternalContext().getSessionMap().put("admin",u);
            return "productosDisponibles?faces-redirect=true";
        }
        return "";
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
}
