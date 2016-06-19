package dg2.dmi.com.dagger2.product.domain;

/**
 * Created by polenchheang on 5/8/16.
 */
public class Product {

    private Long id;
    private String title;
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
