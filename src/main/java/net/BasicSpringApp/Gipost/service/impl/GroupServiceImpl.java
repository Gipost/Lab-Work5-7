package net.BasicSpringApp.Gipost.service.impl;

import java.util.List;

import net.BasicSpringApp.Gipost.repository.GroupRepository;
import net.BasicSpringApp.Gipost.service.GroupService;
import net.BasicSpringApp.Gipost.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        super();
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }

}
