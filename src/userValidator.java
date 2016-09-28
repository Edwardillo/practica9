/**
 * Created by Edward on 22-Sep-16.
 */
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class userValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException{
        String username = value.toString();
        if(username.equals("admin"))
        {
            FacesMessage msg =
                    new FacesMessage("Nombre de Usuario no disponible");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
