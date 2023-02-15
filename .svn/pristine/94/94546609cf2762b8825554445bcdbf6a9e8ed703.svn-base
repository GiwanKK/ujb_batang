package kr.go.uijeongbu.manager.outDataMng.cityStatMng.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.go.uijeongbu.cmm.vo.CityStatFileUploadVO;

public interface CityStatMngService {

	/**
	 * Upload 데이터 목록 조회하기
	 * @param searchVO
	 * @return
	 * @throws IOException, SQLException
	 */
	
	List<Map<String, Object>> selectCityStatList(Map<String, Object> paramInfo) throws IOException, SQLException;

	int deleteData(Map<String, Object> paramInfo) throws IOException, SQLException;

	int insertData(CityStatFileUploadVO data) throws IOException, SQLException;

}
