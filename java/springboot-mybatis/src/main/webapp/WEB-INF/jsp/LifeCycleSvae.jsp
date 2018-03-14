<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2017/8/17
  Time: 上午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">
    <!-- 先引入 Vue -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/theme/admin-designs/assets/skin/default_skin/css/theme.css">

    <style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style>
    <style type="text/css">
        .input-count[data-v-07d85f2e] {
            display: inline-block;
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
    <style type="text/css">
        .input-style{
            width: 500px;
            height: 36px;
            color: #de5748;
            margin-left: 10px;
            line-height: 36px;
            position: relative;
            font-size: 14px;
        }
        .span—color{
            color: #de5748;
            margin-left: 10px;
        }
        .radius {
            width: 260px;
            height: 50px;
            border-radius: 10px;
            margin:0 auto;
            border:1px solid #bfcbd9;
            margin-top: 10px;
        }
        .idCss{

        }

        .spanId{

        }
    </style>

</head>
<body>
<header id="topbar" class="index-topbar" style="background-color: #f0f4fb;border-bottom: 0px solid #e0e0e0;">
    <ol class="breadcrumb pull-left">
        <li class="crumb">生命周期标签</li>
    </ol>
</header>
<div id="app" style="background: #FFFFFF;border-radius: 5px;border: none;height: 100%">
    <el-form ref="LifeCycleSvaeForm" :model="form" label-width="100px">
        <%--弹窗一--%>
        <el-dialog :visible.sync="dialogleVisible" size="300">
            <el-row :gutter="20">
                <el-col :span="12"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                        <el-button style=" width: 120px;height: 36px;font-size: 14px;" @click="dialogTableVisible = true">选择属性</el-button>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple">
                        <el-select v-model="rule.ruleOperator" @change="changeSelect" placeholder="选择运算符" style=" width: 120px;height: 36px;font-size: 14px;">
                            <el-option label="=" value="="></el-option>
                        </el-select>
                </div></el-col>
            </el-row>

            <el-row :gutter="20" style="margin-top: 10px">
                <el-col :span="12"><div class="grid-content bg-purple">

                        <el-select v-model="rule.attributeValue" @change="changeSelect2" placeholder="选择值" style=" width: 120px;height: 36px;font-size: 14px;">
                            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-select>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple">
                        <el-select v-model="rule.relationalSymbol" @change="changeSelect3" placeholder="选择关系符" style=" width: 120px;height: 36px;font-size: 14px;">
                            <el-option label="and" value="and"></el-option>
                            <el-option label="or" value="or"></el-option>
                        </el-select>
                </div></el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="12" :offset="6"><div class="grid-content bg-purple"></div></el-col>
            </el-row>
            <div class="radius">
                <div style="margin-left: 8px;">
                    <span id="lifeCycleName"></span>
                </div>
                <div style="margin-left: 8px;">
                    <span id="ruleOperator"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="attributeValue"></span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="relationalSymbol"></span>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
            <el-button @click="dialogCancel">取 消</el-button>
            <el-button type="primary" @click="dialogSubmit">确 定</el-button>
  </span>
        </el-dialog>

        <%--弹窗2--%>
        <el-dialog title="属性目录列表" :visible.sync="dialogTableVisible" size="large">
            <el-tree :data="data" :default-expand-all="true" @node-click="handleNodeClick" style="width: 20%;float:left;height:250px;line-height:250px;overflow:auto;overflow-x:hidden;"></el-tree>
            <el-table :data="gridData" style="width: 75%;margin-left: 200px">
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
                <el-table-column prop="updateAt" label="最近更新时间" :show-overflow-tooltip="true">
                </el-table-column>
                <el-table-column prop="customerUpdateRate" label="更新率">
                </el-table-column>
                <el-table-column
                        label="操作">
                    <template scope="scope">
                        <el-button @click="handleClick(scope.$index, scope.row)" type="text" size="small">选中</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div style="text-align: right;
    padding-right: 15px;">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="totalSize">
            </el-pagination>
            </div>
        </el-dialog>

        <%--属性--%>
            <el-row :gutter="20">
                <el-col :span="12"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="生命周期阶段" class="input-style">
                        <el-input v-model="form.lifeCycleName">
                        </el-input>
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="10"><div class="grid-content bg-purple">
                    <span class="span—color" style="line-height: 40px;">必填</span>
                </div></el-col>
            </el-row>

            <el-row :gutter="20">
                <el-col :span="12"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="显示优先级" class="input-style">
                        <el-input v-model="form.showPriority"></el-input>
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="10"><div class="grid-content bg-purple">
                    <span class="span—color" style="line-height: 40px;">必填</span>
                </div></el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="12"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="计算优先级" class="input-style">
                        <el-input v-model="form.calculationPriority"></el-input>
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="10"><div class="grid-content bg-purple">
                    <span class="span—color" style="line-height: 40px;">必填</span>
                </div></el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="3"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="计算周期" class="input-style">
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple">
                    <span class="" style="line-height: 40px;font-size: 14px">每天</span>
                </div></el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="12"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="是否有效">
                        <el-select v-model="form.enable" placeholder="请选择是否有效" style=" width: 400px;height: 36px;color: #de5748;margin-left: 10px;line-height: 36px;position: relative;font-size: 14px;">
                            <el-option label="是" value="1"></el-option>
                            <el-option label="否" value="0"></el-option>
                        </el-select>
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="10"><div class="grid-content bg-purple">
                    <span class="span—color" style="line-height: 40px;">必填</span>
                </div></el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="10"><div class="grid-content bg-purple">
                    <%--<el-form-item>--%>
                    <el-form-item label="描述" class="input-style">
                        <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="form.description">
                    </el-form-item>
                    <%--</el-form-item>--%>
                </div></el-col>
                <el-col :span="12"><div class="grid-content bg-purple">
                </div></el-col>
            </el-row>
        <div class="form-item-group" style="padding-top: 25px;padding-bottom: 100px;border-bottom: solid 1px #EEEEEE;border-top: dashed 1px #EEEEEE;">
                <div style="margin-left: 30px" id="divButton">
                    <span style="color: #222222;font-size: 18px;">属性规则列表</span>
                    <el-button type="primary"  @click="dialogleVisible = true" style="margin-left: 10px;height: 40px">添加</el-button>
                </div>
            <%--<el-button type='primary' icon='delete'></el-button>--%>
            <%--<div style='margin-top: 30px;margin-left: 80px;float: left;'>--%>
                <%--<span style='font-size: 14px;color: #48576a;'>1、</span>--%>
            <%--</div>--%>
            <%--<div style='width: 340px;height: 50px;border-radius: 10px;border: 1px solid #bfcbd9;margin-top: 20px;margin-left: 115px;'>--%>
                <%--<div style='margin-left: 8px;margin-top: 3px;'>--%>
                    <%--<span>属性 : </span><span>"客户形态"</span>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <%--<span>运算符 : </span><span>"="</span>--%>
                <%--</div>--%>
                <%--<div style='margin-left: 8px;;margin-top: 3px;'>--%>
                    <%--<span>值 : </span><span>"已识别"</span>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <%--<span>关系符 : </span><span>"且"</span>--%>
                <%--</div>--%>

            <%--</div>--%>
        </div>
        <el-form-item>
            <el-button type="primary" @click="onSubmit(form)">立即创建</el-button>
            <el-button @click="onCancel">取消</el-button>
        </el-form-item>
    </el-form>
</div>
</body>
<script>
    function getUrlParam(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r!=null) return unescape(r[2]); return null; //返回参数值
    }

    function obj2string(o){
        var r=[];
        if(typeof o=="string"){
            return "\""+o.replace(/([\'\"\\])/g,"\\$1").replace(/(\n)/g,"\\n").replace(/(\r)/g,"\\r").replace(/(\t)/g,"\\t")+"\"";
        }
        if(typeof o=="object"){
            if(!o.sort){
                for(var i in o){
                    r.push(i+":"+obj2string(o[i]));
                }
                if(!!document.all&&!/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)){
                    r.push("toString:"+o.toString.toString());
                }
                r="{"+r.join()+"}";
            }else{
                for(var i=0;i<o.length;i++){
                    r.push(obj2string(o[i]))
                }
                r="["+r.join()+"]";
            }
            return r;
        }
        return o.toString();
    }

    function classA() {
        var ruleEntity={
            ruleOperator : '',
            attributeValue : '',
            relationalSymbol : '',
            attributeName : '',
            attributeId : ''
        }
        return ruleEntity;
    }
    var rules=new Array();
    $(function() {
        var code_rule;
        return code_rule = new Vue({
            el: '#app',
            data: {
                id:9,
                page: 1,
                size:10,
                currentPage:1,
                totalSize:10,
                loading: false,
                data:[],
                gridData: [],
                clearable:false,
                form: {
                    lifeCycleName: '',
                    showPriority: '',
                    calculationPriority: '',
                    enable: '',
                    ruleList:[],
                    attributeValueId : '',
                    textarea:'',
                    runCycle:1
                },
                rule:{
                    ruleOperator : '',
                    attributeValue : '',
                    relationalSymbol : '',
                    attributeName : '',
                    attributeId : ''
                },
                dialogTableVisible: false,
                dialogleVisible : false,
                options: [],
                value: '',
            },
            created: function() {
                return this.init();
            },
            methods: {
                init: function() {
                    var vm;
                    vm = this;
                    console.log(`id:`+vm.id);
                    vm.loading=true;
//                    vm.id=getUrlParam("id")
                    return $.ajax({
                        url: "viewList",
                        dataType: 'json',
                        method: 'POST',
                        data:{"id":vm.id,"page":vm.page,"size":vm.size}
                    }).done(function(data) {
                        console.log("data@@@"+data.data);
                        vm.gridData = data.viewDataVO.viewListVOs;
                        vm.currentPage= data.viewDataVO.currentPage;
                        vm.totalSize=data.viewDataVO.totalSize;
                        vm.data=data.menu;
                        vm.loading=false
                    }).error(function(data) {
                        console.log("失败")
                    });
                },
                handleClick(index, row) {
                    console.log(row.customerId);
                    this.dialogTableVisible=false;
                    this.rule.attributeId=row.attributeId;
                    this.rule.attributeName=row.attributeName;
                    $("#lifeCycleName").text(''+row.attributeName+'');
                    var vm;
                    vm = this;
                    vm.loading=true;
                    return $.ajax({
                        url: "findItem",
                        dataType: 'json',
                        method: 'POST',
                        data:{"attributeColumnName":row.attributeName}
                    }).done(function(data) {
                        console.log("dataItem@@@"+data);
                        vm.options = data;
                        vm.loading=false
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
                onSubmit(form) {

                    form.ruleList=rules;
                    console.log(form);
                    var vm;
                    vm = this;
                    return $.ajax({
                        url:"LifeCycleSvaeForm",
                        data:JSON.stringify(form),
                        type:"POST",
                        dataType:"json",
                        contentType : 'application/json;charset=utf-8',
                    }).done(function(msg) {
                        console.log("chenggong"+msg);
                        if ('success'==msg){
                            window.location.href = "lifeCycleList";
                        }else {
                            vm.$message.error(msg);
                        }
                    }).error(function(msg) {
                        console.log("失败"+msg);
                    });
                },
                onPrimary(){
                    console.log('primary!');
                },
                handleNodeClick(data) {
//                    console.log(data.children);
                    console.log(data.label);
                    console.log(data.menuId);
                    this.id=data.menuId;
                    return this.init();
                },
                changeSelect(data){
                    console.log(data);
                    $("#ruleOperator").text(''+data+'')
                    console.log(this.rule.ruleOperator);
                }
                ,
                changeSelect2(data){
//                    console.log("进入"+obj2string(rules));
                    console.log(data);
                    $.each(this.options, function (i, item) {
                        console.log("label:"  + item.label);
                        console.log("value:"  + item.value);
                        if(data==item.value){
                            $("#attributeValue").text(''+item.label+'');
                        }
                    });
//                    this.rule.attributeValue=data;
                    if (data!=""){
                        this.form.attributeValueId=data;
                    }

//                    console.log("进入"+obj2string(rules));
                    console.log(this.rule.attributeValue);
                }
                ,
                changeSelect3(data){
                    console.log(data);
                    $("#relationalSymbol").text(''+data+'')
                    console.log(this.rule.relationalSymbol);
                },
                dialogCancel(){
                    $("#lifeCycleName").html("");
                    $("#ruleOperator").html("");
                    $("#attributeValue").html("");
                    $("#relationalSymbol").html("");
                    this.rule.ruleOperator='';
                    this.rule.attributeValue='';
                    this.rule.relationalSymbol='';
                    this.clearable=true;
                    return this.dialogleVisible = false
                },
                onCancel(){
                    window.location.href = "lifeCycleList";
                },
                dialogSubmit(){
//                    console.log(obj2string(this.form.ruleList));
                    if (this.form.ruleList.length>4){
                        this.$message.error('属性规则不得超过五条');
                    }else {
                    console.log($('.idCss').length);
                    var attributeValueNameText="";
                    var attributeValueNum=this.rule.attributeValue
                    console.log("attributeValue"+this.rule.attributeValue);
                    $.each(this.options, function (i, item) {
                        if(attributeValueNum==item.value){
                            attributeValueNameText=item.label;
                        }
                    });
                    if ($('.idCss').length>0){
                        var number=$(".spanId:last").text();
                        console.log("number"+number);
                        var j = parseInt(number)
                        j=j+1
                        console.log("进1");
//                        var id='number'+j;
                        $('.idCss:last').after("<div class='idCss'><div style='margin-top: 16px;margin-left: 80px;float: left;'><span class='spanId' style='font-size: 14px;color: #48576a;'>"+j+"、</span> </div><div  style='width: 340px;height: 50px;border-radius: 10px;border: 1px solid #bfcbd9;margin-top: 20px;margin-left: 115px;'><button type='button' onclick='deleteDiv(event,"+j+")' style='margin-right: -100px;float: right;margin-top: 6px;' class='el-button el-button--primary el-icon-delete'><!----><!----></button>" +
//                                "<button type='button' style='margin-right: -150px;float: right;margin-top: 6px;' class='el-button el-button--primary'><!----><i class='el-icon-plus'></i><!----></button>" +
                                " <div style='margin-left: 8px;margin-top: 3px;'><span>属性 : </span><span>\""+this.rule.attributeName+"\"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>运算符 : </span><span>\""+this.rule.ruleOperator+"\"</span> </div>" +
                                "<div style='margin-left: 8px;;margin-top: 3px;'> <span>值 : </span><span>\""+attributeValueNameText+"\"</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>关系符 : </span><span>\""+this.rule.relationalSymbol+"\"</span> </div>" +
                                "" +
                                "</div></div>");
                    }else {
                        console.log("进2");
//                        var id='number'+1;
                        $('#divButton').after("<div class='idCss'><div style='margin-top: 16px;margin-left: 80px;float: left;'><span class='spanId' style='font-size: 14px;color: #48576a;'>"+1+"、</span> </div><div  style='width: 340px;height: 50px;border-radius: 10px;border: 1px solid #bfcbd9;margin-top: 20px;margin-left: 115px;'><button type='button' onclick='deleteDiv(event,1)' style='margin-right: -100px;float: right;margin-top: 6px;' class='el-button el-button--primary el-icon-delete'><!----><!----></button>" +
                                " <div style='margin-left: 8px;margin-top: 3px;'><span>属性 : </span><span>\""+this.rule.attributeName+"\"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>运算符 : </span><span>\""+this.rule.ruleOperator+"\"</span> </div>" +
                                "<div style='margin-left: 8px;;margin-top: 3px;'> <span>值 : </span><span>\""+attributeValueNameText+"\"</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>关系符 : </span><span>\""+this.rule.relationalSymbol+"\"</span> </div>" +
                                "" +
                                "</div></div>");
                    }
                    console.log(1);
                    this.form.ruleList=rules;
                        var ruleEntity={
                            ruleOperator : '',
                            attributeValue : '',
                            relationalSymbol : '',
                            attributeName : '',
                            attributeId : ''
                        }
                        ruleEntity.ruleOperator=this.rule.ruleOperator;
                        ruleEntity.attributeName=this.rule.attributeName;
                        ruleEntity.attributeValue=this.rule.attributeValue;
                        ruleEntity.relationalSymbol=this.rule.relationalSymbol;
                        ruleEntity.attributeId=this.rule.attributeId;
                    this.form.ruleList.push(ruleEntity);
                    rules=this.form.ruleList;
//                    console.log("成功—rules:"+obj2string(rules));


                    $("#lifeCycleName").html("");
                    $("#ruleOperator").html("");
                    $("#attributeValue").html("");
                    $("#relationalSymbol").html("");
                    this.rule.ruleOperator='';
                    this.rule.attributeValue='';
                    this.rule.relationalSymbol='';
                    this.clearable=true;
                    return this.dialogleVisible = false
                    }
                }
            }
        });
    });
    Array.prototype.del=function(index){
        if(isNaN(index)||index>=this.length){
            return false;
        }
        for(var i=0,n=0;i<this.length;i++){
            if(this[i]!=this[index]){
                this[n++]=this[i];
            }
        }
        this.length-=1;
    };

    // Array Remove - By John Resig (MIT Licensed)
    Array.prototype.removeArray = function(from, to) {
        var rest = this.slice((to || from) + 1 || this.length);
        this.length = from < 0 ? this.length + from : from;
        return this.push.apply(this, rest);
    };

    function deleteDiv(event,num){
        console.log(event);
        console.log(num);
//        console.log(event.target);
//        console.log(rules);
//        console.log($(".spanId"));
        $(".spanId").each(function(){
            console.log($(this).text().substring(0,1))
            if ($(this).text().substring(0,1)>num){
                $(this).text($(this).text().substring(0,1)-1+"、");
            }

        });
        event.path[2].remove();

        console.log("num:"+num);
//        rules=rules.splice(num-1,1);
        rules.removeArray(num-1);
        console.log("rules:"+rules);

    }
</script>
</html>
