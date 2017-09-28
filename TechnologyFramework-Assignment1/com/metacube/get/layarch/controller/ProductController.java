package com.metacube.get.layarch.controller;

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

import com.metacube.get.layarch.dao.product.JdbcProductDao;
import com.metacube.get.layarch.facade.DefaultProductFacade;
import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.DefaultProductService;

/**
 * This is a controller class used to perform operation depending on path
 *  @author Preeti Kumawat
 */
@Path("/product")
public class ProductController {
    ProductFacade productFacade;

    /**
     * Constructor to initialize the object
     */
    public ProductController() {
        productFacade = new DefaultProductFacade(new DefaultProductService(
                new JdbcProductDao()));
    }

    /**
     * Method is used to return products list as json object
     * 
     * @return
     *         json object
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {

        return Response.status(Response.Status.OK)
                .entity(productFacade.getAllProducts()).build();

    }
    
    /**
     * Method is used to Gets the product by its id.
     *
     * @param id
     *            the id
     * @return 
     *               the product
     */
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
    }

    /**
     * Method is used to Delete the product by id.
     *
     * @param id
     *            the id
     * @return 
     *               the deleted product
     */
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProductById(@PathParam("id") int id){
    return Response.status(Response.Status.OK).entity(productFacade.deleteProductById(id)).build();
    }

    /**
     * Add the product in database
     *     
     * @param product
     *         product to add
     * @return
     *         added product
     */
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Product product) {
        return Response.status(Response.Status.OK).entity(productFacade.addProduct(product)).build();
    }
    
    /**
     * edit product in the database
     * 
     * @param product
     *         product to update
     * @param id
     *         id of the product
     * @return
     *         updated product
     */
    @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProduct(Product product,@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(productFacade.editProduct(product,id)).build();
    }
}
