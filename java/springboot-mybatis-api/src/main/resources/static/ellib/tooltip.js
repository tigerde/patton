module.exports =
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/dist/";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ({

/***/ 0:
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__(345);


/***/ },

/***/ 13:
/***/ function(module, exports) {

	module.exports = require("element-ui/lib/utils/vue-popper");

/***/ },

/***/ 55:
/***/ function(module, exports) {

	module.exports = require("vue");

/***/ },

/***/ 63:
/***/ function(module, exports) {

	module.exports = require("throttle-debounce/debounce");

/***/ },

/***/ 197:
/***/ function(module, exports) {

	module.exports = require("element-ui/lib/utils/vdom");

/***/ },

/***/ 345:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	exports.__esModule = true;

	var _main = __webpack_require__(346);

	var _main2 = _interopRequireDefault(_main);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/* istanbul ignore next */
	_main2.default.install = function (Vue) {
	  Vue.component(_main2.default.name, _main2.default);
	};

	exports.default = _main2.default;

/***/ },

/***/ 346:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	exports.__esModule = true;

	var _vuePopper = __webpack_require__(13);

	var _vuePopper2 = _interopRequireDefault(_vuePopper);

	var _debounce = __webpack_require__(63);

	var _debounce2 = _interopRequireDefault(_debounce);

	var _vdom = __webpack_require__(197);

	var _vue = __webpack_require__(55);

	var _vue2 = _interopRequireDefault(_vue);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	exports.default = {
	  name: 'ElTooltip',

	  mixins: [_vuePopper2.default],

	  props: {
	    openDelay: {
	      type: Number,
	      default: 0
	    },
	    disabled: Boolean,
	    manual: Boolean,
	    effect: {
	      type: String,
	      default: 'dark'
	    },
	    popperClass: String,
	    content: String,
	    visibleArrow: {
	      default: true
	    },
	    transition: {
	      type: String,
	      default: 'el-fade-in-linear'
	    },
	    popperOptions: {
	      default: function _default() {
	        return {
	          boundariesPadding: 10,
	          gpuAcceleration: false
	        };
	      }
	    },
	    enterable: {
	      type: Boolean,
	      default: true
	    },
	    hideAfter: {
	      type: Number,
	      default: 0
	    }
	  },

	  data: function data() {
	    return {
	      timeoutPending: null
	    };
	  },
	  beforeCreate: function beforeCreate() {
	    var _this = this;

	    if (this.$isServer) return;

	    this.popperVM = new _vue2.default({
	      data: { node: '' },
	      render: function render(h) {
	        return this.node;
	      }
	    }).$mount();

	    this.debounceClose = (0, _debounce2.default)(200, function () {
	      return _this.handleClosePopper();
	    });
	  },
	  render: function render(h) {
	    var _this2 = this;

	    if (this.popperVM) {
	      this.popperVM.node = h(
	        'transition',
	        {
	          attrs: {
	            name: this.transition
	          },
	          on: {
	            'afterLeave': this.doDestroy
	          }
	        },
	        [h(
	          'div',
	          {
	            on: {
	              'mouseleave': function mouseleave() {
	                _this2.setExpectedState(false);_this2.debounceClose();
	              },
	              'mouseenter': function mouseenter() {
	                _this2.setExpectedState(true);
	              }
	            },

	            ref: 'popper',
	            directives: [{
	              name: 'show',
	              value: !this.disabled && this.showPopper
	            }],

	            'class': ['el-tooltip__popper', 'is-' + this.effect, this.popperClass] },
	          [this.$slots.content || this.content]
	        )]
	      );
	    }

	    if (!this.$slots.default || !this.$slots.default.length) return this.$slots.default;

	    var vnode = (0, _vdom.getFirstComponentChild)(this.$slots.default);
	    if (!vnode) return vnode;
	    var data = vnode.data = vnode.data || {};
	    var on = vnode.data.on = vnode.data.on || {};
	    var nativeOn = vnode.data.nativeOn = vnode.data.nativeOn || {};

	    data.staticClass = this.concatClass(data.staticClass, 'el-tooltip');
	    on.mouseenter = this.addEventHandle(on.mouseenter, this.show);
	    on.mouseleave = this.addEventHandle(on.mouseleave, this.hide);
	    nativeOn.mouseenter = this.addEventHandle(nativeOn.mouseenter, this.show);
	    nativeOn.mouseleave = this.addEventHandle(nativeOn.mouseleave, this.hide);

	    return vnode;
	  },
	  mounted: function mounted() {
	    this.referenceElm = this.$el;
	  },


	  methods: {
	    show: function show() {
	      this.setExpectedState(true);
	      this.handleShowPopper();
	    },
	    hide: function hide() {
	      this.setExpectedState(false);
	      this.debounceClose();
	    },
	    addEventHandle: function addEventHandle(old, fn) {
	      if (!old) {
	        return fn;
	      } else if (Array.isArray(old)) {
	        return old.indexOf(fn) > -1 ? old : old.concat(fn);
	      } else {
	        return old === fn ? old : [old, fn];
	      }
	    },
	    concatClass: function concatClass(a, b) {
	      if (a && a.indexOf(b) > -1) return a;
	      return a ? b ? a + ' ' + b : a : b || '';
	    },
	    handleShowPopper: function handleShowPopper() {
	      var _this3 = this;

	      if (!this.expectedState || this.manual) return;
	      clearTimeout(this.timeout);
	      this.timeout = setTimeout(function () {
	        _this3.showPopper = true;
	      }, this.openDelay);

	      if (this.hideAfter > 0) {
	        this.timeoutPending = setTimeout(function () {
	          _this3.showPopper = false;
	        }, this.hideAfter);
	      }
	    },
	    handleClosePopper: function handleClosePopper() {
	      if (this.enterable && this.expectedState || this.manual) return;
	      clearTimeout(this.timeout);

	      if (this.timeoutPending) {
	        clearTimeout(this.timeoutPending);
	      }
	      this.showPopper = false;
	    },
	    setExpectedState: function setExpectedState(expectedState) {
	      if (expectedState === false) {
	        clearTimeout(this.timeoutPending);
	      }
	      this.expectedState = expectedState;
	    }
	  }
	};

/***/ }

/******/ });