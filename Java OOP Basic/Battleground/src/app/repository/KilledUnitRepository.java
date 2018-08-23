package app.repository;

import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KilledUnitRepository implements InactiveRepository<Unit> {
    private List<Unit> killedUnits;

    public KilledUnitRepository() {
        this.killedUnits = new ArrayList();
    }


    @Override
    public void save(Unit element) {
        this.killedUnits.add(element);
    }

    @Override
    public List<Unit> getAll() {
        return Collections.unmodifiableList(this.killedUnits);
    }
}
