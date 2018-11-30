(function() {
	var PreviewPicBox = function(options) {
		this.init();
	}
	PreviewPicBox.prototype.init = function() {
		this.renderDOM();
		this.nextBtnClick();
		this.prevBtnClick();
	};
	PreviewPicBox.prototype.renderDOM = function() {
		var html = '<div id="dd-pic" style="overflow: hidden;" data-options="title : \'照片查看\',width : 600,height : 440,closed : true,cache : false,modal : true,"><style>'
				+ '/* 图片切换样式 */'
				+ '.img_module {'
				+ '	/* width: 100%;'
				+ '	height: 100%; */'
				+ '	max-height: 394px;'
				+ '	max-width: 580px;'
				+ '}'
				+ '.show_pic {'
				+ '	display: block;'
				+ '}'
				+ '.close_pic {'
				+ '	display: none;'
				+ '}'
				+ '.page_pic {'
				+ '	width: 64px;'
				+ '}'
				+ '#prev-page:HOVER {'
				+ '	background: #bfbfbf;'
				+ '}'
				+ '#next-page:HOVER {'
				+ '	background: #bfbfbf;'
				+ '}'
				+ '.link-box {'
				+ '	position: absolute;'
				+ '	left: 0;'
				+ '	bottom: 15px;'
				+ '	width: 100%;'
				+ '	text-align: center;'
				+ '}'
				+ '.link-box span {'
				+ '	display: inline-block;'
				+ '	width: 10px;'
				+ '	height: 10px;'
				+ '	border: 1px solid #BFBFBF;'
				+ '	-webkit-border-radius: 50%;'
				+ '	border-radius: 50%;'
				+ '	margin-right: 8px;'
				+ '}'
				+ '.link-box span.current {'
				+ '	background: #BFBFBF;'
				+ '}'
				+ '</style>'
				+ '<div id="show-pic" style="display: none;">'
				+ '	<div id="pic-container" style="padding-top: 5px; padding-left: 3px; width: 580px; height: 394px; display: table-cell; vertical-align: middle; text-align: -webkit-center;"></div>'
				+ '	<div class="link-box" id="link-box"></div>'
				+ '	<div>'
				+ '		<div style="text-align: left; position: relative; top: -229px; float: left;">'
				+ '			<img id="prev-page" alt="上一页" class="page_pic" src="../images/prev.png">'
				+ '		</div>'
				+ '		<div style="text-align: right; position: relative; top: -229px; float: right;">'
				+ '			<img id="next-page" alt="下一页" class="page_pic" src="../images/next.png">'
				+ '		</div>'
				+ '	</div>'
				+ '</div>'
				+ '<div id="not-pic" style="display: block;">'
				+ '	<p>暂无照片</p>'
				+ '</div>' + '</div>';
		$('#body').append(html);
		$('#dd-pic').dialog();
	};
	PreviewPicBox.prototype.nextBtnClick = function() {
		$('#next-page').click(function() {
			var next = $('.show_pic').next();
			if (next.length == 0) {
				next = $('.img_module').first();
			}
			$('.show_pic').addClass('close_pic');
			$('.show_pic').removeClass('show_pic');
			next.addClass('show_pic');
			next.removeClass('close_pic');
			$('.link-box span.current').removeClass('current');
			$($('#link-box span').get(next.index())).addClass('current');
		});
	}
	PreviewPicBox.prototype.prevBtnClick = function() {
		$('#prev-page').click(function() {
			var prev = $('.show_pic').prev();
			if (prev.length == 0) {
				prev = $('.img_module').last();
			}
			$('.show_pic').addClass('close_pic');
			$('.show_pic').removeClass('show_pic');
			prev.addClass('show_pic');
			prev.removeClass('close_pic');
			$('.link-box span.current').removeClass('current');
			$($('#link-box span').get(prev.index())).addClass('current');
		});
	};
	PreviewPicBox.prototype.loadImgs = function(imgs) {
		if (imgs.length > 0) {
			var val = [];
			$.each(imgs, function(i, v) {
				var path = utils.getRootPath() + v;
				val.push({
					path : path
				});
				if (i == 0) {
					$('#link-box').append('<span class="current">');
				} else {
					$('#link-box').append('<span>');
				}
			});
			var template = '<img alt="" src="{path}" class="img_module close_pic">';
			createElementByData({
				el : '#pic-container',
				data : {
					list : val
				},
				forKey : 'list',
				template : template
			});
			var firsrtImg = $('#pic-container').find('.img_module').first();
			firsrtImg.removeClass('close_pic');
			firsrtImg.addClass('show_pic');
			showNotPic(false);
		} else {
			showNotPic(true);
		}
		$('#dd-pic').dialog('open');
	}
	function showNotPic(show) {
		if (show) {
			$('#dd-pic').find('#show-pic').hide();
			$('#dd-pic').find('#not-pic').show();
		} else {
			$('#dd-pic').find('#show-pic').show();
			$('#dd-pic').find('#not-pic').hide();
		}
	}
	window.PreviewPicBox = PreviewPicBox;
})();
// 使用
var PreviewPicBox = new window.PreviewPicBox();
PreviewPicBox.loadImgs([ '/images/AiKRCtiwyLATx18tqL8e.jpg',
		'/images/HmpgVYFwhJOgObkMpl2Z.jpg' ]);