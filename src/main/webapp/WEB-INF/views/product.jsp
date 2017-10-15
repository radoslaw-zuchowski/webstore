<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Produkt - szczegóły</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Produkt</h1>
				<p>Szczegóły ${product.name}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/${product.productId}.jpg"></c:url>" alt="image" style="width: 100%" />
		</div>

			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name}</h3>
						<p>Id: ${product.productId}</p>
						<p>Cena: ${product.price} PLN</p>
						<p>Opis: ${product.description}</p>
						<p>Producent: ${product.manufacturer}</p>
						<p>Kategoria: ${product.category}</p>
						
						<p>${product.unitsInStock} sztuk na magazynie</p>
						<p>${product.unitsInOrder} sztuk w zamówieniach</p>
						<p>Wycofany: ${product.discontinued}</p>
						<p>Stan: ${product.condition}</p>
						
						<a href="<spring:url value="/products" />" class="btn btndefault">
							<span class="glyphicon-hand-left glyphicon"></span> Wstecz
						</a>


						<p>
							<a href="#" class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz
							</a>
						</p>

					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>