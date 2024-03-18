package towers;

import aircrafts.Aircraft;
import aircrafts.Flyable;
import io.Log;
import io.Messages;

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
        Log.info(String.format("Tower says: %s#%s(%d) %s %s.", aircraft.getType(),
                aircraft.getName(), aircraft.getId(), Messages.REGISTERED, this.NAME));
    }

    public void unregister(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        TO_UNREGISTER.add(p_flyable);
        Log.info(String.format("Tower says: %s#%s(%d) %s %s.", aircraft.getType(),
                aircraft.getName(), aircraft.getId(), io.Messages.UNREGISTERED, this.NAME));
    }

    protected void conditionChanged() {
        OBSERVERS.forEach(Flyable::updateConditions);
        OBSERVERS.removeAll(TO_UNREGISTER);
    }
}
