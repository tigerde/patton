/**
 * Created by liuyang on 2017/7/6.
 */
$(function(){
    new AccordionMenu();
    new formConfiguration("/queryMemberList",13);
});

function findquery(i){
    new clickFormConf("/queryMemberList",i);
    var type=new Array(13,14,15);
    new findPorp("findCustomerAttrProp",i,"客户社群昨天消息数聚类",
        "客户社群前三天消息数聚类","客户社群本周消息数量",type);
}
