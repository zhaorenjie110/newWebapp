package Service.baseService;

import dao.basedao.BaseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by jay on 2014/11/28.
 */
@Transactional
@Service
public class BaseServiceImpl implements BaseService {

    @Resource(name = "BaseDao")
    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
    /**
     * 保存实体
     *
     * @param entity
     */
    @Override
    public <T> void save(T entity) {

        baseDao.saveEntity(entity);
    }

    /**
     * 更新实体
     *
     * @param entity
     */
    @Override
    public <T> void saveOrUpdate(T entity) {
        baseDao.updateEntity(entity);
    }

    /**
     * 删除实体
     *
     * @param entity
     */
    @Override
    public <T> void delete(T entity) {
        baseDao.delEntity(entity);

    }

    /**
     * 批量保存
     *
     * @param entitys
     */
    @Override
    public <T> void batchSave(List<T> entitys) {
        baseDao.batchSave(entitys);
    }

    /**
     * 通过id获取实体
     * @param t
     * @param id
     * @return
     */
    @Override
    public <T> T get(Class<T> t, String id) {
        return baseDao.getEntityById(t,id);
    }

    /**
     * 根据实体名称和实体属性获取唯一值
     *
     * @param t
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    public <T> T findUniqueByProperty(Class<T> t, String propertyName, Object value) {
       return baseDao.findUniqueByProperty(t,propertyName,value);
    }

    /**
     * 通过实体名和实体属性获取列表值
     *
     * @param entityClass
     * @param propertyName
     * @param value
     * @return
     */
    @Override
    public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value) {

        return baseDao.findByProperty(entityClass,propertyName,value);
    }

    /**
     * 通过实体名获取全部实体
     *
     * @param entityClass
     * @return
     */
    @Override
    public <T> List<T> getAll(Class<T> entityClass) {
        return baseDao.getAllEntity(entityClass);
    }

    /**
     * 通过id,删除实体
     *
     * @param entityClass
     * @param id
     */
    @Override
    public <T> void deleteEntityById(Class<T> entityClass, String id) {
        baseDao.delEntityById(entityClass,id);

    }

    /**
     * 通过实体集合删除集合
     *
     * @param entities
     */
    @Override
    public <T> void deleteAllEntitie(Collection<T> entities) {
        baseDao.deleteAllEntitie(entities);
    }

    /**
     * 通过hql获取实体列表
     *
     * @param hql
     * @return
     */
    @Override
    public <T> List<T> findByHqlString(String hql) {
        return baseDao.findByHqlString(hql);
    }

    /**
     * 通过sql更新
     *
     * @param sql
     * @return
     */
    @Override
    public int updateBySqlString(String sql) {

        return baseDao.updateBySqlString(sql);
    }

    /**
     * 通过sql查找list
     *
     * @param query
     * @return
     */
    @Override
    public <T> List<T> findListbySql(String query) {
        return baseDao.findListbySql(query);
    }

    /**
     * 通过属性查找列表，并排序
     *
     * @param entityClass
     * @param propertyName
     * @param value
     * @param isAsc
     * @return
     */
    @Override
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass, String propertyName, Object value, boolean isAsc) {
        return baseDao.findByPropertyisOrder(entityClass,propertyName,value,isAsc);
    }

    /**
     * 通过hql获取唯一实体
     *
     * @param hql
     * @return
     */
    @Override
    public <T> T findsingleResult(String hql) {
        return null;
    }


}
