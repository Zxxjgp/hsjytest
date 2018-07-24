/**
 * @fileOverview: jquery.itab.1.2.js 
 * @author: Tian Xiao Yun 
 * @contact: email misstian2008@163.com || 358926040
 * @version: 1.2
 * @external: [jquery.js]
 * @update: 2017/7/20
 */
;(function($, window, document,undefined) {
    //定义Progressbar的构造函数
    var Progressbar = function(ele, opt) {
        this.eleId = $(ele).attr("id"),
        this.defaults = {
            max: ['34287','万元'],//最大值 必选项 以数组形式 [0]=最大的数 [1]=单位
            value: ['4636','万元'],//最大值 必选项 以数组形式 [0]=最大的数 [1]=单位
            percentage: true,//所占百分比 true显示 false不显示
            prevValue: '4030',// 前一个数值
            comparison: null,//对比值 此值必须设置prevValue 与前一个数值对比 上升或下降 null为不显示 callback 返回里面显示的内容
            bubble: 'show' //是否显示定位气泡 show=显示 false = 不显示
        },
        this.options=$.extend({},this.defaults,opt)
    }
    //定义Progressbar的方法
    Progressbar.prototype = {
        init: function() {
            var _this = this;
            var percentage = (_this.options.value[0]/_this.options.max[0]*100).toFixed(2);
            
            var innerHtml = '<div class="progressbar-wrap">';
                innerHtml += '<div class="progressbar-inner" style="width:'+percentage+'%;"></div>';
                innerHtml += '<div class="max">'+_this.options.max[0]+_this.options.max[1]+'</div>';
                innerHtml += '<div class="value" style="margin-left:'+percentage/2+'%;">'+_this.options.value[0]+_this.options.value[1]+'</div>';
                // 显示所占百分比 
                if(_this.options.percentage){
                    innerHtml += '<div class="percentage" style="left:'+percentage+'%;">'+percentage+'%</div>';
                }
                // 显示与前一个数值对比
                if( _this.options.comparison != null ){
                    var comparisonHtml = _this.options.comparison(_this.options.value,_this.options.prevValue);
                    if(_this.options.value > _this.options.prevValue){
                        innerHtml += '<div class="comparison rise">'+comparisonHtml+'</div>';
                    }else {
                        innerHtml += '<div class="comparison down">'+comparisonHtml+'</div>';
                    }
                }
                // 显示气泡
                if(_this.options.bubble === "show"){
                    innerHtml += '<div class="bubble" style="left:'+percentage+'%;"></div>';
                }
                innerHtml += '</div>';

                $("#"+this.eleId).html(innerHtml);

        }
    }
    //在插件中使用Progressbar对象 选择器 
    $.fn.progressbar = function(options) {
        //创建Progressbar的实体
        var progressbar = new Progressbar(this, options);
        //调用其方法
        return progressbar.init();
    }
})(jQuery, window, document);