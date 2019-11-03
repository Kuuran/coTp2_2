public class ObservateurRobot extends ObservateurItem {

    protected ObservateurRobot() {
        super();
    }


    @Override
    public void alerter(Item i) {
        System.out.println("Le Robot " + i.id() + " a ete modifie.");
    }
}
