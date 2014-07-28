<%@ include file="header.jsp" %>
<!-- rest web services -->
<script>
$(document).ready(function(){
	
	
	
	
	
		
	$('#restPostBtn').click(function(){
		var summaryVal = $('#summary').val();
		var descriptionVal = $('#Description').val();
		
		/* 
		$.ajax({
			url: "http://localhost:8080/strutsProject/rest/todo/postRest",
			type: 'POST',
	        contentType: 'application/json',
	        dataType: 'json',
	        data: JSON.stringify({summary:summaryVal,description:descriptionVal}),
			}).done(function(data) {
				var aArray = data.a;
				$.each(aArray,function(key, value){
					console.log(value);
				});
				console.log(data);
		}); 
				
		$.ajax({
			url: "http://localhost:8080/strutsProject/rest/todo/postRestList",
			type: 'POST',
	        contentType: 'application/json',
	        dataType: 'json',
	        data: JSON.stringify({summary:summaryVal,description:descriptionVal}),
			}).done(function(data) {
				
				$.each(data,function(key, value){
					console.log(value);
				});
				console.log(data);
		}); 
		*/
		
		$.ajax({
			url: "http://localhost:8080/strutsProject/rest/todo/postRestListGet?summary="+summaryVal+"&description="+descriptionVal,
			type: 'GET',
	        contentType: 'application/json',
	        dataType: 'json',
	        
			}).done(function(data) {
				
				var aArray = data.a;
				$.each(aArray,function(key, value){
					console.log(value);
				});
				console.log(data);
		}); 
				
	});
	
	
	
	$('#restLoginBtn').click(function(){
	
		var userNameVal = $('#restUserName').val();
		var passWordVal = $('#restPassWord').val();
		
		
		$.ajax({
			url: "http://localhost:8080/strutsProject/rest/todo/postRestLogin",
			type: 'POST',
	        contentType: 'application/json',
	        
	        data: JSON.stringify({userName:userNameVal,passWord:passWordVal}),
			}).done(function(data) {
				console.log(data);
				if(data=='success'){
					console.log('here');
					$('#restLogin').submit();
				}
			}).fail(function() {
				console.log('error');
			});  
		
		
		
	});
	
	$('#getSampleData').click(function(){
		$.ajax({
			url: "http://localhost:8080/strutsProject/rest/todo/getSampleData",
			type: 'GET',
	        contentType: 'application/json',
	        dataType: 'json',
	        
			}).done(function(data) {
				
				var datasets = [];
			  
				for(var i=0; i < data.sampleData.length; i++){
				
					var dataset = new Object();
					dataset.key = data.sampleData[i].key;
					dataset.field1 = data.sampleData[i].field1;
					dataset.field2 = data.sampleData[i].field2;
					datasets.push(dataset);
					
				}
							
				console.log(datasets);
				var sampleData = $('#sampleData').html(),
				sampleDataTemplate = Handlebars.compile(sampleData),
				sampleDataHTML = sampleDataTemplate(datasets);
	
				$('#tableHolder').append(sampleDataHTML);
				
			}); 
				
	});
	
	
	 
});
</script>


	
<script id="sampleData" type="text/x-handlebars-template">
<table border="1">
	<thead>
		<tr>
			<td>key</td>
			<td>field1</td>
			<td>field2</td>
		</tr>
	</thead>
	<tbody>
		{{#each this}}
			<tr>
				<td>{{this.key}}</td>
				<td>{{this.field1}}</td>
				<td>{{this.field2}}</td>
			</tr>	
		{{/each}}
	</tbody>
</table>
</script>



<div class="container">
	<form method="POST" action="login"/>
	<div class="row">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
		<s:if test="%{#request.loginErrorMessage != null }">
			<div class="alert alert-danger" role="alert">	
				<s:property value="%{#request.loginErrorMessage}"/>
			</div>
		</s:if>
		UserName: <input type="text" name="userBean.userName" class="form-control">
		Password: <input type="password" name="userBean.passWord" class="form-control">
		<br>
		<button type="submit" class="form-control"> submit</button>
	
	
	
	</div>
	<div class="col-xs-4"></div>
	</div>
	</form>
	
	
	<h1>Rest web service </h1>
<!--   Rest web service  	 -->
	
	<div class="row">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
		
		Summary: <input type="text" id="summary" class="form-control">
		Description: <input type="text" id="Description" class="form-control">
		
		<button id="restPostBtn" type="button" class="form-control"> postBtn</button>
	
	
	
	</div>
	<div class="col-xs-4"></div>
	</div>
	
	<h1>Rest web service Login</h1>
	
	<form method="POST" action="login" id="restLogin"/>
	<div class="row">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
		<s:if test="%{#request.loginErrorMessage != null }">
			<div class="alert alert-danger" role="alert">	
				<s:property value="%{#request.loginErrorMessage}"/>
			</div>
		</s:if>
		UserName: <input id="restUserName" type="text" name="userBean.userName" class="form-control">
		Password: <input id="restPassWord" type="password" name="userBean.passWord" class="form-control">
		<br>
		<button type="button" id="restLoginBtn" class="form-control"> submit</button>
	
	
	
	</div>
	<div class="col-xs-4"></div>
	</div>
	</form>
</div>

	<div class="row">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
		<button type="button" id="getSampleData" class="form-control">getData</button>
	
	</div>
	<div class="col-xs-4"></div>
	</div>
	
	<div class="row">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
			<div id="tableHolder"></div>
	</div>
	<div class="col-xs-4"></div>
	</div>
<%@ include file="Footer.jsp" %>