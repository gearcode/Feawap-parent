var GC = {};
GC.pagination = function(ul, url, current, total, length) {
	pagination = GC.pageRange(length, current, total);
	ul.append(
		$("<li></li>").addClass(current == 1 ? "disabled" : "").append(
			$("<a></a>").attr("href", current == 1 ? "javascript:void(0)" : url + 1).append(
				"<i class='ace-icon icon icon-double-angle-left'></i>"
			)
		)
	);
	ul.append(
		$("<li></li>").addClass(current == 1 ? "disabled" : "").append(
			$("<a></a>").attr("href", current == 1 ? "javascript:void(0)" : url + (current - 1)).append(
				"<i class='ace-icon icon icon-angle-left'></i>"
			)
		)
	);
	for(var i = pagination.start; i <= pagination.end; i++) {
		ul.append(
			$("<li></li>").addClass(current == i ? "active" : "").append(
				$("<a></a>").html(i).attr("href", url + i)
			)
		);
	}
	ul.append(
		$("<li></li>").addClass(current == total ? "disabled" : "").append(
			$("<a></a>").attr("href", current == total ? "javascript:void(0)" : url + (current + 1)).append(
				"<i class='ace-icon icon icon-angle-right'></i>"
			)
		)
	);
	ul.append(
		$("<li></li>").addClass(current == total ? "disabled" : "").append(
			$("<a></a>").attr("href", current == total ? "javascript:void(0)" : url + total).append(
				"<i class='ace-icon icon icon-double-angle-right'></i>"
			)
		)
	);
}

GC.pageRange = function(length, page, total) {
	if(length > total) return {
		"start": 1,
		"end": total
	};
	var start = (page <= Math.floor(length / 2) + 1 ? 1 : (page - Math.floor(length / 2)));
	var end   = (start + length - 1 >= total ? total : start + length - 1);
	if (end >= total) start = end - length + 1;
	return {
		"start": start,
		"end": end
	};
}