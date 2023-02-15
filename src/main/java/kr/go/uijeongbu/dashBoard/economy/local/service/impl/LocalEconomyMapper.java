package kr.go.uijeongbu.dashBoard.economy.local.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("localEconomyMapper")
public class LocalEconomyMapper extends ComAbstractDAO {
	

	public Map<String, Object> selectLocalEconomyMaxDate() {
		return selectOne("LocalEconomyMapper.selectLocalEconomyMaxDate");
	}

	public List<Map<String, Object>> selectLocalEconomyRange() {
		return selectList("LocalEconomyMapper.selectLocalEconomyRange");
	}
	
	public Map<String, Object> selectLocalEconomyDefaultMap() {
		return selectOne("LocalEconomyMapper.selectLocalEconomyDefaultMap");
	}
	
	public Map<String, Object> selectLocalEconomyCnt() {
		return selectOne("LocalEconomyMapper.selectLocalEconomyCnt");
	}
	
	public List<Map<String, Object>> selectLocalEconomyList() {
		return selectList("LocalEconomyMapper.selectLocalEconomyList");
	}
	
	public List<Map<String, Object>> selectEmdEconomy(Map<String, Object> params) {
		return selectList("LocalEconomyMapper.selectEmdEconomy", params);
	}
	
	public List<Map<String, Object>> selectEmdStore(Map<String, Object> params) {
		return selectList("LocalEconomyMapper.selectEmdStore", params);
	}
	
	public List<Map<String, Object>> selectTypeStore(Map<String, Object> params) {
		return selectList("LocalEconomyMapper.selectTypeStore", params);
	}

	public Map<String, Object> selectEmdEconomyDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selectOne("LocalEconomyMapper.selectEmdEconomyDate", params);
	}

	public Map<String, Object> selectEmdStoreDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selectOne("LocalEconomyMapper.selectEmdStoreDate", params);
	}

	public Map<String, Object> selectTypeStoreDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selectOne("LocalEconomyMapper.selectTypeStoreDate", params);
	}

	public Map<String, Object> selectLocalEconomyListDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selectOne("LocalEconomyMapper.selectLocalEconomyListDate", params);
	}
	
	
}
