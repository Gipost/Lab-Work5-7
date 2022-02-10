package net.BasicSpringApp.Gipost.service;
import java.util.List;
import net.BasicSpringApp.Gipost.entity.Group;

public interface GroupService {
    List<Group> getAllGroups();

    Group saveGroup(Group group);

    Group getGroupById(Long id);

    Group updateGroup(Group group);

    void deleteGroupById(Long id);
}
