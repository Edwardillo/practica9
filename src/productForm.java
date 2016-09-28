import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Edward on 22-Sep-16.
 */

@ManagedBean(name = "productForm")
@SessionScoped
public class productForm {
    private String nombre;
    private String description;
    private int quantity;
    @EJB
    private
    productService productos = new productService();
    @PostConstruct
    private void init(){
        getProductos().init(false);
    }
    public String post(){
        Product product = new Product(getNombre(), getDescription(), getQuantity());
        getProductos().addProduct(product);
        return "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public productService getProductos() {
        return productos;
    }

    public void setProductos(productService productos) {
        this.productos = productos;
    }
}
