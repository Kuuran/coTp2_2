import java.util.HashSet;

public abstract class Item {

    private boolean hasChanged;

    private double masse;
    private int id;
    private Position p;
    private int niveau;

    private static int lastId = 0;

    private HashSet<ObservateurItem> sesObservateurs;

    protected Item(double masse, Position p) {
        this.masse = masse;
        this.p = p;
        id = ++lastId;
        niveau = 0;
        sesObservateurs = new HashSet<>();
        hasChanged = false;
    }

    public void liste() {
        System.out.println(this.toString());
    }

    public int niveau() { return niveau; }

    public void upNiveau(){
        niveau+=1;
        setChanged();
        notifyObservers();//marche pour ObservateurNiveau si c'est un chargement (niveau 0 -> 1) et pour ObservateurRobot si l'Item est un Robot dynamiquement
    }

    public void downNiveau(){
        niveau-=1;
        setChanged();
        notifyObservers();//marche pour ObservateurNiveau si c'est un dechargement (niveau 1 -> 0) et pour ObservateurRobot si l'Item est un Robot dynamiquement
    }

    protected void deplace(double dx, double dy) throws ErreurRobot{
        p.move(dx, dy);
        setChanged();
        notifyObservers();//marche pour tous les deplacements car Item::deplace est appele par toutes les fonctions de deplacement
    }

    public double masse() { return masse; }

    protected void setMasse(double m){
        masse = m;
    }

    public double masseTotale() {
        return this.masse();
    }

    public int id() { return id; }

    /* retourne une copie de la position, pour qu'on ne puisse pas modifier la
     * position d'un objet par effet de bord sur la valeur retournee.
     */
    public Position position() {
	return new Position(p.x(), p.y());
    }


    public void addObserver(ObservateurItem obs){
        sesObservateurs.add(obs);
    }
    public void deleteObserver(ObservateurItem obs){
        sesObservateurs.remove(obs);
    }

    public boolean hasChanged(){
        return hasChanged;
    }
    public void setChanged(){
        hasChanged = true;
    }
    public void clearChanged(){
        hasChanged = false;
    }

    public void notifyObservers(){
        if(hasChanged()) {
            for(ObservateurItem obs: sesObservateurs){
                obs.alerter(this);
            }
        }
        clearChanged();
    }
}
