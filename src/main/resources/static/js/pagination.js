
$(document).ready(function()
 {
	 var table = $('#usersTable').DataTable( {
		  lengthMenu : [[2,3,4,-1],['2', '3' , '4' , 'All']],
		 "pageLength": 2,
		 "ajax": {
			 url: "http://localhost:8080/api/users",
			 dataSrc:""
			 },
			 "columns": [
				 { "data": "id" },
				 { "data": "firstName" },
				 { "data": "lastName" },
				 { "data": "email" },
				 {data: null, render: function(data, type, row) {
					 return '<button type="button" class="btn fa fa-trash-can icon-dark btn-danger delete-button" data-id="' + row.id + '">Delete</button>';
					 }}
					 ],
					 "paging": true,
					 } );
					  $('#usersTable tbody').on('click', 'tr', function () {
						 var data = table.row(this).data();
						 console.log("delete button click", data.id);
						 $.ajax({
							 url: "http://localhost:8080/api/delete/" + data.id,
							 type: 'DELETE',
							 success: function() {
								 $('#usersTable').DataTable().ajax.reload();
								 }
								 });
								 });
								 } );
								 