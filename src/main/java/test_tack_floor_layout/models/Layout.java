package test_tack_floor_layout.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Layout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String points;

    public Layout() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layout layout = (Layout) o;
        return Objects.equals(id, layout.id) &&
                name.equals(layout.name) &&
                points.equals(layout.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, points);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
