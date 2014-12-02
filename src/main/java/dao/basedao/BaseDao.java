package dao.basedao;

import java.util.Collection;
import java.util.List;

/**
 * Created by jay on 2014/11/28.
 * 泛型基础dao,一共有两个，一个是类泛型，一个是方法泛型
 * 这是一个方法泛型
 */
public interface BaseDao {
    /**
     * 通过id查找
     * @param t
     * @param id
     * @param <T>
     * @return
     */
    <T> T getEntityById(Class<T> t, String id);

    /**
     * 查找所有的实体
     * @param t
     * @param <T>
     * @return
     */
    <T> List<T> getAllEntity(Class<T> t);

    /**
     * 保存实体
     * @param t
     * @param <T>
     */
    <T> void saveEntity(T t);

    /**
     * 通过实体删除
     * @param t
     * @param <T>
     */
    <T> void delEntity(T t);

    /**
     * 通过id删除实体
     * @param t
     * @param id
     * @param <T>
     */
    <T> Boolean delEntityById(Class<T> t,String id);

    /**
     * 更新实体
     * @param t
     * @param <T>
     */
    <T> Boolean updateEntity(T t);

    /**
     * 批量保存实体
     * @param entitys
     * @param <T>
     */
    public <T> void batchSave(List<T> entitys);

    /**
     * 通过实体和实体属性后去唯一值
     * @param entityClass
     * @param propertyName
     * @param value
     * @param <T>
     * @return
     */
    public <T> T findUniqueByProperty(Class<T> entityClass,
                                      String propertyName, Object value);

    /**
     * 通过实体和实体类属性查找列表值
     * @param entityClass
     * @param propertyName
     * @param value
     * @param <T>
     * @return
     */
    public <T> List<T> findByProperty(Class<T> entityClass,
                                      String propertyName, Object value);

    /**
     * 通过实体集合删除实体
     * @param entitys
     * @param <T>
     */
    public <T> void deleteAllEntitie(Collection<T> entitys);

    /**
     * 通过hql获取列表数据
     * @param hql
     * @param <T>
     * @return
     */
    public <T> List<T> findByHqlString(String hql);

    /**
     * 通过sql更新数据
     * @param sql
     * @return
     */
    public int updateBySqlString(String sql);

    /**
     * 通过sql获取list
     * @param query
     * @param <T>
     * @return
     */
    public <T> List<T> findListbySql(String query);

    /**
     * 通过属性查找列表，并进行排序
     * @param entityClass
     * @param propertyName
     * @param value
     * @param isAsc
     * @param <T>
     * @return
     */
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc);

    /**
     * 通过hql获取唯一实体值
     * @param hql
     * @param <T>
     * @return
     */
    public <T> T findsingleResult(String hql);
}
