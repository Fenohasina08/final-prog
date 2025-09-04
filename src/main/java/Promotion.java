
import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private int id;
    private List<String> groups = new ArrayList<>();

    public Promotion() {
    }

    public Promotion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}
