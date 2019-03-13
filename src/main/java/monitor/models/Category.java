package monitor.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany(targetEntity = CreateRecord.class)
    @JoinColumn(name = "category_id")
    private List<CreateRecord> stats = new ArrayList<>();

}
