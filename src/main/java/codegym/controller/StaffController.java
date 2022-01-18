package codegym.controller;

import codegym.model.Branch;
import codegym.model.Staff;
import codegym.service.IBranchService;
import codegym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("staffs")
public class StaffController {

    @Autowired
    IStaffService staffService;
    @Autowired
    IBranchService branchService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("staffs", staffService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/detail")
    public ModelAndView showDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("staff", new Staff());
        modelAndView.addObject("branches", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@ModelAttribute("staff") Staff staff, @RequestParam("idBranch") Long id) {
        Branch branch = new Branch();
        branch.setId(id);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/staffs";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("staff", staffService.findById(id));
        modelAndView.addObject("branches", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute("staff") Staff staff, @RequestParam("idBranch") Long id) {
        Branch branch = new Branch();
        branch.setId(id);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/staffs";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("staff", staffService.findById(id) );
        modelAndView.addObject("branches", branchService.findAll());
        return modelAndView;
    }

    @PostMapping("delete")
    public String edit(@RequestParam(value = "id") Long id) {
        staffService.delete(id);
        return "redirect:/staffs";
    }
}
