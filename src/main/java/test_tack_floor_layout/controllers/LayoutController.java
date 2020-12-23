package test_tack_floor_layout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test_tack_floor_layout.models.Layout;
import test_tack_floor_layout.models.dto.LayoutDto;
import test_tack_floor_layout.service.LayoutService;

import java.util.List;

@Controller
public class LayoutController {

    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @GetMapping("/layout/add")
    public String paint(Model model) {
        return "layout-floor";
    }

    @PostMapping("/layout/add")
    public ModelAndView paint(@RequestParam String point, @RequestParam String name, Model model) {

        ModelAndView modelAndView = new ModelAndView();
        Layout layout = new Layout();
        if (layoutService.integersValidation(point) == true && layoutService.diagonalAndIntersectValidation(point) == true && layoutService.countOfAnglesValidation(point) == true) {
            layout.setPoints(point);
            layout.setName(name);
            Long savedLayoutId = layoutService.add(layout).getId();
            modelAndView.setViewName("redirect:/layout/" + savedLayoutId);
        } else modelAndView.setViewName("layout-error");
        return modelAndView;
    }

    @GetMapping(value = "/layout/{layoutId}")
    public ModelAndView showLayout(@PathVariable("layoutId") Long layoutId, Model model){
        ModelAndView modelAndView = new ModelAndView();

        Layout layout = layoutService.getById(layoutId);
        LayoutDto layoutDto = new LayoutDto();
        layoutDto.setName(layout.getName());
        layoutDto.setPoints(layoutService.parser(layout.getPoints()));

        modelAndView.addObject("layout", layoutDto);

        modelAndView.setViewName("layout-paint");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView showAllLayout(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Layout> layout = layoutService.getAllLayouts();

        modelAndView.addObject("allLayouts", layout);

        modelAndView.setViewName("layout-all");

        return modelAndView;
    }

    @GetMapping("/remove/{id}")
    public String layoutRemove(@PathVariable(value = "id") Long layoutId, Model model) {
        Layout layout = layoutService.getById(layoutId);
        layoutService.delete(layout);
        return "redirect:/";
    }

}
