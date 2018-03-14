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
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">
    <!-- 先引入 Vue -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="
    background-color: #f0f5fb;;margin: 0 0 0 0 !important;">
<header id="topbar" class="index-topbar" style="background-color: #f0f4fb;border-bottom: 0px solid #e0e0e0;">
    <ol class="breadcrumb pull-left">
        <li class="crumb">生命周期标签</li>
    </ol>
</header>
<div id="app">
    <div class="form-item-group" style="background-color: #fff;height:40px;line-height: 40px;;width:98%;border-bottom: solid 1px #EEEEEE;border-top: solid 1px #EEEEEE;">
        <div style="margin-left: 30px" id="divButton">
            <span style="color: #222222;font-size: 18px;">生命周期标签列表</span>
            <el-button @click="toggleList" style=";float: right;" class="el-icon-document" type="primary" size="mini"></el-button>
            <el-button @click="toggleView" style=";float: right;margin-left: 0px;" class="el-icon-menu" type="primary" size="mini"></el-button>
            <el-button @click="saveLifeCyle" type="primary" style="float: right">新建</el-button>
        </div>
    </div>
    <template style="">
        <%--<el-popover ref="popover5" placement="top" width="160" v-model="visible2">--%>
            <%--<p>确定删除吗？</p>--%>
            <%--<div style="text-align: right; margin: 0">--%>
                <%--<el-button size="mini" type="text" @click="visible2 = false">取消</el-button>--%>
                <%--<el-button type="primary" size="mini" @click="visible2 = false">确定</el-button>--%>
            <%--</div>--%>
        <%--</el-popover>--%>
        <el-table v-loading.body="loading" :data="tableData" style=";width: 98%;margin-top: 20px">
            <el-table-column prop="lifeCycleName" label="生命周期阶段" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="showPriority" label="显示优先级" >
            </el-table-column>
            <el-table-column prop="calculationPriority" label="计算优先级">
            </el-table-column>
            <el-table-column prop="enable" label="是否有效">
            </el-table-column>
            <el-table-column prop="state" label="计算执行状态" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="inNumber" label="参与计算的客户数" >
            </el-table-column>
            <el-table-column prop="outNumber" label="计算结果客户数">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="100">
                <template scope="scope" style="width:100px">
                    <%--<el-button type="text" size="1"   @click="detailsRow(scope.$index,scope.row)">详情</el-button>--%>
                    <%--<el-button type="text" size="1"  @click="editRow(scope.$index,scope.row)">编辑</el-button>--%>
                        <el-dropdown trigger="click">
                            <el-button type="primary" style="padding: 3px 0px;min-width: 70px;background: #37bc9b !important;" >
                                操作<i class="el-icon-caret-bottom el-icon--right"></i>
                            </el-button>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item>
                                    <el-button type="text" size="1"   @click="detailsRow(scope.$index,scope.row)">详情</el-button>
                                </el-dropdown-item>
                                <el-dropdown-item>
                                    <el-button type="text" size="1"  @click="editRow(scope.$index,scope.row)">编辑</el-button>
                                </el-dropdown-item>
                                <el-dropdown-item>
                                    <el-button @click.native.prevent="open2(scope.$index, tableData , scope.row)"
                                               type="text"
                                               size="1" >删除</el-button>
                                </el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                </template>
            </el-table-column>
        </el-table>
        <div class="element-pagination" style="text-align: right;
    padding-right: 25px;margin-right: 100px;">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="size" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
            </el-pagination>
        </div>
    </template>
</div>

</body>
<script>
    $(function() {
        var code_rule;
        return code_rule = new Vue({
            el: '#app',
            data: {
                page: 1,
                size:10,
                tableData: [],
                currentPage:1,
                totalSize:10,
                loading: false,
                visible2: false,
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
                        url: "findLifeCycle",
                        dataType: 'json',
                        method: 'POST',
                        data:{"page":vm.page,"size":vm.size}
                    }).done(function(data) {
                        console.log("data@@@"+data.data);
                        vm.tableData = data.data;
                        vm.currentPage= data.currentPage;
                        vm.totalSize=data.totalSize;
                        vm.loading=false
                    }).error(function(data) {
                        console.log("失败")
                    });
                },
                deleteRow(index, datas,row) {
                    console.log(row.id);
                    $.ajax({
                        url: "deleLifeCycle",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":row.id}
                    }).done(function(data) {
                        console.log("成功")
                        this.init();
                        datas.splice(index, 1);
                    }).error(function(data) {
                        console.log("失败")
                    });
                },
                //初始化分页
                handleSizeChange(val) {
                console.log(`每页`+val+'条');
                size=val;
                this.size=val;
                console.log("size@@@"+size);
                },
                handleCurrentChange(val) {
                console.log(`当前页:`+val);
                this.page=val;
                this.init();
                },
                editRow(index,row){
                    window.location.href = "LifeCycleEdit?lifeCycleId="+row.id;
//                    +row.id
                },
                toggleView(){
                    window.location.href = "combinationChart";
                },
                saveLifeCyle(){
                    window.location.href = "LifeCycleSvae";
                },
                toggleList(){
                    window.location.href = "lifeCycleList";
                },
                detailsRow(index,row){
                    console.log(`detailsRow:`);
                    window.location.href = "LifeCycleDetails?id="+row.id;
                },handleClick(data){
                    console.log(`data:`+data);
                },toggleList(){
                    window.location.href = "lifeCycleList";
                },open2(index, datas,row) {
                    var vm;
                    vm = this;
                    this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    $.ajax({
                        url: "deleLifeCycle",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":row.id}
                    }).done(function(data) {
                        console.log("成功")
                        datas.splice(index, 1);
                        vm.init();
                    }).error(function(data) {
                        console.log("失败")
                    });
                }).catch(() => {
//                        this.$message({
//                        type: 'info',
//                        message: '已取消删除'
//                    });
                });
                }

            }
        });
    });
</script>
</html>
