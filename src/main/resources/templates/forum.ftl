<#--include "/plugins/paging.ftl"-->

<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>博文</title>
    <meta name="keywords" content="mtons, mtons,博客,社区,摄影,旅游,艺术,娱乐">
    <meta name="description" content="Mtons, 轻松分享你的兴趣. 便捷的文字、图片发布,扁平化的响应式设计,美观、大气,是您记录生活的最佳选择">
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
                    <!-- left -->
                    <div class="col-xs-12 col-md-9 side-left">
<#function active ord>
	<#if (RequestParameters.ord?default('')==ord) >
		<#return 'class="active"'>
	<#else>
		<#return ''>
	</#if>
</#function>
<div class="shadow-box">
	<!-- tab -->
	<div class="filter">
		<ul class="">
			<li><a ${active('newest')} href="?ord=newest"><i class="fa fa-newspaper-o"></i>最新的</a></li>
			<li><a ${active('hottest')} href="?ord=hottest"><i class="fa fa-fire"></i>热门的</a></li>
			<!--
			<li><a href="/blogs/hottest">全部的</a></li>
			-->
		</ul>
	</div>
	<!-- tab end -->
	<!-- tab panes -->
	<div class="stream-list p-stream">

<#list articleList as item> 
<div class="stream-item" id="loop-10">
    <div class="summary">
        <a href="/view/${item.id}.html">
            <div class="title"><h2>${item.title}</h2></div>
            <!--<div class="excerpt wordbreak hidden-xs">$!{row.summary} </div>-->
        </a>
        <!--前端图片显示样式-->

    </div>
    <div class="p-rank clearfix">
        <div class="users">
            <a href="/ta/1">
                <div class="ava">
    <img class="img-circle" src="/assets/images/ava/default.png"/>
                </div>
            </a>
            <div class="info">
                <strong> ${item.user.nickname}</strong>
                <time> ${item.createTime?string('yyyy-MM-dd')}</time>
                <time> ${item.createTime?string('HH:mm:ss')}</time>
            </div>

        </div>
        <div class="counts">
            <span class="act"><i class="praise_icon"></i>${item.xihuan}</span>
            <span class="act"><i class="comment_icon"></i>${item.pinglun}</span>
        </div>

        <div class="foot-block clearfix">
            <ul class="tags">
            </ul>
        </div>

    </div>
</div>
</#list>


	</div>
</div>
<div class="text-center clr">
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<link rel='stylesheet' media='all' href='/css/jquery.pagination.css'/>
<script>
$(function(){
	$('#pagebox').pagination({
		current:${pageInfo.number+1},
	    pageCount: ${pageInfo.totalPages},
	    jump: true,
	    callback: function (api) {
			console.log(api.getCurrent());
			window.location.href='?page='+api.getCurrent()+'&ord=${RequestParameters.ord?default('')}';
	    }
	});
});
</script>
<ul class="m-style M-box3" id="pagebox">
<!--
    <li class="active"><a href="javascript:void(0);"><span>1</span></a></li>
-->
</ul>
</div>

                    </div>
                    <!-- right sidebar-->
                    <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
<div class="widget-box shadow-box">
	<div class="title">
		<h3><i class="fa fa-users "></i> 热门用户</h3>
	</div>
	<ul id="hotuser" class="hotusers">

        <img src="/assets/images/spinner.gif">

	</ul>
</div>

<div class="widget-box shadow-box">
	<div class="title">
		<h3>
		<i class="fa fa-area-chart"></i> 热门文章
			<a href="" class="rrh-refresh"><i class="fa fa-refresh"></i>换一批</a>
		</h3>
		
	</div>
	<ul class="box-list" id="hots">
		<li class="text-center"><img src="/assets/images/spinner.gif"></li>
	</ul>
</div>

<div class="widget-box shadow-box">
	<div class="title">
		<h3><i class="fa fa-bars"></i> 最新发布
		<a href="" class="rrh-refresh">查看更多</a></h3>
	</div>
	<ul class="box-list" id="latests">
        <li class="text-center"><img src="/assets/images/spinner.gif"></li>
	</ul>
</div>


<script type="text/javascript">
var hot_li_template = '<li><div class="li-out"><span class="last"><i>{0}</i></span><span class="name"><a  href="{1}">{2}</a></span><span class="nums">{3}</span></div></li>'
var latest_li_template = '<li><div class="li-out"><span class="name"><a  href="{1}">{2}</a></span><span class="nums">{3}</span></div></li>'

var hotUser_li_template = '<li class=""><a  href="{1}"><img src="{0}" class="imguser"/></a></li>'

seajs.use('sidebox', function (sidebox) {
	sidebox.init({
        latestUrl : '/api/latests.json',
    	hotUrl : '/api/hots.json',
		hotTagUrl : '/api/hot_tags.json',
		hotUserUrl:'/api/hotusers.json',

    	maxResults :8,
        // callback
        onLoadHot : function (i, data) {
        	var url = '/view/' + data.id+'.html';
      		var item = jQuery.format(hot_li_template, i + 1, url, data.title, numberScale(data.hits));
      		return item;
        },
        onLoadLatest : function (i, data) {
        	var url = '/view/' + data.id+'.html';
      		var item = jQuery.format(latest_li_template, i + 1, url, data.title, numberScale(data.hits));
      		return item;
        },
        onLoadHotUser : function (i, data) {
        var url = '/ta/' + data.id;
      		var item = jQuery.format(hotUser_li_template,data.avatar,url,data.name, data.fans);
      		return item;
        }
	});
});
</script>                    </div>
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
