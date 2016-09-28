/**
 * Created by Edward on 22-Sep-16.
 */
import javax.annotation.PostConstruct;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by vacax on 06/09/16.
 */

@SessionScoped
public class FormCambioIdioma implements Serializable {

    String idiomaSeleccion = "en";

    private Map<String, Object> idiomasMap;

    @PostConstruct
    private void inicializar(){
        idiomasMap = new LinkedHashMap<>();
        idiomasMap.put("Español", "es"); //label, value
        idiomasMap.put("Ingles", "en");

    }

    public Map<String, Object> getListaIdiomas() {
        return idiomasMap;
    }

    /**
     *
     * @param event
     */
    public void cambiarIdioma(ValueChangeEvent event) {
        System.out.println("Idioma seleccionado: " + idiomaSeleccion);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSeleccion));
    }

    public String getIdiomaSeleccion() {
        return idiomaSeleccion;
    }

    public void setIdiomaSeleccion(String idiomaSeleccion) {
        this.idiomaSeleccion = idiomaSeleccion;
    }

}