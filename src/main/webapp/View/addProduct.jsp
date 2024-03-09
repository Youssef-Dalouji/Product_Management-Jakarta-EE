<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script defer src="../script/script.js"></script>
</head>
<body>
	<div class="principale d-flex flex-column justify-content-between">
    <div class="header">
        <jsp:include page="../Components/header.jsp" />
    </div>

    <div class="body container my-4">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <form id="productForm" action="displayProduct.jsp" method="post">
				    <fieldset>
				        <legend>Add Product</legend>
				        <div class="mb-3">
				            <label class="form-label">Designation</label>
				            <input type="text" id="designation" name="designation" class="form-control" placeholder="Designation">
				        </div>
				        <div class="mb-3">
				            <label class="form-label">Prix</label>
				            <input type="text" id="prix" name="prix" class="form-control" placeholder="Prix">
				        </div>
				        <div class="mb-3">
				            <label class="form-label">Quantite</label>
				            <input type="text" id="quantite" name="quantite" class="form-control" placeholder="Quantite">
				        </div>
				        <button type="submit" class="btn btn-dark">Add</button>
				    </fieldset>
				</form>
            </div>
        </div>
    </div>

    <div class="footer text-center">
        <jsp:include page="../Components/footer.jsp" />
    </div>
</div>
</body>
</html>