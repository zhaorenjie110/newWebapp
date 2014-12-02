package Service.baseService;

import java.util.Collection;
import java.util.List;

/**
 * Created by jay on 2014/11/28.
 */
public interface BaseService {

    /**
     * 保存实体
     * @param entity
     * @param <T>
     */
    public <T> void save(T entity);

    /**
     * 更新实体
     * @param entity
     * @param <T>
     */
    public <T> void saveOrUpdate(T entity);

    /**
     * 删除实体
     * @param entity
     * @param <T>
     */
    public <T> void delete(T entity);

    /**
     * 批量保存
     * @param entitys
     * @param <T>
     */
    public <T> void batchSave(List<T> entitys);

    /**
     *通过id获取实体
     * @param t
     * @param id
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> t, String id);

    /**
     * 根据实体名称和实体属性获取唯一值
     * @param t
     * @param propertyName
     * @param value
     * @param <T>
     * @return
     */
    public <T> T findUniqueByProperty(Class<T> t, String propertyName, Object value);

    /**
     * 通过实体名和实体属性获取列表值
     * @param entityClass
     * @param propertyName
     * @param value
     * @param <T>
     * @return
     */
    public <T> List<T> findByProperty(Class<T> entityClass,
                                      String propertyName, Object value);

    /**
     * 通过实体名获取全部实体
     * @param entityClass
     * @param <T>
     * @return
     */
    public <T> List<T> getAll(Class<T> entityClass);

    /**
     * 通过id,删除实体
     * @param entityClass
     * @param id
     * @param <T>
     */
    public <T> void deleteEntityById(Class<T> entityClass, String id);

    /**
     * 通过实体集合删除集合
     * @param entities
     * @param <T>
     */
    public <T> void deleteAllEntitie(Collection<T> entities);

    /**
     * 通过hql获取实体列表
     * @param hql
     * @param <T>
     * @return
     */
    public <T> List<T> findByHqlString(String hql);

    /**
     * 通过sql更新
     * @param sql
     * @return
     */
    public int updateBySqlString(String sql);

    /**
     * 通过sql查找list
     * @param query
     * @param <T>
     * @return
     */
    public <T> List<T> findListbySql(String query);

    /**
     * 通过属性查找列表，并排序
     * @param entityClass
     * @param propertyName
     * @param value
     * @param isAsc
     * @param <T>
     * @return
     */
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc);

    /**
     * 通过hql获取唯一实体
     * @param hql
     * @param <T>
     * @return
     */
    public <T> T findsingleResult(String hql);

}
