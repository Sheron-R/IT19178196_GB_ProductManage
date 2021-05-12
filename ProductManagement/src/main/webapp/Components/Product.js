$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();

});

// SAVE ============================================

$(document).on("click", "#btnSave", function(event)
		{
		// Clear alerts---------------------
			$("#alertSuccess").text("");
			$("#alertSuccess").hide();
			$("#alertError").text("");
			$("#alertError").hide();
		// Form validation-------------------
		var status = validateProductForm();
		if (status != true)
		{
			$("#alertError").text(status);
			$("#alertError").show();
		return;
		}
		// If valid------------------------
		var type = ($("#hidProductIDSave").val() == "") ? "POST" : "PUT";
		$.ajax({
				url : "ProductsAPI",
				type : type,
				data : $("#formProduct").serialize(),
				dataType : "text",
				complete : function(response, status)
				{
				onProductSaveComplete(response.responseText, status);
				}
				});
			});
	
//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
     $("#hidProductIDSave").val($(this).data("PID"));
     $("#productname").val($(this).closest("tr").find('td:eq(0)').text()); 
	 $("#productcode").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#productquantity").val($(this).closest("tr").find('td:eq(2)').text()); 
	 $("#productdescription").val($(this).closest("tr").find('td:eq(3)').text()); 
	 $("#productprice").val($(this).closest("tr").find('td:eq(4)').text()); 
	 $("#productavailable").val($(this).closest("tr").find('td:eq(5)').text()); 
});

//delete====================================================
$(document).on("click", ".btnRemove", function(event)	
		
		{
		$.ajax(
		{
		url : "ProductsAPI",
		type : "DELETE",
		data : "PID=" + $(this).data("productid"),
		dataType : "text",
		complete : function(response, status)
		{
		 location.reload(true);
		onProductDeleteComplete(response.responseText, status);
		}
		
	});
		
});


// CLIENT-MODEL================================================================
function validateProductForm() 
{ 
	    // NAME
		if ($("#productname").val().trim() == "") 
		 { 
		 return "Insert Item Name."; 
		 } 
 
		// CODE
		if ($("#productcode").val().trim() == "") 
		 { 
		 return "Insert Product Code."; 
		 } 
				 
		 // QUANTITY
		if ($("#productquantity").val().trim() == "") 
		 { 
		 return "Insert Product Quantity."; 
		 } 
		 
		 // DESCRIPTION------------------------
		if ($("#productdescription").val().trim() == "") 
		 { 
		 return "Insert Product Description."; 
		 } 
		
		// PRICE-------------------------------
		if ($("#productprice").val().trim() == "") 
		 { 
		 return "Insert Product Price."; 
		 } 
		
		 // AVAILABILITY
		if ($("#productavailable").val().trim() == "") 
		 { 
		 return "Insert Product Availability."; 
		 } 
		 
		return true; 
}

function onProductSaveComplete(response, status) {
	if (status == "success") {
		window.location.reload();
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divProductsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#hidProductIDSave").val("");
	$("#formProduct")[0].reset();
}


function onProductDeleteComplete(response, status) {
	if (status == "success") {
		window.location.reload();
		//window.location.reload();
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divProductsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}




