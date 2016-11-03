var Consultation = function(){
	
};
Consultation.prototype.init = function(){
	var lastH = 0,
		iconSize = {
			"col4_66":[.66,.05,.05],
			"col6_61":[.66,.05,.05],
			"col6":[.66,.10,.05],
			"col6_50":[.66,.05,.05],
			"col3":[.66,.05,.05]
		};
	var resize = function() {
		function fetch($o,h){
			if($o.parent().hasClass("ui-grid")){
				return;
			}
			if(!$o.next().length){
				if($o.parent().hasClass("cols")){
					$o.parent().height($o.hasClass("rows")?$o.height():h);
					arguments.callee($o.parent(),h);
				}
				if($o.parent().hasClass("rows")){
					arguments.callee($o.parent());
				}
			}
		}
		$(".ui-grid").each(function(){
			var gridWidth = $(this).width();
			$(this).find(".item").each(function(i){
				var $this = $(this),
					tan = $this.attr("data-tan"),
					size = iconSize["col"+$this.attr("data-col")+(tan?"_"+tan:"")];
				tan = tan?"."+tan:1;
				var h = Math.round($this.outerWidth()*tan);
				lastH = Math.abs(lastH-h)==1?lastH:h;
				if(!$this.index()){
					if($this.parent(".cols").length)
						$this.parent().height(lastH);
					else
						$this.height(lastH);
				}
				//fetch($this,lastH);
				//else{
				//	$this.height(lastH);
				//}
				//$this.width($this.width());
				/*var positionRight = gridWidth-$this.position().left-$this.outerWidth();
				console.log(i,gridWidth-$this.position().left,positionRight,$this.outerWidth());
				if(Math.abs(positionRight<6)&&Math.abs(positionRight)>0){
					$this.width($this.width()+positionRight);
				}*/
				$this.find(".icon").css({
					top:Math.round(lastH*size[2]),
					left:Math.round(lastH*size[1]),
					width:Math.round(lastH*size[0]),
					height:Math.round(lastH*size[0]),
				});
			});
		});
		//$(".ui-grid .text").css("padding",1);//不知为什么使用flexbox后会错位
	};
	resize();
	$(window).resize(resize);
};