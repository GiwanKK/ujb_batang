/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.go.uijeongbu.manager.userAuth.userAuthMng.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
  * 관리자 > 부서 관리 Service 클래스
 * @author 김부권
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.08.25.   	김부권          최초 생성
 *   
 * </pre>
 */
public interface UserAuthMngService {

	
	/**
	 * 부서 목록 조회하기
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectDeptList(Map<String, Object> param) throws IOException, SQLException;

	
	/**
	 * 부서 정보 저장하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int insertDeptInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 부서 정보 수정하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int updateDeptInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 부서 정보 삭제하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int deleteDeptInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 부서별 권한 목록 가져오기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectDeptRoleList(Map<String, Object> param) throws IOException, SQLException;
	
	
	
	/**
	 * 부서별 권한 정보 삭제하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int deleteDeptRoleInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	/**
	 * 부서별 설정 권한 정보 추가하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int insertDeptRoleInfo(Map<String, Object> param) throws IOException, SQLException;
	
	
	
}
