package com.orangecandle.dao;

import java.util.List;

import com.orangecandle.domain.Group;

public interface GroupDAO {
	public void addGroup(Group p);
    public void updateGroup(Group p);
    public List<Group> listGroups();
    public Group getGroupById(int id);
    public void removeGroup(int id);
}
