package dao;

import dao.basedao.BaseDao;
import dao.basedao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
}
