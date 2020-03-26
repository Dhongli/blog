

<!DOCTYPE html>
<html lang="en-US">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>${articleInfo.title}</title>
    <meta name="keywords" content="mtons, ">
    <meta name="description" content="使用windows学习，效率更高。  启动solr服务： java -jar example/start.jar  访问solr控制台： http://localhost:8983/solr/  切换目录到：solr/example/exampl...">
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
<script type="text/javascript" src="/js/date.format.js"></script>


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
                    <div class="shadow-box">
                        <h1 class="post-title">${articleInfo.title}</h1>
                        <div class="clearfix post-other">
            <span class="pull-left author">
                <a class="author-name" href="/ta/1" target="_blank">${articleInfo.user.nickname}</a>
            </span>
                            <time class="pull-left time">2018-09-08</time>
                            <span class="pull-left time">浏览: ${articleInfo.hits}</span>
                            <ul class="tags">
                            </ul>
                            <span class="pull-right action-box"></span>
                        </div>
                        <div class="post-frame">
                            <div class="post-content">
                            ${articleInfo.content}
                            </div>
                            <div class="post-footer">
                                <div class="tip">分享到：</div>
                                <div class="shares">
                                    <!-- Share Button BEGIN -->
                                    <div class="bdsharebuttonbox bdshare-button-24">
                                        <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                                        <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
                                        <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                                        <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                                    </div>
                                    <script>window._bd_share_config = {
                                        "common": {
                                            "bdSnsKey": {"tsina": "3554307689"},
                                            "bdText": "",
                                            "bdMini": "2",
                                            "bdMiniList": false,
                                            "bdPic": "",
                                            "bdStyle": "1",
                                            "bdSize": "24"
                                        }, "share": {}
                                    };
                                    with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
                                    <style>
                                        .bdshare-button-24 a, .bdshare-button-24 .bds_more {
                                            background-image: url("/assets/images/btn/icons_0_24.png");
                                            border-radius: 4px;
                                        }

                                        .bdshare-button-style1-24 a, .bdshare-button-style1-24 .bds_more {
                                            padding-left: 24px;
                                        }
                                    </style>
                                    <!-- Share Button END -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- post/end -->

                    <div id="chat" class="chats shadow-box">
                        <div class="chat_other">
                            <h4>全部评论: <i id="chat_count">4</i> 条</h4>
                        </div>
                        <ul id="chat_container" class="its">
    <li id="chat7">
        <a class="avt fl" target="_blank" href="/ta/1">
            <img src="/assets/images/ava/default.png">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="/ta/1">小豆丁</a><span>1536488138000</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('7', '小豆丁')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">矮油，不错哟，有些人说攻击伤害类型知道不知道也没什么，的确，除了像dota这类竞技地图外对于攻击伤害类型只要知道大部分技能的攻击伤害类型是【法术攻击 魔法伤害】就差不多了。</div> 
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>

    <li id="chat6">
        <a class="avt fl" target="_blank" href="/ta/2">
            <img src="/assets/images/ava/default.png">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="/ta/2">一个怀疑人生的家伙</a><span>1536413393000</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('6', '一个怀疑人生的家伙')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">符合规范合法化</div> <div class="quote"><a href="/ta/3">@邸子豪</a>: 123321<img src="/assets/images/phiz/bad.gif" alt="差劲" title="差劲"></div>
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>

    <li id="chat5">
        <a class="avt fl" target="_blank" href="/ta/3">
            <img src="/assets/images/ava/default.png">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="/ta/3">邸子豪</a><span>1536413355000</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('5', '邸子豪')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">123321<img src="/assets/images/phiz/bad.gif" alt="差劲" title="差劲"></div> 
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>

    <li id="chat3">
        <a class="avt fl" target="_blank" href="/ta/2">
            <img src="/assets/images/ava/default.png ">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="/ta/2">一个怀疑人生的家伙</a><span>1536413284000</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('3', '一个怀疑人生的家伙')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">发撒法守法</div> 
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>
</ul>
                        <div id="pager" class="text-center"></div>
                        <div class="cbox-wrap">
                            <div class="cbox-title">我有话说: <span id="chat_reply" style="display:none;">@<i id="chat_to"></i></span>
                            </div>
                            <div class="cbox-post">
                                <div class="cbox-input">
                                    <textarea id="chat_text" rows="3" placeholder="请输入评论内容"></textarea>
                                    <input type="hidden" value="0" name="chat_pid" id="chat_pid">
                                </div>
                                <div class="cbox-ats clearfix">
                                    <div class="ats-func">
                                        <ul class="func-list">
                                            <li class="list-b">
                                                <a href="javascript:void(0);" class="join" id="c-btn"><i class="fa fa-smile-o fa-2"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="ats-issue">
                                        <button id="btn-chat" class="btn btn-success btn-sm bt">发送</button>
                                    </div>
                                </div>
                            </div>
                            <div class="phiz-box" id="c-phiz" style="display:none">
                                <div class="phiz-list" view="c-phizs"></div>
                            </div>
                        </div>
                    </div>
                
                </div>
                <!-- right sidebar-->
                <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
                    <ul class="list-group about-user">
                        <li class="list-group-item user-card" >
                            <div class="ava">
                                <a href="/ta/1">
    <img class="img-circle" src="/assets/images/ava/default.png"/>
                                </a>
                            </div>
                            <div class="user-info">
                                <div class="nk mb10">小豆丁</div>
                                <div class="mb6">
                                    <a class="btn btn-success btn-xs" href="javascript:void(0);" data-id="1" rel="follow">+ 关注</a>
                                </div>
                            </div>
                        </li>

                        <li class="list-group-item">
                            <div class="user-datas">
                                <ul>
                                    <li><strong>8</strong><span>发布</span></li>
                                    <li class="noborder"><strong>0</strong><span>评论</span></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a class="btn btn-success btn-sm" href="javascript:void(0);" data-id="${articleInfo.id}" rel="favor">喜欢</a>
                            <strong id="favors">${articleInfo.xihuan}</strong> 喜欢
                        </li>
                    </ul>
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

    	maxResults :10,
        // callback
        onLoadHot : function (i, data) {
        	var url = '/view/' + data.id;
      		var item = jQuery.format(hot_li_template, i + 1, url, data.title, numberScale(data.views));
      		return item;
        },
        onLoadLatest : function (i, data) {
        	var url = '/view/' + data.id;
      		var item = jQuery.format(latest_li_template, i + 1, url, data.title, numberScale(data.views));
      		return item;
        },
        onLoadHotUser : function (i, data) {
        var url = '/ta/' + data.id;
      		var item = jQuery.format(hotUser_li_template,data.avatar,url,data.name, data.fans);
      		return item;
        }
	});
});
</script>                </div>
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
</script>
<script type="text/plain" id="chat_template">
    <li id="chat{5}">
        <a class="avt fl" target="_blank" href="/ta/{0}">
            <img src="{1}">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="/ta/{0}">{2}</a><span>{3}</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('{5}', '{2}')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">{4}</div> {6}
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>
</script>

<script type="text/javascript">
    function goto(pid, user) {
        document.getElementById('chat_text').scrollIntoView();
        $('#chat_text').focus();
        $('#chat_text').val('');
        $('#chat_to').text(user);
        $('#chat_pid').val(pid);

        $('#chat_reply').show();
    }
    var container = $("#chat_container");
    var template = $('#chat_template')[0].text;

    seajs.use('comment', function (comment) {
        comment.init({
            load_url: '/comment/list/${articleInfo.id}',
            post_url: '/comment/submit',
            toId: '${articleInfo.id}',
            onLoad: function (i, data) {
				
                var content = ContentRender.wrapItem(data.content);

                var quoto = '';
                if (data.target) {
                    var pat = data.target;
                    var pcontent = ContentRender.wrapItem(pat.content);
                    quoto = '<div class="quote"><a href="/ta/' + pat.author.id + '">@' + pat.author.nickname + '</a>: ' + pcontent + '</div>';
                }
                var item = jQuery.format(template,
                        data.author.id,
                        data.author.avatar,
                        data.author.nickname,
                        new Date(data.created).format("yyyy-MM-dd hh:mm:ss"),
                        content,
                        data.id, quoto);
                return item;
            }
        });
    });

    seajs.use('phiz', function (phiz) {
        $("#c-btn").jphiz({
            base: '/assets',
            textId: 'chat_text',
            lnkBoxId: 'c-lnk',
            phizBoxId: 'c-phiz'
        });
    });

</script>
</body>
</html>

