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
package kr.go.uijeongbu.manager.codeMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.go.uijeongbu.manager.codeMng.service.CodeService;

/**
 * 관리자 > 공통코드 관리용 Service Implement 클래스
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

@Service("codeService")
public class CodeServiceImpl extends EgovAbstractServiceImpl implements CodeService {

	@Resource(name = "codeMapper")
	private CodeMapper codeMapper;

	/**
	 *  공통코드 목록 조회하기
	 */
	@Override
	public List<Map<String, Object>> selectCodeList(Map<String, Object> param) throws IOException, SQLException {
		return codeMapper.selectCodeList(param);
	}

	
	/**
	 * 공통코드 목록 저장하기
	 */
	@Override
	public int insertCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		return codeMapper.insertCodeInfo(param);
	}
	
	
	/**
	 * 공통코드 정보 수정하기
	 */
	@Override
	public int updateCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		return codeMapper.updateCodeInfo(param);
	}
	
	
	/**
	 * 공통코드 정보 삭제하기
	 */
	@Override
	public int deleteCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		return codeMapper.deleteCodeInfo(param);
	}
	
}
