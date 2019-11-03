import java.util.HashMap;

public class ObservateurFuite extends ObservateurItem {

    public ObservateurFuite() {
        super();
    }

    @Override
    public void add(Item i) {
        sesItems.put(i, i.masse());
        i.addObserver(this);
    }


   @Override
    public void alerter(Item i) {
        if(!(i.masse() == (double) sesItems.get(i))){
            System.out.println("\nLa masse du Sac " + i.id() + " est passee de " + (double)sesItems.get(i) + " a " + i.masse() + ".");
            sesItems.replace(i, i.masse());
        }
    }
}
