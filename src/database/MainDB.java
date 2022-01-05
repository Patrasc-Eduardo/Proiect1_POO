package database;

import entities.Child;
import entities.Santa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MainDB {
    private Santa santa = new Santa();
    private ArrayList<Child> childrenList = new ArrayList<>();

    private static MainDB instance = null;

    private MainDB(){

    }

    public static MainDB getInstance() {
        if (instance == null){
            instance = new MainDB();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "MainDB{" +
                "santa=" + santa +
                ", childrenList=" + childrenList +
                '}';
    }
}
