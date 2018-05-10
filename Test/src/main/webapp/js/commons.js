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
			html = $el.html();
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
}
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
/**
 * 匹配替换数据
 */
function matchAndReplace(html, data) {
	var content = html.replace(/\{([\s\S]*?)\}/g, function(rep) {
		var name = rep.substring(1, rep.length - 1);
		return data[name] == null ? '' : data[name];
	});
	return content;
}