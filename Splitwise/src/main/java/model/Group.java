package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class Group {
    private final int groupId;
    private final GroupMetadata groupMetadata;
    private final Ledger ledger = new Ledger();
    private final List<String> users = new ArrayList<>();

    public Group(int groupId, GroupMetadata groupMetadata) {
        this.groupId = groupId;
        this.groupMetadata = groupMetadata;
    }

    public int getGroupId() {
        return groupId;
    }

    public GroupMetadata getGroupMetadata() {
        return groupMetadata;
    }

    public Ledger getLedger() {
        return ledger;
    }

    public List<String> getUsers() {
        return users;
    }
}
