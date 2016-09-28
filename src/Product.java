import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Created by Edward on 22-Sep-16.
 */


public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private ArrayList<Comment> comments;
    public Product(){

    }

    public Product(String name, String description, int quantity)
    {
        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.comments = new ArrayList<Comment>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void deleteComment(Comment comment){
        comments.remove(comment);
    }
}
