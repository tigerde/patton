<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2017/8/1
  Time: 上午9:21
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+ path + "/";
    String serverPort=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<html>
<head>
    <meta charset="UTF-8">
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
    <style type="text/css">
        .el-table tbody tr td .cell {
            overflow:hidden;
            white-space:nowrap;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            -moz-text-overflow: ellipsis;
            -webkit-text-overflow: ellipsis;
        }
        .grid-content{
            font-size: 14px;
        }
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
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">
    <!-- 先引入 Vue -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="
    background-color: #f0f5fb;;margin: 0 0 0 0 !important;">
<div id="app" >
    <header id="topbar" class="index-topbar" style="background-color: #f0f4fb;">
        <div style="height: 0px;
    border-bottom: 0px solid #e0e0e0 !important;display: block;">
            <ol class="breadcrumb pull-left">
                <li class="crumb back-btn-scrm">
                    <a id="back" href="lifeCycleList"><img src="${pageContext.request.contextPath}/images/back.png" alt="Back"></a> 生命周期标签详情
                </li>
            </ol>
            <el-button @click="editRow" style="float: right;margin-right: 2%;margin-top: 0.35%;">编辑</el-button>
            <div class="pull-right">
            </div>
        </div>
    </header>
    <%--<div class="form-item-group" style="background-color: #fff;height:40px;line-height: 40px;;width:98%;border-bottom: solid 1px #EEEEEE;border-top: solid 1px #EEEEEE;">--%>
        <%--<div style="margin-left: 30px" id="divButton">--%>
            <%--<span style="color: #222222;font-size: 18px;">生命周期标签详情</span>--%>
        <%--</div>--%>
    <%--</div>--%>
    <div style="background: #FFFFFF;border-radius: 5px;border: none;width: 98%;margin-top: 0px">
        <el-row :gutter="20">
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>生命周期阶段:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.lifeCycleName}</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>计算周期:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>每天</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>创建人:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.createdBy}</span>
            </div></el-col>
        </el-row>
        <el-row :gutter="20" style="margin-top: 25px">
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>显示优先级:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.showPriority}</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>是否有效:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.status}</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>创建时间:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.time}</span>
            </div></el-col>
        </el-row>
        <el-row :gutter="20" style="margin-top: 25px">
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>计算优先级:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.calculationPriority}</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
                <span>描述:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${tagLifeCycle.description}</span>
            </div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple">
            </div></el-col>
        </el-row>
    </div>
    <div class="form-item-group" style="margin-top: 30px;height:40px;line-height: 40px;;width:98%">
        <div style="margin-left: 30px">
            <span style="color: #222222;font-size: 18px;">属性规则列表</span>
        </div>
    </div>
    <template >
        <el-table v-loading.body="loading" :data="tableData" style="width: 98%;margin-top: 50px">
            <el-table-column prop="id" label="规则编号" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="attributeNameText" label="属性" >
            </el-table-column>
            <el-table-column prop="ruleOperator" label="运算符">
            </el-table-column>
            <el-table-column prop="attributeValueText" label="值">
            </el-table-column>
            <el-table-column prop="relationalSymbol" label="关系符" :show-overflow-tooltip="true">
            </el-table-column>
        </el-table>
        <%--<div class="block" style="text-align: right;--%>
    <%--padding-right: 25px;">--%>
            <%--<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="size" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">--%>
            <%--</el-pagination>--%>
        <%--</div>--%>
    </template>
</div>
<div class="form-item-group" style="margin-top: 30px;height:40px;line-height: 40px;;width:98%">
    <div style="margin-left: 30px">
        <span style="color: #222222;font-size: 18px;">生命周期标签计算日志</span>
    </div>
</div>
<div id="log">
    <template>
        <el-table v-loading.body="loading" :data="tableData2" style="width: 98%;margin-top: 50px">
            <el-table-column prop="id" label="计算序号" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="createTime" label="计算完成时间" >
            </el-table-column>
            <el-table-column prop="calculationType" label="计算方式">
            </el-table-column>
            <el-table-column prop="isSucceesText" label="计算结果">
            </el-table-column>
            <el-table-column prop="inNumber" label="参与计算客户数量">
            </el-table-column>
            <el-table-column prop="outNumber" label="计算结果客户数量" :show-overflow-tooltip="true">
            </el-table-column>
        </el-table>
        <%--<div class="block" style="text-align: right;--%>
        <%--padding-right: 25px;">--%>
        <%--<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="size" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">--%>
        <%--</el-pagination>--%>
        <%--</div>--%>
    </template>
</div>

</body>
<script>
    function getUrlParam(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r!=null) return unescape(r[2]); return null; //返回参数值
    }
    $(function() {
        var code_rule;
        return code_rule = new Vue({
            el: '#app',
            data: {
//                page: 1,
//                size:10,
                id:1,
                tableData: [],
//                currentPage:1,
//                totalSize:10,
                loading: false
            },
            created: function() {
                return this.init();
            },
            methods: {
                init: function() {
                    var vm;
                    vm = this;
                    vm.loading=true;
                    return $.ajax({
                        url: "LifeCycleDetailsData",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":getUrlParam("id")}
                    }).done(function(data) {
                        console.log("data@@@"+data.data);
                        vm.tableData = data.tabledata2;
                        vm.loading=false
                    }).error(function(data) {
                        console.log("失败")
                    });
                },
                editRow(){
                    window.location.href = "LifeCycleEdit?lifeCycleId="+getUrlParam("id");
                },
            }
        });
    });
</script>
<script>
    $(function() {
        var code_log;
        return code_log = new Vue({
            el: '#log',
            data: {
                id:1,
                tableData2: [],
                loading: false
            },
            created: function() {
                return this.init();
            },
            methods: {
                init: function() {
                    var vm;
                    vm = this;
                    vm.loading=true;
                    return $.ajax({
                        url: "LifeCycleDetailsData",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":getUrlParam("id")}
                    }).done(function(data) {
                        console.log("data@@@"+data.data);
                        vm.tableData2= data.tabledata;
                        vm.loading=false
                    }).error(function(data) {
                        console.log("失败")
                    });
                }
            }
        });
    });
</script>
</html>
