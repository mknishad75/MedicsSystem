<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
 <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>  
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.35/pdfmake.min.js"></script>  
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.35/pdfmake.js"></script>                                
<!--  <link rel="stylesheet" type="text/css" href="/css/jquery.dataTables.min.css">
<script src="/js/jquery.min.js"></script> 

<script src="/js/jquery.dataTables.min.js"></script>   -->
 <!--    <script type="text/javascript">
$(document).ready(function() {
    
    $("#example").dataTable( {
    	dom:'Bfrtip',
    	buttons:[ 'copy' , 'pdf'
    	          ] 
          	
    } );
    </script>  -->
<script type="text/javascript">
$(document).ready(function() {
    
    $("#example").dataTable( {
    	dom:'Bfrtip',
    	buttons:[ 'copy' , 'pdfHtml5'
    	          ] ,
          	
    	      /*     "bProcessing": false,
    	         "bServerSide": false,
    	          "sort": "position",
    	       */    
    	          
        "sAjaxSource": "./PaginationValue",
        "aoColumns": [
                      
            { "mData": "hospitalId" },         
            { "mData": "patientId" },
			{ "mData": "patitentName" },
			{ "mData": "patitentAddress" },			
			
					
			{	
				"render": function (data, type, JsonResultRow, meta) {
                	return '<form action="${pageContext.request.contextPath}/myservlet" method="post"><input type="hidden" name="hospitalId" value="'+JsonResultRow.hospitalId+'"/><input type="submit" name="View" value="View"/><input type="submit" name="Update" value="Update"/><input type="submit" name="Delete" value="Delete"/></form>'
				}
            },
			
        ]
    
    
        
    } );

} );

</script>
</head>
<body style="background-image: url('/images/background.jpg');">
<div class="container">
	<div class="row">
		<div class="col-sm-10 col-sm-offset-2"  style="text-align: center;"> 
			<!-- <form action=""> -->
				<h2 style="color: whitesmoke">Room Details<br><br></h2>
				<table width="80%" style="border: 6px;background: rgb(243, 244, 248);background-color: #8f94a4; ">
					<tr>
						<td>
						    <table id="example" class="display" cellspacing="0" width="100%" >
						        <thead>
						            <tr>
						                <th>Hospital ID</th>
						            	<th>Patitent ID</th>
						                <th>Patitent Name</th>
						                <th>Address</th>
						                 <th>action</th>           
						            </tr>
						        </thead>       
						    </table>
				    	</td>
				    </tr>
				</table>
			<!-- </form> -->
		</div>
	</div>
</div>

</body>
</head>



</html>