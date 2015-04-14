package com.orangecandle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangecandle.dao.GroupDAO;
import com.orangecandle.domain.Group;

@Service
@Transactional
public class GroupServiceImp implements GroupService {
	private GroupDAO group;
	@Override
	public void addGroup(Group p) {
		group.addGroup(p);
	}

	@Override
	public void updateGroup(Group p) {
		group.updateGroup(p);
	}

	@Override
	public Group getGroupById(int id) {
		return group.getGroupById(id);
	}

	@Override
	public void removeGroup(int id) {
		group.removeGroup(id);
	}

	@Override
	public List<Group> listGroups() {
		return	group.listGroups();
	}

}
