package org.example.MachineCoding.SplitWise.controller;

import lombok.Getter;
import org.example.MachineCoding.SplitWise.model.Group;
import org.example.MachineCoding.SplitWise.model.Transaction;
import org.example.MachineCoding.SplitWise.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class GroupController {
    private Map<String, Group> groupMap;

    public GroupController() {
        groupMap = new HashMap<>();
    }

    public void addGroup(String groupName) {
        groupMap.put(groupName, new Group(groupName));
    }

    public Group getGroup(String groupName) {
        return groupMap.get(groupName);
    }

    public void addUserToGroup(String groupName, User user) {
        Group group = groupMap.get(groupName);
        if (group != null) {
            if(!group.getUserList().contains(user))
                group.addUser(user);
        }
    }

    public void showGroupStatus(String groupName) {
        Group group = groupMap.get(groupName);
        if (group != null) {
            group.showGroupStatus();
        }
    }
    public void addTransactionToGroup(String groupName, Transaction transaction) {
        Group group = groupMap.get(groupName);
        if (group != null) {
            group.addTransaction(transaction);
        }
    }

    public void settleUP(List<String> parameters) {

    }
}
