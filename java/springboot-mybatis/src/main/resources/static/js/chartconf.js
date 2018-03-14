function setoption(data,xName,yName) {
	var seriesdata = [];
	var timedata = [];
	var k = 0;
// 指定图表的配置项和数据
	var option = {
		timeline: {
			top: 'center',
			right: 15,
			height: 260,
			width: 50,
			inverse: true,
			playInterval: 2500,
			symbol: 'none',
			orient: 'vertical',
			axisType: 'category',
			autoPlay: false,
			label: {
				normal: {
					show: false
				}
			},
			data: timedata
		},
		baseOption: {
			title: {
				text: $("#tdName").text(),
				//subtext: '消息提及聚类',
				//sublink: '#',
				left: 'center'
			},
			xAxis: {
				name: xName,
				type: 'value'
			},
			yAxis: {
				name: yName,
				type: 'time'
			},
			series: [{
				type: 'scatter'
			}]
		},
		options: seriesdata
	};
//调用执行数据初始化

	//最大分簇及各聚类分簇data提取
	$.each(data,function(i, n) {
		var a = n.cluster.k;
		console.log("预迭代次数"+n.cluster.x)
		console.log("迭代次数"+n.cluster.xr)
		timedata.push({
			value: n.cluster.k  + '簇',
			tooltip: {
				formatter: '分簇：' + n.cluster.k + '<br/>预迭代次数：'+n.cluster.x+'<br/>迭代次数:'+n.cluster.xr
			},
			symbol: 'diamond',
			// 此项的图形的特别设置。
			symbolSize: 16
		});

		if (a > k) {
			k = a;
		}
	});
	//各聚类各簇数据提取及中心点赋值
	$.each(data,
		function(i, n) {
			var centroids = n.centroids;
			var ptsInCluster = n.pointsInCluster;
			var color = ['#2C3E50', '#E74C3C', '#2980B9', '#D96C0F', '#A60400', '#5A0300', '#C7B773', '#B1C2B3', '#778691', '#176D8C', '#23A0BF'];
			// k=0;
			// var a = n.cluster.k;
			// if (a > k) {
			//  k = a;
			// }
			console.log('ak:' + k);
			var series = [];
			console.log('K:' + k);
			for (var j = 0; j < k; j++) {
				console.log('j:' + j);
				console.log('半径:' + n.cluster.r[j]);
				series.push({
					name: '簇:' + j + ',半径:' + n.cluster.r[j],
					type: 'scatter',
					animation: false,
					data: ptsInCluster[j],
					markPoint: {
						symbolSize: 29,
						label: {
							normal: {
								show: false
							},
							emphasis: {
								show: false,
								position: 'top',
								formatter: function(params) {
									return Math.round(params.data.coord[0] * 100) / 100 + '  ' + Math.round(params.data.coord[1] * 100) / 100 + ' ';
								},
								textStyle: {
									color: '#000'
								}
							}
						},
						itemStyle: {
							emphasis: {
								opacity: 0.8
							}
						},
						data: [{
							coord: centroids[j]
						}]
					}
				});

			}

			seriesdata.push({
				tooltip: {
					show: true,
					// trigger: 'axis',
					axisPointer: {
						type: 'cross'
					}
				},
				series: series,
				color: color
			});
		});
	var chart = echarts.init(document.getElementById('Clustering'));
	// 使用刚指定的配置项和数据显示图表。
	chart.setOption(option);
}
function findPorp(url,i,Yesterday,threeDays,week,type) {
	console.log("进porp")
	$.ajax({
		url:url,
		data:{"type":i},
		type:"POST",
		dataType:"json",
		success:function(msg){

			if (i==type[1]){
				$("#tdName").text(threeDays);
			}else if (i==type[2]){
				$("#tdName").text(week);
			}else if (i==type[0]){
				$("#tdName").text(Yesterday);
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
