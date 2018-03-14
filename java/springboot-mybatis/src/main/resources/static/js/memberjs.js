// 基于准备好的dom，初始化echarts实例
$(function(){
	new AccordionMenu();
	new formConfiguration("/queryMemberList",16);

});

function findquery(i){
	// var myChart = echarts.init(document.getElementById('Clustering'));
	// $("#Clustering").empty();
	new clickFormConf("/queryMemberList",i);
	}