var data;
var seriesdata = [];
var timedata = [];
var k = 0;
// 基于准备好的dom，初始化echarts实例

$(function(){
	console.log("进菜单")
	new AccordionMenu();
	var myChart = echarts.init(document.getElementById('Clustering'));
	console.log("进来")
	$.ajax({
		url:"/springBootJsp/queryIndexList",
		data:{"type":1},
		type:"POST",
		dataType:"json",
		success:function(msg){
			option = {
				timeline: {
					top: 'center',
					right: 20,
					height: 200,
					width: 2,
					inverse: true,
					playInterval: 2500,
					symbol: 'none',
					orient: 'vertical',
					axisType: 'category',
					autoPlay: false,
					label: {
						normal: {
							show: true
						},
						position: 'left'
					},
					data: timedata
				},
				baseOption: {
					title: {
						text: $("#tdName").text(),
//                    sublink: 'https://github.com/ecomfe/echarts-stat',
						left: 'center'
					},
					xAxis: {
						type: 'value',
						name: '（会员积分）',
						nameGap: 4
					},
					yAxis: {
						type: 'time',
						name: '（关注时间）',
						nameGap: 15
					},
					series: [{
						type: 'scatter'
					}]
				},
				options: seriesdata
			};

			data = msg;
			$.each(data, function (j, n) {
				console.log("j:"+j);
				option.options.push(getOption(n, n.pointsInCluster.length+1));
			});
			for (var i=3;i<6;i++)
			{
				option.timeline.data.push( i+ '类');
			}
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		},
		error:function(){
			console.log("失败")
		}


	});
});



function getOption(result, k) {
	var centroids = result.centroids;
	var ptsInCluster = result.pointsInCluster;
	var color = ['#2C3E50', '#E74C3C', '#2980B9', '#D96C0F', '#A60400', '#5A0300', '#C7B773', '#B1C2B3', '#778691', '#176D8C', '#23A0BF'];
	var series = [];
	for (i = 0; i < k; i++) {
		//console.log(i);
		series.push({
			name:  '簇:'+i+',散度',
			type: 'scatter',
			animation: false,
			data: ptsInCluster[i],
			markPoint: {
				symbolSize: 29,
				label: {
					normal: {
						show: false
					},
					emphasis: {
						show: true,
						position: 'top',
						formatter: function (params) {
							return Math.round(params.data.coord[0] * 100) / 100 + '  ' +
								Math.round(params.data.coord[1] * 100) / 100 + ' ';
						},
						textStyle: {
							color: '#000'
						}
					}
				},
				itemStyle: {
					normal: {
						opacity: 0.7
					}
				},
				data: [{
					coord: centroids[i]
				}]
			}
		});
	}

	return {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross'
			}
		},
		series: series,
		color: color
	};
}

function findquery(i){
	var myChart = echarts.init(document.getElementById('Clustering'));
	$.ajax({
		url:"/springBootJsp/queryIndexList",
		data:{"type":i},
		type:"POST",
		dataType:"json",
		success:function(msg){
			option = {
				timeline: {
					top: 'center',
					right: 20,
					height: 200,
					width: 2,
					inverse: true,
					playInterval: 2500,
					symbol: 'none',
					orient: 'vertical',
					axisType: 'category',
					autoPlay: false,
					label: {
						normal: {
							show: true
						},
						position: 'left'
					},
					data: []
				},
				baseOption: {
					title: {
						text: $("#tdName").text(),
//                    sublink: 'https://github.com/ecomfe/echarts-stat',
						left: 'center'
					},
					xAxis: {
						type: 'value',
						name: '（消息数量）',
						nameGap: 4
					},
					yAxis: {
						type: 'time',
						name: '（关注时间）',
						nameGap: 15
					},
					series: [{
						type: 'scatter'
					}]
				},
				options: []
			};

			data = msg;
			$.each(data, function (j, n) {
				console.log("j:"+j);
				option.options.push(getOption(n, n.pointsInCluster.length+1));
			});
			for (var i=3;i<6;i++)
			{
				option.timeline.data.push( i+ '类');
			}
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		},
		error:function(){
		}

	});

	$.ajax({
		url:"/springBootJsp/findProp",
		data:{"type":i},
		type:"POST",
		dataType:"json",
		success:function(msg){

			if (i==2){
				$("#tdName").text("社群流量三天消息数量");
			}else if (i==3){
				$("#tdName").text("社群流量本周消息数量");
			}else if (i==1){
				$("#tdName").text("社群流量昨天的消息数量");
			}
			console.log(msg.proportion+"")
			// var num=msg.proportion*100;
			// num=num.toFixed(2);
			$("#tdNumber").text(msg.proportion+"%");
			$("#tdDate").text(msg.create_time);
		},
		error:function(){
			console.log("失败")
		}
	});
	}