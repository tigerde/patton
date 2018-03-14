var testMenu=[{
	"name": "客户360视图",
	"submenu": [
		{
			"name": "行为属性",
			"submenu": [
				{
					"name": "社群交互",
					"submenu": [
						{
							"name": "签到",
							"url": "/springBootJsp/signIn"
						},
						{
							"name": "消息",
							"url": "/springBootJsp/message"
						},
						{
							"name": "提及",
							"url": "/springBootJsp/mention"
						}
					]
				},
				{
					"name": "公众号交互",
					"submenu": [
						{
							"name": "消息",
							"url": "#"
						},
						{
							"name": "事件",
							"url": "javascript:void(0);"
						}
						// ,
						// {
						// 	"name": "签到",
						// 	"url": "/springBootJsp/signIn"
						// }

					]
				},
				{
					"name": "会员",
					"submenu": [
						{
							"name": "积分",
							"url": "/springBootJsp/member"
						}
					]
				}
			]
		},
		{
			"name": "流量属性",
			"submenu": [
				{
					"name": "公众号交互",
					"submenu": [
						{
							"name": "消息",
							"url": "/springBootJsp/index"
						},
						{
							"name": "事件",
							"url": "/springBootJsp/event"
						}
					]
				}
			]
		}

	]
}
];
function AccordionMenu(options) {
	this.config = {
		containerCls        : '.wrap-menu',                // ???????
		menuArrs            :  testMenu,                         //  JSON????????????
		type                :  'click',                    // ????click ?????mouseover
		renderCallBack      :  null,                       // ???html??????
		clickItemCallBack   : null                         // ?????????????
	};
	this.cache = {

	};
	this.init(options);
 }


 AccordionMenu.prototype = {

	constructor: AccordionMenu,

	init: function(options){
		this.config = $.extend(this.config,options || {});
		var self = this,
			_config = self.config,
			_cache = self.cache;

		// ???html??
		$(_config.containerCls).each(function(index,item){

			self._renderHTML(item);

			// ?????????
			self._bindEnv(item);
		});
	},
	_renderHTML: function(container){
		var self = this,
			_config = self.config,
			_cache = self.cache;
		var ulhtml = $('<ul></ul>');
		$(_config.menuArrs).each(function(index,item){
			var lihtml = $('<li><h2>'+item.name+'</h2></li>');

			if(item.submenu && item.submenu.length > 0) {
				self._createSubMenu(item.submenu,lihtml);
			}
			$(ulhtml).append(lihtml);
		});
		$(container).append(ulhtml);

		_config.renderCallBack && $.isFunction(_config.renderCallBack) && _config.renderCallBack();

		// ?????????
		self._levelIndent(ulhtml);
	},
	/**
	 * ????????
	 * @param {array} ????
	 * @param {lihtml} li??
	 */
	_createSubMenu: function(submenu,lihtml){
		var self = this,
			_config = self.config,
			_cache = self.cache;
		var subUl = $('<ul></ul>'),
			callee = arguments.callee,
			subLi;

		$(submenu).each(function(index,item){
			var url = item.url || 'javascript:void(0)';

			subLi = $('<li><a href="'+url+'">'+item.name+'</a></li>');
			if(item.submenu && item.submenu.length > 0) {

				$(subLi).children('a').prepend('<img src="images/blank.gif" alt=""/>');
                callee(item.submenu, subLi);
			}
			$(subUl).append(subLi);
		});
		$(lihtml).append(subUl);
	},
	/**
	 * ?????????
	 */
	_levelIndent: function(ulList){
		var self = this,
			_config = self.config,
			_cache = self.cache,
			callee = arguments.callee;

		var initTextIndent = 2,
			lev = 1,
			$oUl = $(ulList);

		while($oUl.find('ul').length > 0){
			initTextIndent = parseInt(initTextIndent,10) + 2 + 'em';
			$oUl.children().children('ul').addClass('lev-' + lev)
						.children('li').css('text-indent', initTextIndent);
			$oUl = $oUl.children().children('ul');
			lev++;
		}
		$(ulList).find('ul:first').show();
	},
	/**
	 * ?????
	 */
	_bindEnv: function(container) {
		var self = this,
			_config = self.config;

		$('a',container).unbind(_config.type);
		$('a',container).bind(_config.type,function(e){
			if($(this).siblings('ul').length > 0) {
				$(this).siblings('ul').slideToggle('slow').end().children('img').toggleClass('unfold');
			}

		});
	}
 };

