package kr.go.uijeongbu.manager.linkMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.manager.linkMng.service.LinkMngService;


/**
 * @Description		: 연계데이터 관리 ServiceImpl
 * @Source        	: LinkMngServiceImpl.java
 * @author 김부권
 * @since 2021. 09. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.09.23.   	김부권          최초 생성
 *   
 * </pre>
 */
@Service("linkMngService")
public class LinkMngServiceImpl implements LinkMngService {

	@Resource(name = "linkMngMapper")
	private LinkMngMapper linkMngMapper;

	/**
	 * 연계주기 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public List<Map<String, Object>> selectLinkList() throws IOException, SQLException {
		
		return linkMngMapper.selectLinkList();
	}
	@Override
	public List<Map<String, Object>> selectLinkStatusList() throws IOException, SQLException {
		
		return linkMngMapper.selectLinkStatusList();
	}
	
	/**
	 * 연계 GRID 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	@Override
	public List<Map<String, Object>> selectLinkData(Map<String, Object> param) throws IOException, SQLException {
		
		return linkMngMapper.selectLinkData(param);
	}

	@Override
	public List<Map<String, Object>> selectLinkDataLog(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return linkMngMapper.selectLinkDataLog(param);
	}

	@Override
	public Map<String, Object> selectLinkDataDate(Map<String, Object> param) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return linkMngMapper.selectLinkDataDate(param);
	}


}
