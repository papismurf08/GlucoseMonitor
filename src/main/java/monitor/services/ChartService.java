package monitor.services;

import monitor.models.Chart;
import monitor.models.CreateRecord;

public interface ChartService {

    //Iterable<CreateRecord> findAll();
    Iterable<Chart> findAll();
}
