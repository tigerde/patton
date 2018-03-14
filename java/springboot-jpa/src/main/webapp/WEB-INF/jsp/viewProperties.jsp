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
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <!-- 先引入 Vue -->
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
//        $(function() {
//            $.ajax({
//                url:"/viewList",
//                type:"POST",
//                data:{"id":getUrlParam("id"),"page":1,"size":10},
//                dataType:"json",
//                success:function(msg){
//                    dataList=msg;
//                    console.log(dataList);
//                    console.log(dataList.viewListVOs);
//                    alert(dataList.viewListVOs);
//                },
//                error:function(){
//                    console.log("失败")
//                }
//            });
//        });
    </script>
</head>
<body style="
    background-color: #f0f5fb;;margin: 0 0 0 0 !important;">
<jsp:include page="menu.jsp"/>
<%--<div id="app">--%>
    <%--<el-button @click="visible = true">按钮</el-button>--%>
    <%--<el-dialog v-model="visible" title="Hello world">--%>
        <%--<p>欢迎使用 Element</p>--%>
    <%--</el-dialog>--%>
<%--</div>--%>
<div id="app">
    <template>
        <el-table :data="tableData" style="margin-left: 294px;width: 70%">
            <el-table-column prop="attributeName" label="属性名称" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="attributeNameDesc" label="描述" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="dataType" label="数值类型">
            </el-table-column>
            <el-table-column prop="valueRange" label="取值范围">
            </el-table-column>
            <el-table-column prop="rate" label="完整率">
            </el-table-column>
            <el-table-column prop="updateRate" label="更新频率" >
            </el-table-column>
            <el-table-column prop="updateAt" label="最新更新时间" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="customerUpdateRate" label="更新率">
            </el-table-column>
        </el-table>
            <%--<el-table :data="tableData" style="margin-left: 328px;width: 70%">--%>
                <%--<el-table-column prop="date" label="日期" width="180">--%>
                <%--</el-table-column>--%>
                <%--<el-table-column prop="name" label="姓名" width="180">--%>
                <%--</el-table-column>--%>
                <%--<el-table-column prop="address" label="地址">--%>
                <%--</el-table-column>--%>
            <%--</el-table>--%>
        <div class="block" style="text-align: right;
    padding-right: 50px;">
            <el-pagination @size-change="h      andleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
            </el-pagination>
        </div>
    </template>
</div>
<jsp:include page="pagination.jsp"/>
</body>
<%--<script>--%>
    <%--function getUrlParam(name)--%>
    <%--{--%>
        <%--var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象--%>
        <%--var r = window.location.search.substr(1).match(reg);  //匹配目标参数--%>
        <%--if (r!=null) return unescape(r[2]); return null; //返回参数值--%>
    <%--}--%>
    <%--var dataList;--%>
    <%--var page;--%>
    <%--$(document).ready(function(){--%>
        <%--//todo js code--%>
        <%--$.ajax({--%>
            <%--url:"/viewList",--%>
            <%--type:"POST",--%>
            <%--data:{"id":getUrlParam("id"),"page":1,"size":10},--%>
            <%--dataType:"json",--%>
            <%--success:function(msg){--%>
                <%--dataList=msg;--%>
                <%--//初始化列表--%>
                <%--var Main = {--%>
                    <%--data() {--%>
                        <%--return {--%>
                            <%--tableData: dataList.viewListVOs--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>
                <%--var Ctor = Vue.extend(Main)--%>
                <%--new Ctor().$mount('#app')--%>
                <%--var size=10;--%>
                <%--//初始化分页--%>
                <%--var MainData = {--%>
                    <%--methods: {--%>
                        <%--handleSizeChange(val) {--%>
                            <%--console.log(`每页`+val+'条');--%>
                            <%--size=val;--%>
                        <%--},--%>
                        <%--handleCurrentChange(val) {--%>
                            <%--console.log(`当前页:`+val);--%>
                            <%--findData(val,size);--%>
                        <%--}--%>
                    <%--},--%>
                    <%--data() {--%>
                        <%--return {--%>
                            <%--currentPage: dataList.currentPage,--%>
                            <%--totalSize:dataList.totalSize--%>
<%--//                            totalSize:100--%>
                        <%--};--%>
                    <%--}--%>
                <%--}--%>
                <%--var CtorPage = Vue.extend(MainData)--%>
                <%--new CtorPage().$mount('#pagination')--%>

                <%--addElementDiv()--%>
            <%--},--%>
            <%--error:function(){--%>
                <%--console.log("失败")--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    <%--function findData(page,size) {--%>
        <%--$.ajax({--%>
            <%--url:"/viewList",--%>
            <%--type:"POST",--%>
            <%--data:{"id":getUrlParam("id"),"page":page,"size":size},--%>
            <%--dataType:"json",--%>
            <%--success:function(msg){--%>
                <%--data=msg;--%>
            <%--},--%>
            <%--error:function(){--%>
                <%--console.log("失败")--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>



<%--</script>--%>

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
                page: 1,
                size:10,
                tableData: [],
                currentPage:1,
                totalSize:10,
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
                    var id=getUrlParam("id")
                    console.log(`id:`+id);
                    return $.ajax({
                        url: "viewList",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":id,"page":vm.page,"size":vm.size}
                    }).done(function(data) {
                        console.log("data@@@"+data.data);
                        vm.tableData = data.viewListVOs;
                        vm.currentPage= data.currentPage;
                        vm.totalSize=data.totalSize;
                        vm.loading=false
                    }).error(function(data) {
                        console.log("失败")
                    });
                },
                handleClick(index, row) {
                    console.log(row.customerId);
                    window.location.href = "customerDetails?customerId="+row.customerId;
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
                }

            }
        });
    });
</script>

</html>
