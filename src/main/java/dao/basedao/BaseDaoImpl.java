package dao.basedao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by jay on 2014/11/28.
 */
@Repository("BaseDao")
public class BaseDaoImpl implements BaseDao{

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public <T> T getEntityById(Class<T> t, String id) {
        String hql = "from "+t.getName()+" u where u.id= '"+id+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return (T) query.uniqueResult();

    }

    /**
     * 查找所有的实体
     *
     * @param t
     * @return
     */
    @Override
    public <T> List<T> getAllEntity(Class<T> t) {
        String hql = "from "+t.getName();
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.list();
    }

    /**
     * 保存实体
     *
     * @param t
     */
    @Override
    public <T> void saveEntity(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    /**
     * 通过实体删除
     *
     * @param t
     */
    @Override
    public <T> void delEntity(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    /**
     * 通过id删除实体
     *
     * @param t
     * @param id
     */
    @Override
    public <T> Boolean delEntityById(Class<T> t, String id) {
       String hql = "delete "+t.getName()+" as model where model.id = '"+id+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return (query.executeUpdate() > 0);
    }

    /**
     * 更新实体
     *
     * @param t
     */
    @Override
    public <T> Boolean updateEntity(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return true;
    }

    /**
     * 批量保存实体
     *
     * @param entitys
     */
    @Override
    public <T> void batchSave(List<T> entitys) {
        Session session = sessionFactory.getCurrentSession();
        for (int i = 0; i < entitys.size(); i++) {
            session.save(entitys.get(i));
            if (i % 20 == 0) {
                // 20个对象后才清理缓存，写入数据库
                session.flush();
                session.clear();
            }
        }
        // 最后清理一下----防止大于20小于40的不保存
        session.flush();
        session.clear();
    }

    /**
     * 通过实体和实体属性后去唯一值
     *
     * @param entityClass
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value) {

        String hql = "from "+entityClass.getName()+" u where u."+propertyName+"= ?";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter(0,value);

        return (T) query.uniqueResult();
    }

    /**
     * 通过实体和实体类属性查找列表值
     *
     * @param entityClass
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {
        String hql = "from "+entityClass.getName()+" u where u."+propertyName+"= ?";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter(0,value);

        return query.list();
    }

    /**
     * 通过实体集合删除实体
     * @param entitys
     * @param <T>
     */
    @Override
    public <T> void deleteAllEntitie(Collection<T> entitys) {
        Session session = sessionFactory.getCurrentSession();
        for (Object entity : entitys) {
            session.delete(entity);
            session.flush();
        }
    }

    /**
     * 通过hql获取列表数据
     *
     * @param hql
     * @return
     */
    @Override
    public <T> List<T> findByHqlString(String hql) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(hql);

        List<T> list = query.list();

        if(list.size()>0){
            session.flush();
        }
        return list;
    }

    /**
     * 通过sql更新数据
     *
     * @param sql
     * @return
     */
    @Override
    public int updateBySqlString(String sql) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(sql);

        return query.executeUpdate();
    }

    /**
     * 通过sql获取list
     *
     * @param query
     * @return
     */
    @Override
    public <T> List<T> findListbySql(String query) {
        Session session = sessionFactory.getCurrentSession();
        Query queryList = session.createSQLQuery(query);

        return queryList.list();
    }

    /**
     * 通过属性查找列表，并进行排序
     *
     * @param entityClass
     * @param propertyName
     * @param value
     * @param isAsc
     * @return
     */
    @Override
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc) {

        String paixu = "";
        if (true == isAsc){
            paixu = "asc";
        }else{
            paixu = "desc";
        }
        String hql = "from "+entityClass.getName()+" u where u."+propertyName+"= ? order by u."+propertyName+" "+paixu;

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter(0,value);

        return query.list();
    }

    /**
     * 通过hql获取唯一实体值
     *
     * @param hql
     * @return
     */
    @Override
    public <T> T findsingleResult(String hql) {

        Session sesion = sessionFactory.getCurrentSession();

        Query queryObject = sesion.createQuery(hql);

        return (T) queryObject.uniqueResult();
    }
}
