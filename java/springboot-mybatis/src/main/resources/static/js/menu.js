/**
 * Created by liuyang on 2017/7/31.
 */
$(function() {
    var testMenu=[{"name":"菜单","submenu":[{"name":"基础属性","submenu":[{"name":"身份识别","url":"/springBootJsp/viewProperties?id=9"}]},{"name":"行为属性","submenu":[{"submenu":[{"name":"公众号交互","url":"/springBootJsp/viewProperties?id=12"},{"name":"自营群交互","url":"/springBootJsp/viewProperties?id=13"}],"name":"品牌交互行为"},{"submenu":[{"name":"产品购买","url":"/springBootJsp/viewProperties?id=14"}],"name":"消费行为"}]}]}]
            new AccordionMenu({menuArrs:testMenu});
});