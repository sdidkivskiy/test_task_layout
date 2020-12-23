package test_tack_floor_layout.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test_tack_floor_layout.exceptions.MainException;
import test_tack_floor_layout.models.Layout;
import test_tack_floor_layout.repository.LayoutRepository;
import test_tack_floor_layout.service.LayoutService;

import java.util.List;

import static test_tack_floor_layout.constants.ErrorConstants.LAYOUT_BY_SUCH_ID_IS_NOT_FOUND;

@Service
public class LayoutServiceImpl implements LayoutService {

    @Autowired
    private LayoutRepository layoutRepository;

    @Override
    public List<Layout> getAllLayouts() {
        return (List<Layout>) layoutRepository.findAll();
    }

    @Override
    public Layout add(Layout layout) {
        return layoutRepository.save(layout);
    }

    @Override
    public void delete(Layout layout) {
        layoutRepository.delete(layout);
    }

    @Override
    public Layout getById(Long id) {
        return layoutRepository.findById(id)
                .orElseThrow(() -> new MainException(LAYOUT_BY_SUCH_ID_IS_NOT_FOUND, 404L));
    }

    @Override
    public Boolean integersValidation(String point) {

        String[] parsedPoints = parseStringWithPoints(point);

        for (int i = 0; i < parsedPoints.length; i++) {
            if (!parsedPoints[i].contains(".")) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean diagonalAndIntersectValidation(String point) {
        Integer[][] pointXY = parser(point);

        if (pointXY[0][0] == pointXY[pointXY.length - 1][0] || pointXY[0][1] == pointXY[pointXY.length - 1][1]) {
            for (int i = 1; i < pointXY.length - 2; i++) {
                if (pointXY[i][0] == pointXY[i++][0] || (pointXY[i][1] == pointXY[i++][1])) {
                    continue;
                } else return false;
            }
        } else return false;
        return true;
    }

    @Override
    public Boolean countOfAnglesValidation(String point) {
        Integer[][] pointXY = parser(point);
        if (!(pointXY.length >= 4)) {
            return false;
        } else return true;
    }

    @Override
    public Integer[][] parser(String point) {
        String[] parsedPoints = parseStringWithPoints(point);
        Integer[][] pointXY = new Integer[parsedPoints.length / 2][2];

        for (int i = 0; i < parsedPoints.length / 2; i++) {
            for (int j = 0; j < 2; j++) {
                pointXY[i][j] = Integer.valueOf(parsedPoints[i * 2 + j]);
            }
        }
        return pointXY;
    }

    private String[] parseStringWithPoints(String point) {
        String[] myPoints = point.replace("(", "").replace(")", "").replace(",", "").split(" ");
        return myPoints;
    }

}


