/**
 * Created by Edward on 28-Sep-16.
 */
public class Comment {
    private int user;
    private String comment;
    public Comment(int user, String comment){
        this.setUser(user);
        this.setComment(comment);
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
