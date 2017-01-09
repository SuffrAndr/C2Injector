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
	
	<link href='//sbadmin/touchspin/jquery.bootstrap-touchspin.min.css' rel='stylesheet' type='text/css' />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div class="container-fluid">
            <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-body">
	                        <form id="categorySearchForm" class="form-inline">
                              <div class="form-group input-group-sm">
                                <label for="originalid">单集ID:</label>
                                <input type="text" class="form-control" id="originalid" name="originalid" placeholder="">
                              </div>
                              <div class="form-group input-group-sm">
                                <label for="partname">单集名称:</label>
                                <input type="text" class="form-control" id="partname" name="partname" placeholder="">
                              </div>
                              <div class="form-group input-group-sm">
                                <label for="serialno">集号:</label>
                                <input type="text" class="form-control" id="serialno" name="serialno" placeholder="" value="">
                              </div>                              
	                          <div class="form-group input-group-sm">
	                            <label for="status">状态:</label>
								<select id="status" name="status" class="form-control">
								  <option value="-2">--请选择--</option>
								  <option value="-1">-1-重复注入</option>
                                  <option value="1">1-初始化增加</option>
                                  <option value="2">2-更新后注入</option>
                                  <option value="3">3-回收</option>
                                  <option value="4">4-ADI生成中</option>
                                  <option value="5">5-ADI已经部署(注入中)</option>                                 
                                  <option value="6">6-注入完成</option>
								</select>	                          
	                          </div>
	                          <button type="reset" class="btn btn-default" id="crestBtn" name="crestBtn">重置</button>
	                          <button type="button" class="btn btn-default" id="queryBtn" name="queryBtn">查询</button>
	                        </form>                        
                        </div>
                        
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
											<th>ID</th>
											<th>单集ID</th>
											<th>单集名称</th>
											<th>看点</th>
											<th>时长(S)</th>
											<th>集号</th>
											<th>期数</th>
											<th>状态</th>
											<th>初始化时间</th>
                                            <th>
                                                                                                                                操作
                                            </th>											
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

            <div class="row">
                    <div class="panel panel-default">
                        <form id="fileSearchForm" class="form-inline">
                              <div class="form-group input-group-sm">
                                <input type="hidden" id="oripartid" name="oripartid" value="-AAAA">
                                <label for="fstatus">状态:</label>
                                <select id="fstatus" name="fstatus" class="form-control">
                                  <option value="-2">--请选择--</option>
                                  <option value="-1">-1-重复注入</option>
                                  <option value="1">1-初始化增加</option>
                                  <option value="2">2-更新后注入</option>
                                  <option value="3">3-回收</option>
                                  <option value="4">4-ADI部署中</option>
                                  <option value="4">4-ADI生成中</option>                                 
                                  <option value="6">6-注入完成</option>
                                </select>                             
                              </div>
                              <div class="form-group input-group-sm">
                                <label for="downloadStatus">下载状态:</label>
                                <select id="downloadStatus" name="downloadStatus" class="form-control">
                                  <option value="-2">--请选择--</option>
                                  <option value="-1">下载失败</option>
                                  <option value="1">未下载(即缺失)</option>
                                  <option value="2">已下载(拷贝到硬盘中)</option>
                                  <option value="3">已经删除(FTP方式适用)</option>
                                </select>                             
                              </div>
                              <div class="form-group input-group-sm">
                                <label for="fileformatdesc">清晰度:</label>
                                <select id="fileformatdesc" name="fileformatdesc" class="form-control">
                                  <option value="-1">--请选择--</option>
                                  <option value="0">0-流畅</option>
                                  <option value="1">1-标清</option>
                                  <option value="2">2-高清</option>
                                  <option value="3">3-超清</option>
                                  <option value="4">4-4k(H265) </option>
                                </select>                             
                              </div>
                              <button type="reset" class="btn btn-default" id="frestBtn" name="frestBtn">重置</button>                                                        
                              <button type="button" class="btn btn-default" id="fqueryBtn" name="fqueryBtn">查询</button>
                            </form>                        
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="fileTbl">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>单集ID</th>
                                            <th>清晰度</th>
                                            <th>状态</th>
                                            <th>下载状态</th>
                                            <th>URL前缀</th>
                                            <th>文件路径</th>
                                            <th>码率</th>
                                            <th>初始化时间</th>
                                            <th>创建时间</th>
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
    
    <script src="/sbadmin/touchspin/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	
    	$("input[name='serialno']").TouchSpin();
    	
    	var table =  $('#dataTables-example').DataTable({
        	 "ajax":{
                url: '/clips/' + '${categoryOriginalid}',
                type: 'POST',
                data: function (d) { 
                	d.assetid  = $("#assetid").val();
                	d.status    = $("#status").val();
                	
                	d.serialno = $("#serialno").val();
                	if(d.serialno == "")
                	{
                		d.serialno = 0;
                	}
                	
                    d.partname    = $("#partname").val();
                    d.originalid    = $("#originalid").val();
                }
             },
             searching: false,
             paging: true,
             bProcessing: true, 
             bServerSide: true,
             scrollY: 480,
             scrollX: 480,
             scrollCollapse: true,
             ordering: false,
             pageLength:5,
             lengthChange: true,
             info: true,
             lengthMenu: [5, 10, 20, 50],
             pagingType: "full_numbers",
             deferRender: true,
             columns: [
						{ data: 'id' },
						{ data: 'originalid' },
						{ data: 'partname'},
						{ data: 'awards'},
						{ data: 'duration'},
						{ data: 'serialno'},
						{ data: 'periods'},
						{ data: 'status' },
						{ data: 'initalTime'},
						{
                            "sClass": "text-center",
                            "data": "originalid",
                            "render": function (data, type, full, meta) {
                            	return "<a href='javascript:void(0)' onclick='viewFileDetail(\""+ full.originalid +"\")'>文件列表"+ "</a>";
                            },
                            "bSortable": false
                        },
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
         buttons: [
                   'copy', 'excel', 'pdf'
                  ]
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
    
    var fileTbl =  $('#fileTbl').DataTable({
        "ajax":{
           url: '/queryfiles',
           type: 'POST',
           data: function (d) { 
               d.oripartid      = $("#oripartid").val();
        	   d.status         = $("#fstatus").val();
               d.downloadStatus = $("#downloadStatus").val();
               d.fileformatdesc = $("#fileformatdesc").val();
           }
        },
        searching: false,
        paging: true,
        bProcessing: true, 
        bServerSide: true,
        scrollY: 300,
        scrollX: 1200,
        scrollCollapse: true,
        ordering: false,
        pageLength:5,
        lengthChange: false,
        info: true,
        //lengthMenu: [5, 10, 20, 50, 100],
        pagingType: "full_numbers",
        deferRender: true,
        columns: [
                   { data: 'id' },
                   { data: 'oripartid'},
                   { data: 'fileformatdesc'},
                   { data: 'status' },
                   { data: 'downloadStatus' },
                   { data: 'urlPrefix'},
                   { data: 'filename'},
                   { data: 'filebitrate'},
                   { data: 'initalTime'},
                   { data: 'createtime'}
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
    buttons: [
              'copy', 'excel', 'pdf'
             ]
   });  
    
            $("#fqueryBtn").click(function()
            {
            	fileTbl.draw();
            });
    
	    function viewFileDetail(id) {
	    	
	    	$("#oripartid").val(id);
	    	
	    	fileTbl.draw();
		}
    
    
       function openCategoryDetail(id) {
        layer.open({
              title: id + "单集信息",
              type: 2, 
              //skin: 'layui-layer-rim', 加上边框
              area: ['1024px', '600px'], //宽高                 
              content: '/clips/index/' + id,
              maxmin: true
            });
    }    
    </script>
</body>
</html>
