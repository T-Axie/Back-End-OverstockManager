package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collec collection;
    @OneToOne
    private ImageModel userImage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
