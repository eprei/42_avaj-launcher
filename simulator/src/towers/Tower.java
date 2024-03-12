package towers;

import aircrafts.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        System.out.println("flyable registered into Tower");
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        System.out.println("flyable unregister from Tower");
        this.observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        System.out.println("Tower notifying all subscriptors that conditionChanged...");
        observers.forEach(Flyable::updateConditions);
    }

}
