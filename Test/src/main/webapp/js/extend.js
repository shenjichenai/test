/**
 * jquery扩展
 */
$(function() {
	$.fn.validateRules = {
		"empty" : function(ele) {
			var value = ele.val();
			var isValid = true;
			var title = ele.parent().prev().find('label').html();
			// 字符串不能为空
			if (value.length == 0) {
				isValid = false;
				// 字符串是否为“空”字符即用户输入了空格
			} else if (value.replace(/(^s*)|(s*$)/g, "").length == 0) {
				isValid = false;
				// 字符串是否为空或者全部都是空格
			} else if (value == null) {
				isValid = false;
			}
			var message = '';
			if (!isValid) {
				message = "不能为空，请重新输入";
			}
			return {
				isValid : isValid,
				message : message
			};
		},
		"user" : function(ele) {
			var value = ele.val();
			var isValid = true;
			var regUser = /^[a-zA-Z]\w{4,35}$/g; // 用户名
			var message = '';
			// 字符串是否为汉字
			if (!regUser.test(value)) {
				isValid = false;
				message = '用户名只能以字母开头，长度在5到36之间，请重新输入';
			}
			return {
				isValid : isValid,
				message : message
			};
		},
		'password' : function(ele) {
			var value = ele.val();
			var isValid = true;
			var regPassword = new RegExp(
					"^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,18}$", "g"); // 密码验证
			var message = '';
			if (!regPassword.test(value)) {
				isValid = false;
				message = title + '密码支持6-18位的任意数字英文，验证不通过，请重新输入';
			}
			return {
				isValid : isValid,
				message : message
			};
		},
		'phone' : function(ele) {
			var value = ele.val();
			var isValid = true;
			var message = '';
			var regPhone = /^1[345789]\d{9}/g; // 电话
			if (!regPhone.test(value)) {
				isValid = false;
				message = '请输入正确的电话号码'
			}
			return {
				isValid : isValid,
				message : message
			};
		},
		'email' : function(ele) {
			var value = ele.val();
			var isValid = true;
			if (value.length < 1) {
				return isValid;
			}
			var regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g; // 邮箱
			if (!regEmail.test(value)) {
				isValid = false;
				message = '邮箱格式不正确';
			}
			return {
				isValid : isValid,
				message : message
			};
		}
	};
	$.fn.extend({
		'validate' : function() {// 单个表单验证
			var tagName = $(this).get(0).tagName;
			debugger;
			if ('INPUT' != tagName) {
				return false;
			}
			var validData = {
				isValid : false
			};
			var options = $(this).attr("data-options");
			if (options == null) {
				return validData;
			}
			options = eval('({' + options + '})');
			var validate = options.validate;
			var ele = $(this);
			if (typeof validate.length == 'number'
					&& typeof validate.splice == 'function') { // 数组
				$.each(validate, function(i, v) {
					if (!!$.fn.validateRules[v]) {
						validData = $.fn.validateRules[v](ele);
						if (!validData.isValid) {
							return validData;
						}
					}
				});
			} else {
				if (!!$.fn.validateRules[validate]) {
					validData = $.fn.validateRules[validate](ele);
				}
			}
			return validData;
		},
		'form' : function() {// form表单验证
			var form = $(this);
			return {
				'validate' : function() {
					var tagName = form.get(0).tagName;
					if ('FORM' != tagName) {
						return false;
					}
					var inputs = form.find('input');
					var validData = {
						isValid : false
					};
					inputs.each(function(i, ipt) {
						var options = $(ipt).attr("data-options");
						if (options == null) {
							return true;
						}
						options = eval('({' + options + '})');
						var validate = options.validate;
						validData = $(ipt).validate();
						if (!validData.isValid) {
							return false;
						}
					});
					return validData;
				}
			}
		}
	});
	// $('#input').validate();
	// $('#form').form().validate();
})