import java.util.ArrayList;
import java.util.List;

public class Tower {
    protected final String NAME = "Tower";
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        System.out.println("flyable registered into Tower");
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
//        System.out.printf("%s#%s(%d) %s\n", , NAME, ID, Messages.UNREGISTERED);
        this.observers.remove(p_flyable);
    }

    public String getName() {
        return NAME;
    }

    protected void conditionChanged() {
        System.out.println("Tower notifying all subscriptions that conditionChanged...");
        observers.forEach(Flyable::updateConditions);
        System.out.println("After");
    }

}
