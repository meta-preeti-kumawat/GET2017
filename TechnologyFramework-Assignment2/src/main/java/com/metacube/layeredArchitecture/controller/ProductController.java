package main.java.com.metacube.layeredArchitecture.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.spring.Factory;

@Path("/product")
public class ProductController {
	ProductFacade productFacade;

	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean("productFacade", ProductFacade.class);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();
	}
	
	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("productId") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
	}
	
	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(Product product) {
		return Response.status(Response.Status.OK).entity(productFacade.addProduct(product)).build();
	}
	
	@DELETE
	@Path("/deleteProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@PathParam("id") int id){
		return Response.status(Response.Status.OK).entity(productFacade.deleteProductById(id)).build();
	}
	
	@PUT
	@Path("/updateProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProduct(Product product, @PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.updateProduct(product, id)).build();
	}
}