package towers;

import aircrafts.Aircraft;
import aircrafts.Flyable;
import logger.Messages;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    protected final String NAME;
    private final List<Flyable> OBSERVERS;
    private final List<Flyable> TO_UNREGISTER;

    public Tower(String name) {
        NAME = name;
        OBSERVERS = new ArrayList<>();
        TO_UNREGISTER = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        OBSERVERS.add(p_flyable);
        System.out.printf("Tower says: %s#%s(%d) %s %s.\n", aircraft.getType(),
                aircraft.getName(), aircraft.getId(), Messages.REGISTERED, this.NAME);
    }

    public void unregister(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        TO_UNREGISTER.add(p_flyable);
        System.out.printf("Tower says: %s#%s(%d) %s %s.\n", aircraft.getType(),
                aircraft.getName(), aircraft.getId(), logger.Messages.UNREGISTERED, this.NAME);
    }

    public String getName() {
        return NAME;
    }

    protected void conditionChanged() {
        System.out.println("Tower notifying all subscriptions that conditionChanged...");
        OBSERVERS.forEach(Flyable::updateConditions);
        OBSERVERS.removeAll(TO_UNREGISTER);
    }

}
