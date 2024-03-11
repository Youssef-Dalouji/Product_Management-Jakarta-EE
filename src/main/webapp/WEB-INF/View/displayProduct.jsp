<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script defer src="script/script.js"></script>
</head>
<body>
	<div class="principale d-flex flex-column justify-content-between">
    <div class="header">
        <jsp:include page="../Components/header.jsp" />
    </div>

    <div class="body container my-4">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card text-bg-secondary mb-3">
                    <div class="card-header">Product</div>
                    <div class="card-body">
                        <h5 class="card-title">${model.getDesignation() }</h5>
                        <p class="card-text">${model.getId() }</p>
                        <p class="card-text">${model.getPrix() }</p>
                        <p class="card-text">${model.getQuantite() }</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer text-center">
        <jsp:include page="../Components/footer.jsp" />
    </div>
</div>
</body>
</html>