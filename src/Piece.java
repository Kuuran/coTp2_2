import java.util.ArrayList;

public class Piece {

    private ArrayList<Item> items;

    public Piece() {
        items = new ArrayList<>();
    }

    public void listeTous() {
        for (Item i : items) {
            i.liste();
        }
    }

    public void placer(Item i) throws ErreurRobot {
        if(items.contains(i)){
            throw new ErreurRobot("Piece::placer : Placement impossible");
        }
        else {
            items.add(i);
        }
    }

    public void enlever(Item i) throws ErreurRobot {
        if (!(items.contains(i))) {
            throw new ErreurRobot("Piece::enlever : Action impossible, l'item n'est pas dans la piece.");
        } else {
            items.remove(i);
        }
    }
}
