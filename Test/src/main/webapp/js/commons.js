/*easyUI 通用组件信息*/
//datagrid
var options = {
	url : '',
	queryParams : {},
	loadFilter : function(data) {
		if (data.state) {
			return data.value;
		} else {
			$.messager.alert("警告", "<div style='padding-top:12px'>" + data.note
					+ "</div>", "warning");
			return {
				total : 0,
				rows : []
			};
		}
	},
	striped : true,
	singleSelect : true,
	fit : true,
	fitColumns : true,
	pagination : true,
	pageSize : 20,
	remoteSort : false,
	columns : [ [ {
		field : 'id',
		title : '主键',
		align : 'center',
		hidden : true,
		width : 80
	}, {
		field : 'title',
		title : '标题',
		align : 'center',
		width : 80
	}, {
		field : 'publishTime',
		title : '发表时间',
		sortable : true,
		align : 'center',
		formatter : function(value, row, index) {
			if (!!value) {
				if (typeof value == "String") {
					return value;
				}
				return utils.getFormatDateByLong(value, "yyyy-MM-dd hh:mm:ss");
			}
			return value;
		},
		width : 80
	}, {
		field : 'proximity',
		title : '关联度',
		align : 'center',
		sortable : true,
		sorter : function(a, b) {
			return (a > b ? 1 : -1);
		},
		width : 80
	} ] ],
	onSortColumn : function(sort, order) {
	}
};

/* easyui 前端分页 */
function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is
		// array
		data = {
			total : data.length,
			rows : data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}
/**
 * easyui下载文件方法
 * 
 * @param params
 */
function download(params) {
	var url = params.url;
	var data = params.data;
	var $downloadDiv = $('#download-div');
	var $form = $downloadDiv.find('form');
	if ($downloadDiv.length == 0) {
		var $div = $('<div id="download-div" style="display:none"></div>');
		$form = $('<form method="post"></form>');

		$div.append($form);
		$('body').eq(0).append($div);
	}
	$form.form('submit', {
		url : url,
		queryParams : data,
		success : function(data) {
			data = utils.str2JSON(data);
			if (data.state) {
			} else {
				$.messager.alert("警告", "<div style='padding-top:12px'>"
						+ data.note + "</div>", "warning");
			}
		}
	});
}
/**
 * 生成随机字符串
 */
function getRandom(n) {
	var chars = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ];
	var res = "";
	for (var i = 0; i < n; i++) {
		var id = Math.ceil(Math.random() * 61);
		res += chars[id];
	}
	return res;
}

/**
 * 通过数据创建节点
 * 
 * @param obj
 */
function createElementByData(obj) {
	var data = obj.data;
	var $el = obj.el == null ? null : $(obj.el);
	var $template = obj.template;
	var forKey = obj.forKey == null ? null : obj.forKey;

	var html = '';
	var content = '';
	if (!!$el) {
		if (!!forKey || $el.find('item').length > 0) {
			// 当两者都配置了之后，item配置的节点优先级更高
			if ($el.find('item').length > 0) {
				forKey = $el.find('item').eq(0).attr('forKey');
			}
			content = getContentByForKey($template, forKey, data);
		} else {
			// js配置优先
			html = $template == null ? $el.html() : $template;
			content = matchAndReplace(html, data);
		}
		$el.html(content);
	} else {
		if (!!forKey) {
			content = getContentByForKey($template, forKey, data);
		} else {
			html = new String($template);
			content = matchAndReplace(html, data);
		}
	}
	return content;

	/**
	 * 遍历获取数据
	 */
	function getContentByForKey(html, forKey, data) {
		var content = '';
		for ( var i in data) {
			if (forKey == i) {
				var array = data[i];
				for (var j = 0; j < array.length; j++) {
					var item = matchAndReplace(html, array[j]);
					content += item;
				}
			}
		}
		return content;
	}
}

/**
 * 匹配替换数据
 */
function matchAndReplace(html, data) {
	var content = html.replace(/\$\{([\s\S]*?)\}/g, function(rep) {
		var name = rep.substring(2, rep.length - 1);

		// 判断是否存在过滤器,用以格式化数据，待实现

		if (name.indexOf("|") > 0) {
			var splitArrar = name.split("|");
			name = splitArrar[0];
			var filter = eval(splitArrar[1]);
			filter.call(this, name);
		}

		// 逐级取值
		if (name.indexOf(".") > 0) {
			var names = name.split(".");
			return stepByStep(names, data);
		}

		return data[name] == null ? '' : data[name];
	});
	return content;

	// 多层数据取值
	function stepByStep(names, data) {
		var dd = {};
		$.each(data, function(i, d) {
			dd[i] = d;
		});
		$.each(names, function(i, n) {
			if (!dd[n]) {
				dd = '';
				return false;
			}
			dd = dd[n];
		})
		return dd;
	}
}