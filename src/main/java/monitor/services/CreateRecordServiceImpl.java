package monitor.services;

import monitor.data.CreateRecordRepository;
import monitor.models.CreateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("createRecordService")
public class CreateRecordServiceImpl implements CreateRecordService {

    @Autowired
    private CreateRecordRepository createRecordRepository;

    @Override
    public Iterable<CreateRecord> findAll() {
        return createRecordRepository.findAll();
    }
}
