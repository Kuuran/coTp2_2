import java.util.HashMap;

public abstract class ObservateurItem {

    protected HashMap<Item, Object> sesItems;

    protected ObservateurItem() {
        sesItems = new HashMap<>();
    }

    public void add(Item i) {
        sesItems.put(i, null);
        i.addObserver(this);
    }

    public void remove(Item i) {
        sesItems.remove(i);
        i.deleteObserver(this);
    }

    public abstract void alerter(Item i);

}
