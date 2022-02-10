package net.BasicSpringApp.Gipost.controller;
import net.BasicSpringApp.Gipost.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.BasicSpringApp.Gipost.entity.Group;

@Controller
public class GroupController
{
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        super();
        this.groupService = groupService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/groups")
    public String listGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "groups";
    }

    @GetMapping("/groups/new")
    public String createGroupForm(Model model) {

        // create student object to hold student form data
        Group group = new Group();
        model.addAttribute("group", group);
        return "create_group";

    }

    @PostMapping("/groups")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/group/edit/{id}")
    public String editGroupForm(@PathVariable Long id, Model model) {
        model.addAttribute("group", groupService.getGroupById(id));
        return "edit_group";
    }

    @PostMapping("/group/{id}")
    public String updateGroup(@PathVariable Long id,
                                @ModelAttribute("group") Group group,
                                Model model) {

        // get student from database by id
        Group existingGroup = groupService.getGroupById(id);
        existingGroup.setId(id);
        existingGroup.setName(group.getName());

        // save updated student object
        groupService.updateGroup(existingGroup);
        return "redirect:/groups";
    }

    // handler method to handle delete student request

    @GetMapping("/group/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return "redirect:/groups";
    }
}
