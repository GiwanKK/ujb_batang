var loading = $.loading();

var layerList = [];
var sourceList = [];

$(function(){
	document.body.style.zoom = "100%";
	
	//민원실 현황 데이터 함수
	function fn_complainStatus(option){
		
		var param = {};
		if (option == "Week"){
			param.moreWeek = $("#moreCntWeek").val();
			param.option = option
		}else if (option == "Month"){
			param.moreMonth = $("#moreCntMonth").val();
			param.option = option
		}
		
		var url = "/dashBoard/complain/complainStatusData.do";
		
		Util.request(url, param, function(resultData){
			//시정 뉴스 함수 호출
				fn_complainNewsData(resultData);
			
		})
	}
	fn_complainStatus();
	
	
	
	//시정 뉴스 데이터
	function fn_complainNewsData(result){
		$("#newsList").html('');
		//$("#newsList_1").html('');
		//$("#newsList_2").html('');
		var html = '';
		
		var data = result.complainNews
		data.forEach(function(item, index){
			html += '<li>';
			if( index == 0 ){
				html += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
			}else{
				html += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
				
			}
		})
		
		if( result.complainNews1 ){
			var html1 = '';
			var data1 = result.complainNews1 ;
			if(data1.length == 0){
				html1 += '<li><a class = "noneNews">해당 날짜에 뉴스가 없습니다.</a></li>'
			}else{
				data1.forEach(function(item, index){
					html1 += '<li>';
					if( index == 0 ){
						html1 += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
					}else{
						html1 += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
					} 
					if(index == 49){
						html1 += '<button id = "moreWeek" style="                 '
						html1 +=   ' width: 100%;               '
						html1 +=   ' height: 40px;              '
						html1 +=   ' background: #333;          '
						html1 +=   ' color: white;              '
						html1 +=   ' border: 1px solid white;   '
						html1 +=	'"><span>더보기 +</span></button>'
					}
				})
			}
			$("#weekNews").append(html1);

			
			$("#moreWeek").on("click", function(){
				var cnt = Number($("#moreCntWeek").val()) + 50;
				$("#moreCntWeek").val(cnt);
				var option = "Week";
				fn_complainStatus(option);
				$(this).remove();
			});
		}
		
		if( result.complainNews2 ){
			var html2 = '';
			var data2 = result.complainNews2; 
		if(data2.length == 0){
			html2 += '<li><a class = "noneNews">해당 날짜에 뉴스가 없습니다.</a></li>'
		}else{
		data2.forEach(function(item, index){
			html2 += '<li>';
			if( index == 0 ){
				html2 += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
			}else{
				html2 += '<li><a href="'+item.newsUrl+'" target="_blank">'+item.title+'<br /><span class="news_date">['+item.sort+'] '+item.date+'</span></a></li>';
				
			}
			if(index == 49){
				html2 += '<button id = "moreMonth" style="                 '
				html2 +=   ' width: 100%;               '
				html2 +=   ' height: 40px;              '
				html2 +=   ' background: #333;          '
				html2 +=   ' color: white;              '
				html2 +=   ' border: 1px solid white;   '
				html2 +=	'"><span>더보기 +</span></button>'
			}
		})
		}
		$("#monthNews").append(html2);

		$("#moreMonth").on("click", function(){
			var cnt = Number($("#moreCntMonth").val()) + 50;
			$("#moreCntMonth").val(cnt);
			var option = "Month";
			fn_complainStatus(option);
			$(this).remove();
		});
		}
		
		$("#newsList").append(html);
		$("#did_title").html("금일 시정 뉴스" + "(" +data[0].date+ ")");
		$("#did_title_1").html("일주일 시정 뉴스");
		$("#did_title_2").html("한달 시정 뉴스");
		
	}
		
})
