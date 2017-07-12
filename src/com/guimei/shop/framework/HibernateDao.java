package com.guimei.shop.framework;

import com.wang.db2.Dao;
import com.wang.db2.Query;
import com.wang.db2.Where;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.List;

/**
 * by wangrongjun on 2017/6/13.
 */
public abstract class HibernateDao<T> implements Dao<T> {

    protected static SessionFactory sessionFactory;

    public HibernateDao() {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }

    protected abstract Class<T> getEntityClass();

    protected String getTableName() {
        Entity tableAnno = getEntityClass().getAnnotation(Entity.class);
        if (tableAnno != null) {
            String name = tableAnno.name();
            if (name.length() > 0) {
                return name;
            }
        }
        return getEntityClass().getSimpleName();
    }

    protected String getIdName() {
        Field[] fields = getEntityClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Id.class) != null) {
                return field.getName();
            }
        }
        return null;
    }

    @Override
    public boolean createTable() {
        return false;
    }

    @Override
    public boolean dropTable() {
        return false;
    }

    @Override
    public boolean createForeignKey() {
        return false;
    }

    @Override
    public boolean insert(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Where where) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = sessionFactory.openSession();
        String idName = getIdName();
        try {
            T entity = getEntityClass().newInstance();
            Field idField = getEntityClass().getDeclaredField(idName);
            idField.set(entity, id);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean update(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public T queryById(int id) {
        Session session = sessionFactory.openSession();
//        T entity = session.get(getEntityClass(), id);
        T entity = (T) session.get(getEntityClass(), id);
        session.close();
        return entity;
    }

    @Override
    public List<T> queryAll() {
        Session session = sessionFactory.openSession();
        String hql = "from " + getTableName();
//        return session.createSQLQuery(sql).addEntity(getEntityClass()).list();
//        List<T> entityList = session.createQuery(hql, getEntityClass()).list();
        List<T> entityList = session.createQuery(hql).list();
        session.close();
        return entityList;
    }

    @Override
    public List<T> query(Where where) {
        Session session = sessionFactory.openSession();
        String hql = "from " + getTableName() + " where " + where;
        System.out.println(hql);
//        List<T> entityList = session.createQuery(hql, getEntityClass()).list();
        List<T> entityList = session.createQuery(hql).list();
        session.close();
        return entityList;
    }

    @Override
    public List<T> query(Query query) {
        return null;
    }

    @Override
    public int queryCount(Where where) {
        return 0;
    }

}
