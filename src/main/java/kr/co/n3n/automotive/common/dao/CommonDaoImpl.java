package kr.co.n3n.automotive.common.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.n3n.automotive.common.model.CommMap;




@Repository
public class CommonDaoImpl extends DaoSupport  implements CommonDao {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<CommMap> selectList(String queryId, CommMap daoParam) {
	    return sqlSession.selectList(queryId, daoParam);
	}
	
	@Override
    public CommMap selectOne(String queryId, CommMap daoParam) {
        return sqlSession.selectOne(queryId, daoParam);
    }
    
    @Override
    public void insert(String queryId, CommMap daoParam) {
        sqlSession.insert(queryId, daoParam);
    }
    
    @Override
    public void update(String queryId, CommMap daoParam) {
        sqlSession.update(queryId, daoParam);
    }
    
    @Override
    public void delete(String queryId, CommMap daoParam) {
        sqlSession.delete(queryId, daoParam);
    }

	
    
    
    
    
}
