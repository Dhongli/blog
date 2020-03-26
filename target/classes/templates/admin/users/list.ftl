
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mtons - 后台管理</title>

    <!-- Bootstrap -->
    <link href="/assets/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/assets/vendors/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="/assets/admin/css/custom.min.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="/assets/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src='/assets/vendors/validate/jquery-validate.js'></script>
    <!-- FastClick -->
    <script src="/assets/vendors/fastclick/lib/fastclick.js"></script>

    <script src="/assets/vendors/layer/layer.js"></script>
    <script src="/assets/vendors/treeTable/jquery.treeTable.min.js"></script>

    <script type="text/javascript">
        window.UEDITOR_HOME_URL = '/assets/vendors/ueditor/';
    </script>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/index" class="site_title"><span>Mtons</span></a>
                </div>

                <div class="clearfix"></div>

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>系统菜单</h3>
                        <ul class="nav side-menu">
                            <li><a href="/admin"><i class="fa fa-home"></i> Home</a>
                            </li>
                                        <li><a href="/admin/posts/list" nav="2"><i class="fa fa-clone icon-xlarge"></i>文章管理</a></li>
                                        <li><a href="/admin/users/list" nav="3"><i class="fa fa-user icon-xlarge"></i>用户管理</a></li>
                                        <li><a href="/admin/comments/list" nav="4"><i class="fa fa-comments-o icon-xlarge"></i>评论管理</a></li>
                                        <li><a href="/admin/group/list" nav="5"><i class="fa fa-tags icon-xlarge"></i>栏目管理</a></li>
                                        <li><a href="/admin/config/" nav="6"><i class="fa fa-sun-o icon-xlarge"></i>系统配置</a></li>
                                        <li><a href="/admin/roles/list" nav="7"><i class="fa fa fa-registered icon-xlarge"></i>角色管理</a></li>
                                        <li><a href="/admin/authMenus/list" nav="8"><i class="fa fa-reorder icon-xlarge"></i>菜单管理</a></li>
                                        <li><a href="/admin/friendLink/list" nav="8"><i class="fa fa-link"></i>友情链接</a></li>

                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="/store/ava/000/00/00/01_100.jpg" alt="">admin
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="/account/profile"> Profile</a></li>
                                <li><a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>用户管理</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
            </div>
        </div>
        <div class="x_content">
            <form id="qForm" class="form-inline">
                <input type="hidden" name="pn" value="" />
                <div class="form-group">
                    <input type="text" name="key" class="form-control" value="" placeholder="请输入关键字">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
		<div class="x_content">
            <table id="dataGrid" class="table table-striped table-bordered b-t">
                <thead>
                <tr>
                    <th width="80">#</th>
                    <th>用户名</th>
                    <th>昵称</th>
                    <th>邮箱</th>
                    <th>角色</th>
                    <th>状态</th>
                    <th width="300"></th>
                </tr>
                </thead>
                <tbody>
            <#list data.content as user>
                <tr>
                    <td class="text-center">${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.nickname}</td>
                    <td>${user.email?default("")}</td>
                    <td>
                    </td>
                    <td>
                        <span class="label label-success">启用</span>
                    </td>
                    <td class="text-center">
                            <a href="javascript:void(0);" class="btn btn-xs btn-default" data-id="36" data-action="close">
                                <i class="fa fa-close"></i> 关闭
                            </a>
                            <a href="/admin/users/pwd?id=36" class="btn btn-xs btn-white">
                                <i class="fa fa-unlock-alt"></i> 修改密码
                            </a>

                            <a href="/admin/users/view?id=36" class="btn btn-xs btn-primary">
                                <i class="fa fa-check-square-o"></i> 修改角色
                            </a>
                    </td>
                </tr>
             </#list>  
                </tbody>
            </table>
		</div>
		<div class="x_content">



<#function active p>
	<#if (data.number+1==p) >
		<#return 'class="active"'>
	<#else>
		<#return ''>
	</#if>
</#function>
<ul class="pagination">
	<#list 1..data.totalPages as i >
    <li ${active(i)}><a href="?pn=${i}">${i}</a></li>
	</#list>
	<#if data.hasNext() >
        <li><a href="list?pn=${data.number+2}" pageNo="${data.number+2}">下一页&nbsp;<i class="fa fa-angle-right"></i>&nbsp;</a></li>
	</#if>
</ul>
		</div>
    </div>
</div>

<script type="text/javascript">
var J = jQuery;

function ajaxReload(json){
    if(json.code >= 0){
        if(json.message != null && json.message != ''){
			layer.msg(json.message, {icon: 1});
        }
        $('#qForm').submit();
    }else{
		layer.msg(json.message, {icon: 2});
    }
}

$(function() {
	// 停用
    $('#dataGrid a[data-action="close"]').bind('click', function(){
		var that = $(this);
		layer.confirm('该账号停用后，将不能登录系统，确定要停用?', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
			 J.getJSON('/admin/users/close', {id: that.attr('data-id'), active: false}, ajaxReload);
        }, function(){
        });
        return false;
    });
	
    // 激活
    $('#dataGrid a[data-action="open"]').bind('click', function(){
		var that = $(this);
		layer.confirm('该账号激活后，将可访问系统中的已授权功能，确定要激活?', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
			 J.getJSON('/admin/users/open', {id: that.attr('data-id'), active: true}, ajaxReload);
        }, function(){
        });
        return false;
    });
})
</script>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Mblog - Powered By <a href="http://mtons.com/?copyright" target="_blank">Mtons</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
    <!-- Custom Theme Scripts -->
    <script src="/assets/admin/js/custom.min.js"></script>
    <script src="/assets/admin/js/app.data.js"></script>
</body>
</html>
