package com.metacube.queue.dao;

import com.metacube.queue.model.College;

public interface CollegeDAO extends BaseDao<College> {
    public College getCollege(String id);
}
