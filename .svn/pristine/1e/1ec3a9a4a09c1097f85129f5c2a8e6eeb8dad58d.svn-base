package kr.go.uijeongbu.manager.outDataMng.cityStatMng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;
import kr.go.uijeongbu.cmm.vo.CityStatFileUploadVO;
@Repository("cityStatMngMapper")
public class CityStatMngMapper extends ComAbstractDAO {

	public List<Map<String, Object>> selectCityStatList(Map<String, Object> paramInfo) {
		// TODO Auto-generated method stub
		return selectList("CityStatMngDAO.selectCityStatList", paramInfo);
	}

	public int deleteData(Map<String, Object> paramInfo) {
		// TODO Auto-generated method stub
		return delete("CityStatMngDAO.deleteData", paramInfo);
	}

	public int insertData(CityStatFileUploadVO data) {
		// TODO Auto-generated method stub
		return insert("CityStatMngDAO.insertData", data);
	}

}
