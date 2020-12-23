package test_tack_floor_layout.service;

import test_tack_floor_layout.models.Layout;
import java.util.List;

public interface LayoutService {

    List<Layout> getAllLayouts();

    Layout add(Layout layout);

    void delete(Layout layout);

    Layout getById(Long id);

    Boolean integersValidation(String point);

    Boolean diagonalAndIntersectValidation(String point);

    Boolean countOfAnglesValidation(String point);

    Integer[][] parser (String point);


}
