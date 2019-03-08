package monitor.data;

import monitor.models.Chart;
import org.springframework.data.repository.CrudRepository;

public interface ChartRepository extends CrudRepository<Chart, Long> {
}