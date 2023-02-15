package kr.go.uijeongbu.manager.outDataMng.cityStatMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.go.uijeongbu.cmm.vo.CityStatFileUploadVO;
import kr.go.uijeongbu.manager.outDataMng.cityStatMng.service.CityStatMngService;

@Service("cityStatMngService")
public class CityStatMngServiceImpl extends EgovAbstractServiceImpl implements CityStatMngService {

	@Resource(name = "cityStatMngMapper")
	private CityStatMngMapper cityStatMngMapper;
	
	@Override
	public List<Map<String, Object>> selectCityStatList(Map<String, Object> paramInfo)
			throws IOException, SQLException {
		// TODO Auto-generated method stub
		return cityStatMngMapper.selectCityStatList(paramInfo);
	}

	@Override
	public int deleteData(Map<String, Object> paramInfo) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return cityStatMngMapper.deleteData(paramInfo);
	}

	@Override
	public int insertData(CityStatFileUploadVO data) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return cityStatMngMapper.insertData(data);
	}

}
