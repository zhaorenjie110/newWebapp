package Service;


import Service.baseService.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jay on 2014/11/28.
 */
@Transactional
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{

}
