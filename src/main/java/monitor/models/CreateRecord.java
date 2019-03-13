package monitor.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class CreateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    public Date placedAt;

    //@Digits(integer=3, fraction=0, message = "Enter glucose level")
    //@NotNull(message = "Enter glucose level")
    public String glucose;

    @NotBlank(message = "Enter insulin level")
    private String insulin;

    @NotBlank(message = "Enter carbohydrates")
    private String carbs;

    private String note;

    public int quantity;

    @ManyToOne
    private Category category;

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
