var loading = $.loading();
$(function () {
    "use strict";
    
    /***************************************************************************************************
    * 1. 변수 선언 영역
    ****************************************************************************************************/
 	// 부서 Grid 객체 선언
    var ax5GridViewDept = null;
    
 	// 권한 Grid 객체 선언
    var ax5GridViewRole = null;
    
    
	/***************************************************************************************************
    * 2. 화면 및 Element 설정 영역 (Default 및 Initialization)
    ****************************************************************************************************/
    
 	// loading 시 입력항목 비활성화 시키기
    fn_disableInputElement(true);
    
    // 부서 목록 그리드 생성
    //fn_initDeptGrid();
	
 	// 권한 목록 그리드 생성
    //fn_initRoleGrid();
    
    
    /***************************************************************************************************
    * 3.Chart 영역
    ****************************************************************************************************/
     
    
    
    /***************************************************************************************************
    * 4.Grid 영역
    ****************************************************************************************************/
    
    // 부서 목록 그리드 생성
	function fn_initDeptGrid() {
		
		// 그리드 설정을 위한 Config 정보 객체
	    var gridConfigInfo = {};
		
    	// Columns 정보 설정
    	gridConfigInfo.columns = [
    		{key: "userId", 		label: "사용자ID", 		width: '20%',		align: "center"},
    		{key: "userName", 		label: "사용자명", 		width: '20%',		align: "center"},
    		{key: "deptName", 		label: "부서명", 		width: '20%',		align: "left"},
    		{key: "posName", 		label: "직급명", 		width: '20%',		align: "left"},
    		{key: "roleName", 		label: "권한명", 		width: '20%',		align: "left"}
        ];
    	
		// Page Display 옵션
    	gridConfigInfo.page = {display:false};
    	
    	// 그리드 생성하기
	    GRID.createGridView("dept-grid", gridConfigInfo, function(ax5Grid){
	    	
	    	// 화면별 그리드 사용을 위해 객체를 Return 받는다
	    	ax5GridViewDept = ax5Grid;
	    	
	    	// Default 옵션 외 Config 설정
	    	fn_setExtendConfig();
	    	
	    	// 부서 목록 데이터 가져오기
	    	//fn_getDeptList();
	    });
	};
	
	// Default 옵션 외 Config 설정
	function fn_setExtendConfig() {
		
		// 그리드 Body Click Event 선언
		ax5GridViewDept.config.body.onClick = fn_gridBodyOnClick;
				
		// 그리드 Header의 Checbox Display
		ax5GridViewDept.config.header.selector = false;
	
		
		// Row Selector(Row Checkbox) 보이기
		//var configOption = {showRowSelector:true, multipleSelect:true, rowSelectorColumnWidth:25};
		
		//GRID.showRowSelector(ax5GridViewDept, configOption);			
	};
	
	
	// 그리드 Body Click Event 선언
	function fn_gridBodyOnClick() {
		
		var selectColumn = this.column;
   		var selectColumnIndex = this.colIndex;
   		var selectColumnValue = this.value;
   		
   		var selectRowValues = this.item;
   		var selectRowIndex = this.dindex;
   		
   		ax5GridViewDept.selectAll({selected: false});
   		
   		// 선택한 Row의 Checkbox Select 처리
   		ax5GridViewDept.select(selectRowIndex, {selected: true});
   		
   		
   		// 권한 목록 데이터 가져오기
    	fn_getRoleList(selectRowValues);
   		
		// 버튼 활성화   		
        fn_disableInputElement(false);
	};
	

	// 권한 그리드 생성
    function fn_initRoleGrid() {
    	
    	// 그리드 설정을 위한 Config 정보 객체
	    var gridConfigInfo = {};
		
    	// Columns 정보 설정
    	gridConfigInfo.columns = [
    		{key: "roleCode", 		label: "권한 코드", 	width: '30%',		align: "center"},
    		{key: "roleName", 		label: "권한명", 		width: '30%',		align: "left"},
            {key: "roleDesc", 		label: "권한 설명", 	width: '40%',		align: "left"}
        ];
    	
    	
		// Page Display 옵션
    	gridConfigInfo.page = {display:false};
    	
    	// 그리드 생성하기
	    GRID.createGridView("role-grid", gridConfigInfo, function(ax5Grid){
	    	
	    	// 화면별 그리드 사용을 위해 객체를 Return 받는다
	    	ax5GridViewRole = ax5Grid;
	    	
	    	// Default 옵션 외 Config 설정
	    	fn_setExtendConfigRole();
	    });
	    
    };
    
    
    
 	// 권한 그리드 Default 옵션 외 Config 설정
	function fn_setExtendConfigRole() {
 		
		// 권한 그리드 Body Click Event 선언
		//ax5GridViewRole.config.body.onClick = fn_roleGridBodyOnClick;
		
		// 그리드 Checkbox Click Event 선언
		//ax5GridViewRole.config.body.onDataChanged = fn_roleGridDataChanged;
		
		// 그리드 Header의 Checbox Display
		ax5GridViewRole.config.header.selector = false;
		
		// Row Selector(Row Checkbox) 보이기
		var configOption = {showRowSelector:true, multipleSelect:false, rowSelectorColumnWidth:25};
		
		GRID.showRowSelector(ax5GridViewRole, configOption);
		
	};
	
	
	/***************************************************************************************************
    * 6.Popup 영역
    ****************************************************************************************************/
    
    
    
    /***************************************************************************************************
    * 7.일반 Function 영역
    ****************************************************************************************************/

	//페이지 로딩 함수 호출
	fn_loadWord();
	
	//페이지 로딩시 
	function fn_loadWord(){
		var param ={};
		// 부서 목록 그리드 생성
	    fn_initDeptGrid();
	 	// 권한 목록 그리드 생성
	    fn_initRoleGrid();
	    
		Util.request("/mamager/userAuth/userAuthSearchList.do", param, function(resultData){
			
			fn_deptList(resultData.deptAllList);
			fn_positionIdList(resultData.positionList);
			if(resultData.gridList.length == 0){
    			alert("조회 결과 데이터가 없습니다.");
    		}else{
    			GRID.setGridData(ax5GridViewDept, resultData.gridList);
    		}
		});
	};
	
    
 	// 부서 목록 데이터 가져오기
	function fn_getDeptList() {
		
		var requestUrl = "/mamager/userAuth/getDeptList.do";
		
		var param ={};
		
		param.deptInfo = {};
		param.deptInfo.userName = $("#userName").val();
		param.deptInfo.department = $("#department").val();
		param.deptInfo.positionId = $("#position_id").val();
		
		//GRID.setGridDataAjax(ax5GridViewDept, requestUrl, param);
		// 부서 목록 조회하기 Loading bar를 보여주기 위해 Util.Request 사용
		Util.request(requestUrl, param, function(resultData){
			
			GRID.setGridData(ax5GridViewDept, resultData.gridList, null);
		});
	};
	

	// 권한 목록 데이터 가져오기
	function fn_getRoleList(paramDeptInfo) {
		
		var requestUrl = "/mamager/userAuth/selectDeptRoleList.do";
		
		var param ={};
		
		param.deptInfo = paramDeptInfo;
		
		//GRID.setGridDataAjax(ax5GridViewRole, requestUrl, param);
		
		// 권한 목록 조회하기 Loading bar를 보여주기 위해 Util.Request 사용
		Util.request(requestUrl, param, function(resultData){
			GRID.setGridData(ax5GridViewRole, resultData.gridList, fn_selectRoleGrid);
		});
	};
	
	
	// 권한 목록에서 Selected 권한에 대해 Checkbox Select 처리
	function fn_selectRoleGrid(gridDataList) {
		
		// 그리드 데이터 수 만큼
		for(var idx = 0 ; idx < gridDataList.length ; idx++){
			
			var gridInfo = gridDataList[idx];
			
			// DB Query 에서 role_selected 값이 'Y' 인 항목은 Select 처리
			if(Util.isEqual(gridInfo.roleSelected, "Y")){
				
				ax5GridViewRole.select(idx);
			}
		}
	};
	
	
	// 입력 항목 disabled 설정
	function fn_disableInputElement(disableFlag) {
		
		// Button
		$("#btnSaveRoleInfo").attr("disabled", disableFlag);		// 권한정보 저장 버튼
	};
	
	
	//부서리스트 가져오기
	function fn_deptList(resultList){
	    //부서리스트
	    Util.selectAddOption(resultList, "department", true);
		/*$("#department").select2({
			placeholder: "모두",
			allowClear: true,
			minimumResultsForSearch:-1,
			data:resultList,
			width: 150
		});*/
		
	};
	
	//직위리스트 가져오기
	function fn_positionIdList(resultList){
		
		//직위리스트
		Util.selectAddOption(resultList, "position_id", true);
		/*$("#position_id").select2({
			placeholder: "모두",
			allowClear: true,
			minimumResultsForSearch:-1,
			data:resultList,
			width: 150
		});
		*/
	};
    
	/***************************************************************************************************
    * 8.Button Event 영역
    ****************************************************************************************************/
	
	
	$("#btnSearchUser").on("click", function(){
		
		fn_getDeptList();
	});
	
	
 	// 선택한 권한별 메뉴 List 저장하기
	$("#btnSaveRoleInfo").on("click", function(){
	
		// 선택한 권한 정보 List 를 가져온다
		var selectedRoleList = GRID.getSelectedAll(ax5GridViewRole);
		
		
		//if(selectedRoleList.length <= 0){
			
		//	Util.showAlert("선택한 권한 정보 없습니다.");
			
		//}else{
			
			// 권한 정보 가져오기
			var deptInfo = GRID.getSelectedAll(ax5GridViewDept);
			
			if(deptInfo.length <= 0){
				
				alert("선택한 부서 정보가 없습니다.");
				
			}else{
				
				// Parameter 생성
				var param = {};
		    	
		    	param.deptInfo = deptInfo[0];				// 부서 정보
		    	param.roleList = selectedRoleList;			// 선택한 메뉴 목록 정보
				
				var requestUrl = "/mamager/userAuth/updateDeptRoleList.do";
				
				Util.saveRequest(requestUrl, param, function(resultData){
					
					/*if( resultData.resultValue == "N" ){
						alert("솔루션 권한 50개를 초과하였습니다. 기존 솔루션 권한 유저를 일반 사용자로 변경 후 권한 부여를 하세요.");
					}*/
				});
			}
		//}
	});
	
})