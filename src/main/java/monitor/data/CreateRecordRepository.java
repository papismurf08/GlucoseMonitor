package monitor.data;

import monitor.models.CreateRecord;
import org.springframework.data.repository.CrudRepository;

public interface CreateRecordRepository extends CrudRepository<CreateRecord, Long> {
}