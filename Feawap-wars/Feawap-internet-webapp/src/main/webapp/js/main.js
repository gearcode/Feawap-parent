$(document).on("touchmove",function(e){
	//不知道为什么不绑定touchmove事件,:active无法有效的执行
	//e.preventDefault();
});
if($(".ui-slide").length){
	$(".ui-slide .ui-slide-border").swiper({
		wrapperClass:"ui-slide-wrapper",
		slideClass:"ui-slide-item",
		pagination:".ui-slide-nav",
		paginationActiveClass:"active",
	    loop:true,
	    calculateHeight:true
	});
}
$(function(){
	if("swiper" in $.fn){
		window.swiperAutoHeight = function(swiper){
			var $slide = $(swiper.getSlide(swiper.activeIndex)),
				$last = $slide.children(":last");
			if($last.length){
				var h = $last.position().top+$last.outerHeight(true);
				$slide.height(h);
				$(swiper.wrapper).height(h);
			}
		};
		$('.swiper-content').each(function(){
			var $this= $(this),
				$nav = $this.prev();
			if($this.children().children().length){
				if(!$nav.hasClass("swiper-nav")){
					$nav = $nav.find(".swiper-nav:first");
				}
				var swiper = $this.swiper({
					onSlideChangeStart: function(swiper){
						$nav.find(".current").removeClass('current');
						var activeNav = $nav.children().eq(swiper.activeIndex).addClass('current');
						$this.trigger("swiperChangeStart",swiper);
						swiperAutoHeight(swiper);
					},
					calculateHeight:false,
					noSwiping:true
				});
				$nav.children().click(function(){
					swiper.swipeTo($(this).index());
				}).eq(swiper.activeIndex).addClass("current");
				swiperAutoHeight(swiper);
			}
		});
	}
});

$("header .right.ui-icon-arrow-left").click(function(){
	if(document.referrer){
		history.back();
	}
	else {
		location.href=site_url+"/action/";
	}
});

var Form = {
	defaultData : {
		name:"",
		type:"text",//text|select|radio
		icon:"",
		right:"",
		value:"",
		label:["",""],
		options:[],
		wrapperClass:""
	},
	create : function(list,$form){
		var ret = [];
		$.each(list,function(i,data){
			ret.push(Form.createRow(data));
		});
		return ret;
	},
	createRow : function(data){
		var row = $.extend({},Form.defaultData,data);
		if(row.type=="line"){
			return $("<div>",{"class":"ui-form-line"});
		}
		var $row = $("<div>").addClass("ui-form-row"),
			$label = $("<label>").appendTo($row),
			$wrapper = $("<div>").addClass("ui-input-wrapper").appendTo($row),
			$input;
		$("<span>",{"class":"major"}).html(row.label[0]+"&nbsp;").appendTo($label);
		if(row.label[1]){
			$("<span>",{"class":"minor"}).html(row.label[1]).appendTo($label);
		}
		if(row.wrapperClass){
			$wrapper.addClass(row.wrapperClass);
		}
		var id="f_"+row.name;
		if(id.indexOf("[]")>=0){
			id = id.substr(0,id.length-2)+Date.now();
		}
		switch(row.type){
			case "date":
			case "number":
			case "text":
				$label.attr("for",id);
				$input = $("<input>",{"id":id,"name":row.name,"type":row.type,"min":row.min,"max":row.max}).val(row.value).appendTo($wrapper);
				if (row.icon) {
					$("<span>",{"class":"ui-input-left ui-icon ui-icon-"+row.icon}).appendTo($wrapper);
					$input.addClass("ui-input-has-left");
				}
				if(row.right) {
					$("<span>",{"class":"ui-input-right ui-icon ui-icon-"+row.right}).appendTo($wrapper);
					$input.addClass("ui-input-has-right");
				}
				break;
			case "select":
				$label.attr("for",id);
				$input = $("<select>",{"id":id,"name":row.name}).appendTo($wrapper);
				$.each(row.options,function(i,o){
					if(typeof o=="string"){
						o = [o,o];
					}
					$("<option>",{"value":o[1]}).html(o[0]).appendTo($input);
				});
				$input.val(row.value);
				if (row.icon) {
					$("<span>",{"class":"ui-input-left ui-icon ui-icon-"+row.icon}).appendTo($wrapper);
					$input.addClass("ui-input-has-left");
				}
				$("<span>",{"class":"ui-input-right ui-icon ui-icon-triangle"}).appendTo($wrapper);
				$input.addClass("ui-input-has-right");
				break;
			case "radio":
			case "checkbox":
				$.each(row.options,function(i,o){
					if(typeof o=="string"){
						o = [o,o];
					}
					$("<div>",{"class":"ui-radio-block"})
						.append($("<input>",{"id":id+"_"+o[1],"name":row.name,"value":o[1],"type":row.type}))
						.append($("<label>",{"for":id+"_"+o[1]}).html(o[0]))
						.appendTo($wrapper);
				});
		}
		return $row;
	},
};