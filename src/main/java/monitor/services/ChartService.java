package monitor.services;

import monitor.models.Chart;

public interface ChartService {

    Iterable<Chart> findAll();
}
