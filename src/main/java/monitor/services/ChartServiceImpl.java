package monitor.services;

import monitor.data.ChartRepository;
import monitor.models.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("chartService")
public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartRepository chartRepository;

    @Override
    public Iterable<Chart> findAll() {
        return chartRepository.findAll();
    }
}
