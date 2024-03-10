<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <div class="principale d-flex flex-column justify-content-between">
    <div class="header">
        <jsp:include page="../Components/header.jsp" />
    </div>

    <div class="body container my-4">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card text-bg-dark">
                    <img src="photo/productphoto.jpeg" class="card-img" alt="product">
                    <div class="card-img-overlay">
                        <h5 class="card-title">Product Management</h5>
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