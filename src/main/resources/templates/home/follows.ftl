

<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>我的主页 - Mtons</title>
    <meta name="keywords" content="mtons,mtons,博客,社区,摄影,旅游,艺术,娱乐"/>
    <meta name="description" content="Mtons, 轻松分享你的兴趣. 便捷的文字、图片发布,扁平化的响应式设计,美观、大气,是您记录生活的最佳选择"/>
<meta property="mtons:mblog" content="2.2.1">

<script src="/assets/vendors/pace/pace.min.js"></script>
<link href="/assets/vendors/pace/themes/pace-theme-minimal.css" rel="stylesheet" />

<link rel='stylesheet' media='all' href='/assets/vendors/font-awesome/css/font-awesome.min.css'/>
<link rel="stylesheet" media='all' href="/assets/vendors/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" media='all' href="/assets/vendors/animate/animate.min.css">
<link rel='stylesheet' media='all' href='/assets/css/style.css'/>
<link rel='stylesheet' media='all' href='/assets/css/layout.css'/>
<link rel='stylesheet' media='all' href='/assets/css/plugins.css'/>
<link rel='stylesheet' media='all' href='/assets/css/addons.css'/>

<link rel='stylesheet' media='all' href="/assets/vendors/baguette/baguetteBox.min.css"/>

<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/assets/js/utils.js"></script>

<script type="text/javascript" src="/assets/vendors/layer/layer.js"></script>

<script type="text/javascript" src="/assets/js/sea.js"></script>
<script type="text/javascript" src="/assets/js/sea.config.js"></script>

<script type="text/javascript" src="/assets/vendors/bootstrap/js/bootstrap.min.js"></script>

<!-- Favicons -->
<link rel="apple-touch-icon-precomposed" href="http://mtons.com/dist/images/logo.png"/>
<link rel="shortcut icon" href="http://mtons.com/dist/images/logo.png"/>

<script type="text/javascript">
    var _base_path = '$!{base}';

    window.app = {
        base: '',
        LOGIN_TOKEN: '$!{profile.id}'
    };
	
	window.UEDITOR_HOME_URL = '/assets/vendors/ueditor/';
</script>
</head>
<body>

<#include "/inc/header.ftl">

    <!--.site-main -->
    <div class="wrap" id="wrap">
        <div class="container">
            <div class="row">
                <div class="main clearfix">

<#include "/inc/home-left.ftl" >

                    <div class="col-xs-12 col-md-9 side-right">

<div class="shadow-box">
	<div class="filter">
		<ul class="">
			<li><a class="active" href="/home/follows">我的关注</a></li>
			<li><a href="/home/fans">我的粉丝</a></li>
		</ul>
	</div>
	<!-- tab panes -->
	<div class="stream-list">
	<#list voList as user>
			<div class="stream-item" id="loop-${user.id}">
				<div class="blog-rank">
					<div class="user" title="${user.nickname}">
						<a href="/ta/${user.id}">
    <img class="img-circle" src="${user.avatar}"/>
						</a>
					</div>
				</div>
				<div class="summary">
					<h2 class="title">${user.nickname}</h2>
					<div class="foot-block clearfix">
						<div class="author">
							<span>文章数 ${user.articleCount}</span>
							<span>评论数 ${user.commentCount}</span>
						</div>
						<div class="pull-right hidden-xs">
							<a class="btn btn-success btn-xs" href="javascript:void(0);" data-id="${user.id}" rel="unfollow" style="color: #fff;">取消关注</a>
						</div>
					</div>
				</div>
			</div>
	</#list>
			

	</div>
</div>
<div class="text-center clr">

<ul class="pagination">

    <li class="active"><a href="javascript:void(0);"><span>1</span></a></li>

</ul>
</div>

<script type="text/javascript">
$(function() {
	$('a[rel=unfollow]').click(function () {
		var id = $(this).attr('data-id');

		layer.confirm('确定取消关注TA吗?', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
			jQuery.getJSON('/account/unfollow',{'id': id},  function (ret) {
				layer.msg(ret.msg,function(){});
				if (ret.code ==0) {
					window.location.href='/login.html';
				}
				if (ret.code ==1) {
					/*$('#loop-' + id).fadeOut(1000,function(){
						$('#loop-' + id).remove();
					});*/
					$('#loop-' + id).remove();
				}
			});

        }, function(){

        });
	});
})
</script>
                    </div>
                </div>
            </div>
        </div>
    </div>
<footer>
	<div class="footer-nav">
		<div class="container">
			<ul class="about-ul list-inline clearfix">
				<li><a href="/about">关于我们</a></li>
				<li><a href="/joinus">联系我们</a></li>
				<li><a href="/faqs">常见问题</a></li>
                
			</ul>
		</div>
	</div>
	<div class="container mode-link">
        <h3 class="t-h3">友情链接</h3>
        <ul class="list-inline">
            <li><a href="http://www.mtons.com" target="_blank" title="Mtons社区">Mtons社区</a></li>
        </ul>
    </div>
	<div class="container copy-right">
		<span> <a
			href="http://www.miitbeian.gov.cn/" target="_blank"></a>
		</span>
		<span class="pull-right">Powered By <a href="http://mtons.com/?copyright" target="_blank">Mtons</a></span>
	</div>

</footer>

<a href="#" class="site-scroll-top"></a>

<script type="text/javascript">
    seajs.use('main', function (main) {
        main.init();
    });
</script></body>
</html>
