public class ObservateurDeplacement extends ObservateurItem {

    public ObservateurDeplacement() {
    }

    @Override
    public void add(Item i) {
        sesItems.put(i, new Position(i.position().x(), i.position().y()));
        i.addObserver(this);
    }


   @Override
   public void alerter(Item i) {
        if(!(i.position().equals(sesItems.get(i)))){
            System.out.println("L'item " + i.id() + " a change de position : " + sesItems.get(i).toString() + " -> " + i.position().toString() + ".");
            sesItems.replace(i, new Position(i.position().x(), i.position().y()));
        }
    }
}
