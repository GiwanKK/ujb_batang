"use strict";

var LINECHART = {
		
		

		dashBoard_common_lineChart : function(displayDivTagID, params) {
			// Themes begin
	    	am4core.useTheme(am4themes_dark);
	    	am4core.useTheme(am4themes_animated);
	    	// Themes end
	    	
	    	// Create chart instance
	    	var chart = am4core.create(displayDivTagID, am4charts.XYChart);
	    	console.log("params.data : " ,params.data)
	    	chart.data = params.data;
	    	if(params.padding.top) chart.paddingTop = params.padding.top;
	    	
	    	//colors
	    	if(params.colorList) chart.colors.list = params.colorList
	    	
	    	// Add legend
	    	chart.legend = new am4charts.Legend();
	    	if(params.legend.position) chart.legend.position = params.legend.position;
	    	if(params.legend.useDefaultMarker) chart.legend.useDefaultMarker = params.legend.useDefaultMarker;
			
			var markerTemplate = chart.legend.markers.template;
			if(params.marker.width) markerTemplate.width = params.marker.width;
			if(params.marker.height) markerTemplate.height = params.marker.height;
			if(params.legend.fontSize) chart.legend.labels.template.fontSize = params.legend.fontSize;
			if(params.legend.maxHeight) chart.legend.maxHeight = params.legend.maxHeight;
	    	// Add cursor
	    	chart.cursor = new am4charts.XYCursor();
	    	
	    	// Create axes
	    	var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
	    	if ("minGridDistance" in params.dateAxis) dateAxis.renderer.minGridDistance = params.dateAxis.minGridDistance;
	    	if (params.dateAxis.fontSize) dateAxis.renderer.fontSize = params.dateAxis.fontSize;
	    	if (params.dateAxis.dateFormats == "year"){
	    	dateAxis.dateFormats.setKey("year", params.dateAxis.setKey);
	    	}else{
	    		dateAxis.dateFormats.setKey("month", params.dateAxis.setKey);
	    		dateAxis.periodChangeDateFormats.setKey("month", params.dateAxis.setKey); 
	    	}
	    	//valueAxis.title
	    	var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
			//valueAxis.layout = "absolute";
			if (params.valueAxis.renderer.fontSize) valueAxis.renderer.fontSize = params.valueAxis.renderer.fontSize;
			if ("rotation" in params.valueAxis.title) valueAxis.title.rotation = params.valueAxis.title.rotation;    
			if (params.valueAxis.title.text) valueAxis.title.text = params.valueAxis.title.text;
			if (params.valueAxis.title.fontSize) valueAxis.title.fontSize = params.valueAxis.title.fontSize;
			
			if (params.valueAxis.title.align) valueAxis.title.align = params.valueAxis.title.align;
			if (params.valueAxis.title.valign) valueAxis.title.valign = params.valueAxis.title.valign;
			if (params.valueAxis.title.dx) valueAxis.title.dx = params.valueAxis.title.dx;
			if (params.valueAxis.title.dy) valueAxis.title.dy = params.valueAxis.title.dy;
		    
		    function createAxisAndSeries(field, name, bullet) {
		    	 console.log("bullet : "  , bullet)
	    		  var series = chart.series.push(new am4charts.LineSeries());
	    		  series.dataFields.valueY = field;
	    		  series.dataFields.dateX = params.dataFieldsCategory;
	    		  if (params.series.strokeWidth) series.strokeWidth = params.series.strokeWidth;
	    		  series.yAxis = valueAxis;
	    		  series.name = name;
	    		  if (params.series.tooltipText) series.tooltipText = params.series.tooltipText;
	    		  //series.tooltipText = "{name}: {valueY}[/]";
	    		  //series.tensionX = 0.8;
	    		  
	    		  //series.tooltip.background.cornerRadius = 20;
	    		  if(params.series.tooltip.backgroundStrokeOpacity) series.tooltip.background.strokeOpacity = params.series.tooltip.backgroundStrokeOpacity;
	    		  if(params.series.tooltip.pointerOrientation) series.tooltip.pointerOrientation = params.series.tooltip.pointerOrientation;
	    		  //series.tooltip.label.minWidth = 40;
	    		  //series.columns.template.fontSize = 12;
	    		  if(params.series.tooltip.labelMinWidth) series.tooltip.label.minWidth = params.series.tooltip.labelMinWidth;
	    		  if(params.series.tooltip.labelMinHeight) series.tooltip.label.minHeight = params.series.tooltip.labelMinHeight;
	    		  if(params.series.tooltip.labelTextAlign) series.tooltip.label.textAlign = params.series.tooltip.labelTextAlign;
	    		  if(params.series.tooltip.labelTextValign) series.tooltip.label.textValign = params.series.tooltip.labelTextValign;
	    		  
	    		 
	    		  if(bullet){
		    		  switch(bullet) {
		    		    case "triangle":
		    		      var bullet = series.bullets.push(new am4charts.Bullet());
		    		      bullet.width = 12;
		    		      bullet.height = 12;
		    		      bullet.horizontalCenter = "middle";
		    		      bullet.verticalCenter = "middle";
		    		      //bullet.fill = am4core.color("#fff");
		    		      var triangle = bullet.createChild(am4core.Triangle);
		    		      //triangle.stroke = interfaceColors.getFor("background");
		    		      triangle.strokeWidth = 2;
		    		      triangle.direction = "top";
		    		      triangle.width = 10;
		    		      triangle.height = 10;
		    		      break;
		    		    case "rectangle":
		    		      var bullet = series.bullets.push(new am4charts.Bullet());
		    		      bullet.width = 10;
		    		      bullet.height = 10;
		    		      bullet.horizontalCenter = "middle";
		    		      bullet.verticalCenter = "middle";
		    		      //bullet.fill = am4core.color("#fff");
		    		      
		    		      var rectangle = bullet.createChild(am4core.Rectangle);
		    		      //rectangle.stroke = interfaceColors.getFor("background");
		    		      rectangle.strokeWidth = 2;
		    		      rectangle.width = 10;
		    		      rectangle.height = 10;
		    		      break;
		    		    default:
		    		      var bullet = series.bullets.push(new am4charts.CircleBullet());
		    		      //bullet.circle.stroke = interfaceColors.getFor("background");
		    		      bullet.circle.strokeWidth = 2;
		    		      break;
		    		  }
	    		  }else{
	    		  }
	    	};
	    	for (var i = 0; i < params.dataFieldsValue.length; i++){
	    		if(params.name){
	    			if(params.bullet){
	    				createAxisAndSeries(params.dataFieldsValue[i], params.name[i], params.bullet[i]);
	    			}else{
	    				createAxisAndSeries(params.dataFieldsValue[i], params.name[i], "");
	    			}
	    		}else{
	    		}
	    	}
	    	//createAxisAndSeries(configData.dataFieldsValue1, "일", "triangle");
		}
		
		
		
}