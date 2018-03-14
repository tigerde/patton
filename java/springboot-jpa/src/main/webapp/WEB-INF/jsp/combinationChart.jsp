<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2017/8/26
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        /*---  基础色  ---*/
        /*---  SCRM 主色  ---*/
        /*---  SCRM 文字色  ---*/
        /*---  SCRM 扩展色  ---*/
        /*---  基础色  ---*/
        /*---  SCRM 主色  ---*/
        /*---  SCRM 文字色  ---*/
        /*---  SCRM 扩展色  ---*/
        .el-button {
            height: 42px;
            min-width: 88px;
            border: none;
        }
        .el-button--primary {
            background: #055EB6 !important;
        }
        .el-button--primary:hover {
            background: #055EB6 !important;
        }
        .el-button--default {
            border: solid 1px #EEEEEE;
        }
        .row-action-btn, .row-action-btn.el-button--primary {
            background: #37bc9b !important;
            height: 36px;
            min-width: 72px;
        }
        .row-action-btn:hover, .row-action-btn.el-button--primary:hover {
            background: #37bc9b !important;
        }
        .btn.btn-main {
            width: 72px;
            height: 36px;
            background: #055EB6;
            color: #FFFFFF;
            border-radius: 5px;
        }
        /*---  基础色  ---*/
        /*---  SCRM 主色  ---*/
        /*---  SCRM 文字色  ---*/
        /*---  SCRM 扩展色  ---*/
        /*---  基础色  ---*/
        /*---  SCRM 主色  ---*/
        /*---  SCRM 文字色  ---*/
        /*---  SCRM 扩展色  ---*/
        .search-form .el-input-group__prepend {
            border: none;
        }
        .search-form .el-input-group__prepend .el-icon-search {
            color: #4A89DC;
        }
        .search-form .search-form-select {
            width: 120px;
        }
        .search-form .el-input__inner {
            height: 42px;
            border: none;
        }
        /*---  基础色  ---*/
        /*---  SCRM 主色  ---*/
        /*---  SCRM 文字色  ---*/
        /*---  SCRM 扩展色  ---*/
        .element-pagination {
            text-align: right;
            margin-top: 20px;
        }
        .element-pagination .el-pagination span {
            line-height: 40px;
        }
        .element-pagination .el-pagination .el-pagination__total {
            font-size: 14px;
        }
        .element-pagination .el-pagination .el-pagination__jump {
            font-size: 14px;
        }
        .element-pagination .el-pagination .el-pagination__jump .el-pagination__editor {
            width: 72px !important;
            height: 38px;
        }
        .element-pagination .el-pagination .el-select .el-input input {
            height: 40px;
        }
        .element-pagination .el-pagination .pagination-btn, .element-pagination .el-pagination .btn-prev, .element-pagination .el-pagination .el-pager .number, .element-pagination .el-pagination .btn-next, .element-pagination .el-pagination .el-icon-more, .element-pagination .el-pagination .btn-quickprev:hover, .element-pagination .el-pagination .btn-quicknext:hover {
            width: 40px;
            height: 40px;
            border-radius: 3px;
            line-height: 40px;
            border: none;
        }
        .element-pagination .el-pagination .btn-prev {
            margin-right: 5px;
        }
        .element-pagination .el-pagination .el-pager .number {
            margin: 0px 5px;
        }
        .element-pagination .el-pagination .el-pager .number.active {
            background-color: #055EB6;
        }
        .element-pagination .el-pagination .btn-next {
            margin-left: 5px;
        }
        .el-table {
            border-radius: 5px;
            background-color: #F0F4FB;
        }
        .el-table thead tr th {
            height: 48px;
            background: #FFFFFF;
        }
        .el-table thead tr th .cell {
            background: #FFFFFF;
            padding-left: 10px;
            padding-right: 10px;
        }
        .el-table tbody tr td {
            height: 48px;
            background-color: #FFFFFF;
        }
        .el-table tbody tr td .cell {
            background-color: #FFFFFF;
            word-break: normal;
            padding-left: 10px;
            padding-right: 10px;
        }
        .el-table tbody tr:hover td {
            background-color: #eef1f6;
        }
        .el-table tbody tr:hover td .cell {
            background-color: #eef1f6;
        }

    </style>
    <style type="text/css">
        .el-table tbody tr td .cell {
            overflow:hidden;
            white-space:nowrap;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            -moz-text-overflow: ellipsis;
            -webkit-text-overflow: ellipsis;
        }
    </style>
    <style>
        .topbar{
            height: 50px;
            line-height: 40px;
            padding: 10px 20px 10px 40px !important;
            min-height: 50px !important;
            background-color: #f0f4fb;
            border-bottom: none;
            z-index: 2;
            position: relative;
            width: 100%;
            background: #fafafa;
        }
        .breadcrumb {
            padding: 1px 1px 0 0 !important;
            position: relative;
            margin-bottom: 0;
            font-size: 12px;
            border-radius: 0;
            background-color: transparent;
            list-style: none;
        }
        .pull-left {
            float: left !important;
        }
        ul, ol {
            margin-top: 0;
        }
        ol {
            display: block;
            -webkit-margin-before: 1em;
            -webkit-margin-after: 1em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            -webkit-padding-start: 40px;
            list-style-type: decimal;
        }
        #topbar .breadcrumb .crumb {
            color: #222222;
            font-size: 18px;
        }
        .breadcrumb > li {
            display: inline-block;
        }
        a {
            color: #4a89dc;
            text-decoration: none;
        }
        a {
            background: transparent;
        }
        img {
            cursor: pointer;
        }
    </style>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <%--<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">--%>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">
    <!-- 先引入 Vue -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body style="
    background-color: #f0f5fb;;margin: 0 0 0 0 !important;">
<div id="app">
    <header id="topbar" class="index-topbar" style="background-color: #f0f4fb;border-bottom: 0px solid #e0e0e0;">
        <ol class="breadcrumb pull-left">
            <li class="crumb">生命周期标签</li>
        </ol>
    </header>
<div class="form-item-group" style="background-color: #fff;height:40px;line-height: 40px;;width:95%;border-bottom: solid 1px #EEEEEE;border-top: solid 1px #EEEEEE;">
    <div style="margin-left: 30px" id="divButton">
        <span style="color: #222222;font-size: 18px;">生命周期标签报表</span>
        <el-button @click="toggleList" style=";float: right;" class="el-icon-document" type="primary" size="mini"></el-button>
    </div>
</div>
</div>
<div id="container" style="min-width: 310px; height: 95%;width: 95%;margin-top: 15px"></div>
</body>
<script>
    $(function() {
//        var Main = {
//            methods: {
//                toggleList(){
//                    window.location.href = "lifeCycleList";
//                }
//            }
//        }
//        var Ctor = Vue.extend(Main);
//        new Ctor().$mount('#app');

        $.ajax({
            url:"findReportData",
            type:"GET",
            dataType:"json",
            success:function(msg){
                Highcharts.chart('container', {
                    title: {
                        text: '30天内生命周期标签计算趋势'
                    },
                    xAxis: {
                        categories: msg.categories
                    },
                    yAxis: [{
                        className: 'highcharts-color-0',
                        title: {
                            text: '数量'
                        }
                    }],
                    labels: {
                        items: [{
                            html: '各生命周期数量统计',
                            style: {
                                left: '50px',
                                top: '18px',
                                color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
                            }
                        }]
                    },
                    series: msg.series
                });
            },
            error:function(){
                console.log("失败")
            }
        });
        var code_rule;
        return code_rule = new Vue({
            el: '#app',
            methods: {
                toggleList(){
                    window.location.href = "lifeCycleList";
                }
            }
        });
    });



</script>
</html>
