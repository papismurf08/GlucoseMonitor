package monitor.services;

import monitor.data.ChartRepository;
import monitor.data.CreateRecordRepository;
import monitor.models.Chart;
import monitor.models.CreateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("chartService")
public class ChartServiceImpl implements ChartService {

    @Autowired
    //private CreateRecordRepository createRecordRepository;
    private ChartRepository chartRepository;

    @Override
    /*public Iterable<CreateRecord> findAll() {
        return createRecordRepository.findAll();*/
    public Iterable<Chart> findAll() {
        return chartRepository.findAll();
    }
}
