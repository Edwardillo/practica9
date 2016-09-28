import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Edward on 22-Sep-16.
 */
@Stateless
public class productService{
    private ArrayList<Product> productList;
    private FacesContext context;

    public void init(boolean t) {
        productList = new ArrayList<>();
        Product p = new Product("pc","una pc bien vacana",1);
        productList.add(p);
        getContext();
        if(t == false)
            setList();
        if(t == true)
            getList();
    }
    public productService(){}

    private void getContext() {
        context = FacesContext.getCurrentInstance();
    }

    private void getList() {
        productList = (ArrayList<Product>) context.getExternalContext().getSessionMap().get("productos");
    }

    private void setList() {
        context.getExternalContext().getSessionMap().put("productos", getProductList());
    }

    public void addProduct(Product p) {
        getContext();
        getList();
        getProductList().add(p);
        setList();
    }

    public void editProduct(Product p) {
        getContext();
        getList();
        int id = p.getId();
        for (Product pro : getProductList()) {
            if (id == pro.getId()) {
                getProductList().remove(pro);
                break;
            }
        }
        getProductList().add(p);
        setList();

    }

    public void removeProduct(Product p) {
        getContext();
        getList();
        getProductList().remove(p);
        setList();
    }

    public boolean getProduct(Product p) {
        return (getProductList().contains(p) ? true : false);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}