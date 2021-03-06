package com.student.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.student.entity.Student;
import com.student.entity.WorkMan;

import com.student.dao.StudentDao;
import com.student.dao.WorkManDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;
    private final DaoConfig workManDaoConfig;

    private final StudentDao studentDao;
    private final WorkManDao workManDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        workManDaoConfig = daoConfigMap.get(WorkManDao.class).clone();
        workManDaoConfig.initIdentityScope(type);

        studentDao = new StudentDao(studentDaoConfig, this);
        workManDao = new WorkManDao(workManDaoConfig, this);

        registerDao(Student.class, studentDao);
        registerDao(WorkMan.class, workManDao);
    }
    
    public void clear() {
        studentDaoConfig.getIdentityScope().clear();
        workManDaoConfig.getIdentityScope().clear();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public WorkManDao getWorkManDao() {
        return workManDao;
    }

}
