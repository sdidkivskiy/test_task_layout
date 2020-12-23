package test_tack_floor_layout.models.dto;

import java.util.Arrays;
import java.util.Objects;

public class LayoutDto {

    private String name;

    private Integer[][] points;

    public LayoutDto(){}

    @Override
    public String toString() {
        return "LayoutDto{" +
                "name='" + name + '\'' +
                ", points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LayoutDto layoutDto = (LayoutDto) o;
        return name.equals(layoutDto.name) &&
                Arrays.equals(points, layoutDto.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[][] getPoints() {
        return points;
    }

    public void setPoints(Integer[][] points) {
        this.points = points;
    }
}
