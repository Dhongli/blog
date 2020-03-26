

<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>${user.nickname?default('')}</title>
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

<!-- Favicons -->
<link rel="apple-touch-icon-precomposed" href="/assets/images/logo.png"/>
<link rel="shortcut icon" href="/assets/images/logo.png"/>

<script type="text/javascript" src="/assets/vendors/bootstrap/js/bootstrap.min.js"></script>

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
	<div class="wrap">
		<div class="profile">
			<div class="container">
				<div class="avatar animated fadeInDown">
    <img class="img-circle" src="${user.avatar?default('')}"/>
				</div>
				<h1>${user.nickname?default('未设置昵称')}</h1>

				<h2>${user.sign?default('未设置签名')}</h2>
				<a class="btn btn-white" href="javascript:void(0);" data-id="${user.id}" rel="follow">+ 关注</a>
			</div>
		</div>

		<nav id="profile-navigation" class="profile-navbar">
			<div class="container">
				<div class="content">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="javascript:void(0);)">TA的文章</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container">
			<div class="row">
				<div class="main clearfix">
					<div class="col-xs-12 col-md-12">
						<div class="shadow-box mt20">
							<div class="stream-list">
							<#list data.content as item >
								<div class="stream-item" id="loop-18">
									<div class="blog-rank">
										<div class="votes #if(1 > 0) plus #end">
											1<small>喜欢</small>
										</div>
										<div class="views hidden-xs">
											0<small>评论</small>
										</div>
									</div>
									<div class="summary">
										<h2 class="title"><a href="/view/18">${item.title}</a></h2>

										<div class="excerpt wordbreak hidden-xs">${item.content}</div>

										<!--前端图片显示样式-->

										<div class="foot-block clearfix">
											<div class="author">
												<time>1小时前</time>
											</div>
											<ul class="tags">
											</ul>
											<div class="pull-right hidden-xs">
												<span class="act">浏览 (<i>0</i>)</span>
												<span class="act">喜欢 (<i>1</i>)</span>
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