/*
 * Copyright 2outDataMapper.outDataMapper.8-2outDataMapper.outDataMapper.9 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.outDataMapper. (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.outDataMapper.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.go.uijeongbu.manager.outDataMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.go.uijeongbu.manager.outDataMng.service.OutDataService;

/**
 * 관리자 > Upload 데이터 관리용 Service Implement 클래스
 * @author 김부권
 * @since 2outDataMapper.21. outDataMapper.8. 25.
 * @version 1.outDataMapper.
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2outDataMapper.21.outDataMapper.8.25.   	김부권          최초 생성
 *   
 * </pre>
 */

@Service("outDataService")
public class OutDataServiceImpl extends EgovAbstractServiceImpl implements OutDataService {

	@Resource(name = "outDataMapper")
	private OutDataMapper outDataMapper;


	/**
	 * Upload 데이터 목록 조회하기
	 */
	@Override
	public List<Map<String, Object>> selectUploadDataList(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.selectUploadDataList(param);
	}
	
	
	/**
	 * Upload 데이터 History 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public List<Map<String, Object>> selectUploadDataHisList(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.selectUploadDataHisList(param);
	}
	
	
	
	/**
	 * Upload 데이터 정보 저장하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public int insertFileUploadInfo(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.insertFileUploadInfo(param);
	}
	

	/**
	 * 데이터 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	/*
	@Override
	public int updateCreateDataInfo(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.updateCreateDataInfo(param);
	}
	*/
	
	
	/**
	 * 통계 생성 정보 변경하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	/*
	@Override
	public int updateCreateAnalysisInfo(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.updateCreateAnalysisInfo(param);
	}
	*/
	
	
	/**
	 * Upload 데이터 History 저장하기 : 업로드
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public int insertFileUploadHistory(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.insertFileUploadHistory(param);
	}
	
	
	/**
	 * Upload File 정보 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public Map<String, Object> selectUpliadFileInfo(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.selectUpliadFileInfo(param);
	}
	
	
	/**
	 * 테이블명 중복 체크
	 */
	@Override
	public Map<String, Object> checkDupTableName(Map<String, Object> param) throws IOException, SQLException {
		return outDataMapper.checkDupTableName(param);
	}


	@Override
	public int createPopGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopGenderAge(param);
	}


	@Override
	public int insertPopGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopGenderAge(param);
	}


	@Override
	public int deletePopGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopGenderAge(param);
	}


	@Override
	public int createPopDongForgService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopDongForgService(param);
	}


	@Override
	public int insertPopDongForgService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopDongForgService(param);
	}


	@Override
	public int deletePopDongForgService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopDongForgService(param);
	}


	@Override
	public int createPopTimeFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopTimeFlow(param);
	}


	@Override
	public int insertPopTimeFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopTimeFlow(param);
	}


	@Override
	public int deletePopTimeFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopTimeFlow(param);
	}


	@Override
	public int createPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopDongGenderAge(param);
	}


	@Override
	public int insertPopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopDongGenderAge(param);
	}


	@Override
	public int deletePopDongGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopDongGenderAge(param);
	}


	@Override
	public int createPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopGenderAgeService(param);
	}


	@Override
	public int insertPopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopGenderAgeService(param);
	}


	@Override
	public int deletePopGenderAgeService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopGenderAgeService(param);
	}


	@Override
	public int createPopFlowService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createPopFlowService(param);
	}


	@Override
	public int insertPopFlowService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertPopFlowService(param);
	}


	@Override
	public int deletePopFlowService(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deletePopFlowService(param);
	}


	@Override
	public int createSaleCorp(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleCorp(param);
	}


	@Override
	public int insertSaleCorp(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleCorp(param);
	}


	@Override
	public int deleteSaleCorp(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleCorp(param);
	}


	@Override
	public int createSaleForeigner(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleForeigner(param);
	}


	@Override
	public int insertSaleForeigner(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleForeigner(param);
	}


	@Override
	public int deleteSaleForeigner(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleForeigner(param);
	}


	@Override
	public int createSaleDayTime(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleDayTime(param);
	}


	@Override
	public int insertSaleDayTime(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleDayTime(param);
	}


	@Override
	public int deleteSaleDayTime(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleDayTime(param);
	}


	@Override
	public int createSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleMonthFlow(param);
	}


	@Override
	public int insertSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleMonthFlow(param);
	}


	@Override
	public int deleteSaleMonthFlow(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleMonthFlow(param);
	}


	@Override
	public int createSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleDayGenderAge(param);
	}


	@Override
	public int insertSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleDayGenderAge(param);
	}


	@Override
	public int deleteSaleDayGenderAge(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleDayGenderAge(param);
	}


	@Override
	public int createSaleCitizen(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.createSaleCitizen(param);
	}


	@Override
	public int insertSaleCitizen(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.insertSaleCitizen(param);
	}


	@Override
	public int deleteSaleCitizen(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return outDataMapper.deleteSaleCitizen(param);
	}
	
	
}
