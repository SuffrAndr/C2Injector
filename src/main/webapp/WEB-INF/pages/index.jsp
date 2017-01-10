<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>C2注入管理平台</title>

    <!-- Bootstrap Core CSS -->
    <link href="/sbadmin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/sbadmin/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/sbadmin/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/sbadmin/datatables-responsive/css/responsive.dataTables.scss" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/sbadmin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<link href='/sbadmin/smartmenus/css/sm-core-css.css' rel='stylesheet' type='text/css' />
	
	<link href='/sbadmin/datetimepicker/css/bootstrap-datetimepicker.min.css' rel='stylesheet' type='text/css' />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">C2注入管理平台</a>
            </div>
            <!-- /.navbar-header -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="/"><i class="fa fa-dashboard fa-fw"></i>集合</a>
                        </li>
                        <li>
                            <a href="/clips/index"><i class="fa fa-table fa-fw"></i>单集</a>
                        </li>
                        <li>
                            <a href="/files/index"><i class="fa fa-edit fa-fw"></i>文件</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h5 class="page-header">集合列表</h5>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
	                        <form id="categorySearchForm" class="form-inline">
                              <div class="form-group input-group-sm">
                                <label for="assetid">集合ASSETID:</label>
                                <input type="text" class="form-control" id="assetid" name="assetid" placeholder="">
                              </div>
	                          <div class="form-group input-group-sm">
	                            <label for="clipname">集合名称:</label>
	                            <input type="text" class="form-control" id="clipname" name="clipname" placeholder="">
	                          </div>
	                          <div class="form-group input-group-sm">
	                            <label for="status">状态:</label>
								<select id="status" name="status" class="form-control">
                                  <option value="-2">--请选择--</option>
                                  <option value="1">1-初始化增加</option>
                                  <option value="2">2-更新后注入</option>
                                  <option value="3">3-回收</option>
                                  <option value="4">4-ADI生成中</option>
                                  <option value="5">5-ADI已经部署(注入中)</option>
                                  <option value="6">6-注入完成</option>
								</select>	                          
	                          </div>
                              <div class="form-group input-group-sm">
                                <label for="beginDate">注入日期:</label>
	                            <input id="beginDate" name="beginDate" readonly="readonly" class="form-control">
	                            ~
                                <input id="endDate" name="endDate" readonly="readonly" class="form-control">	                            
                              </div>
                              <button type="reset" class="btn btn-default" id="restBtn" name="restBtn">重置</button>	                          
	                          <button type="button" class="btn btn-default" id="queryBtn" name="queryBtn">查询</button>
	                        </form>                        
                        </div>
                        
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
								            <th>
								                <input type="checkbox" class="checkall" />
								            </th>											
											<th>ID</th>
											<th>集合ASSETID</th>
											<th>集合ID</th>
											<th>分类</th>
											<th>集合名称</th>
											<th>导演</th>
											<th>类型</th>
											<th>总集数</th>
											<th>注入时间</th>
											<th>更新时间</th>
											<th>状态</th>
											<th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/sbadmin/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/sbadmin/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/sbadmin/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/sbadmin/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="/sbadmin/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/static/js/sb-admin-2.js"></script>
    
    <script src="/sbadmin/smartmenus/jquery.smartmenus.js" type="text/javascript"></script>
    
    <script src="/sbadmin/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/sbadmin/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    
    <script src="/sbadmin/layer/layer.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
      
    	$('#beginDate').datetimepicker({format: 'yyyy-mm-dd hh:ii:ss',language:"zh-CN",todayHighlight:true,todayBtn:true,autoclose: true});
    	$('#endDate').datetimepicker({format: 'yyyy-mm-dd hh:ii:ss',language:"zh-CN",todayHighlight:true,todayBtn:true,autoclose: true});
    	
    	var table =  $('#dataTables-example').DataTable({
        	 "ajax":{
                url: '/categorys',
                type: 'POST',
                data: function (d) { 
                	d.assetid  = $("#assetid").val();
                    d.clipname  = $("#clipname").val();
                    d.status    = $("#status").val();
                    d.beginDate  = $("#beginDate").val();
                    d.endDate  = $("#endDate").val();
                }
             },
             searching: false,
             paging: true,
             bProcessing: true, 
             bServerSide: true,
             scrollY: 500,
             scrollX: '100%',
             scrollCollapse: true,
             ordering: false,
             pageLength:10,
             lengthChange: true,
             info: true,
             lengthMenu: [10, 20, 50, 100],
             pagingType: "full_numbers",
             deferRender: true,
             columns: [
						{
						    "sClass": "text-center",
						    "data": "id",
						    "render": function (data, type, full, meta) {
						        return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
						    },
						    "bSortable": false
						},						
						{ data: 'id' },
						{ data: 'assetid' },
						{ data: 'originalid' },
						{ data: 'fstname' },
						{ data: 'clipname', 
						  "render": function (data, type, full, meta) {
                                return "<a href='javascript:void(0)' onclick='openCategoryDetail(\""+ full.originalid +"\")'>"+ data + "</a>";
                            }	
						},
						{ data: 'director' },
						{ data: 'kind' },
						{ data: 'serialcount' },
						{ data: 'initalTime' },
						{ data: 'updatetime' },
						{ data: 'status',
							"render": function (data, type, full, meta) {
                                switch (data) {
								case 1:
									return "初始化增加";
									break;
                                case 2:
                                    return "更新后注入";
                                    break;
                                case 3:
                                    return "回收";
                                    break;
                                case 4:
                                    return "ADI生成中";
                                    break;
                                case 5:
                                    return "ADI部署完成";
                                    break;   
                                case 6:
                                    return "注入完成";
                                    break;
                                case 7:
		                            return "注入失败";
		                            break;
	                            default:
									break;
								};
                            }	
						},
						{
                            "sClass": "text-center",
                            "data": "originalid",
                            "render": function (data, type, full, meta) {
                                return "<a href='javascript:void(0)' onclick='openCategoryDetail(\""+ full.originalid +"\")'>单集列表"+ "</a>";
                            },
                            "bSortable": false
                        }
                   ],
           language: {
                       "sProcessing": "处理中...",
                       "sLengthMenu": "显示 _MENU_ 项结果",
                       "sZeroRecords": "没有匹配结果",
                       "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                       "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                       "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                       "sInfoPostFix": "",
                       "sSearch": "搜索:",
                       "sUrl": "",
                       "sEmptyTable": "表中数据为空",
                       "sLoadingRecords": "载入中...",
                       "sInfoThousands": ",",
                       "oPaginate": {
                           "sFirst": "首页",
                           "sPrevious": "上页",
                           "sNext": "下页",
                           "sLast": "末页"
                       },
                       "oAria": {
                           "sSortAscending": ": 以升序排列此列",
                           "sSortDescending": ": 以降序排列此列"
                       }
                   },
         //dom: 'rt<"bottom"filp>'
        });
      
       //table.buttons().container().appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
      
	    $(".checkall").click(function () {
	          var check = $(this).prop("checked");
	          $(".checkchild").prop("checked", check);
	    });
	    
	    $("#queryBtn").click(function()
	    {
	    	table.draw();
	    });
	    
	    });
        
        function openCategoryDetail(id) {
        	layer.open({
        		  title: id + "单集信息",
        		  type: 2, 
        		  //skin: 'layui-layer-rim', 加上边框
        		  area: ['1024px', '650px'], //宽高        		  
        		  content: '/clips/index/' + id,
        		  maxmin: true
        		});
		}
    </script>
</body>
</html>
