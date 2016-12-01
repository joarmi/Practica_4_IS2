/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Javier Argente Micó y Santiago Castelló Beltrán
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class ShoppingCart.
     */
    /*Comprobamos que el metodo getBalance suma bien los productos, comprobandolo con la suma realizada 
      por nosotros mediante un assertEquals*/
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        ShoppingCart instance = new ShoppingCart();
        
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        Product p3 = new Product("Teclado", 5.5);
        Product p4 = new Product("Monitor 4K", 550.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        instance.addItem(p3);
        instance.addItem(p4);
        
        double precio_total = 642.9;
        
        double result = instance.getBalance();
        assertEquals(precio_total, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class ShoppingCart.
     */
    /*Este test comprueba si se anyaden correctamente items al carrito, se comprueba mediante un assertTrue 
      llamando a findProduct*/
    @Test
    public void testAddItem() {
       
        System.out.println("AddItem");
        
        /*ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        Product p3 = new Product("Teclado", 5.5);
        Product p4 = new Product("Monitor 4K", 550.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        instance.addItem(p3);
        instance.addItem(p4);
        
        assertEquals(instance.getItemCount(), 4, 0.0);*/
        
        /*----------------------------------------------*/
        
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        
        instance.addItem(p1);
        
        assertTrue(instance.findProduct("Galletas"));
        
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     */
    /*Anyadimos un elemento y lo borramos para ver si el metodo RemoveItem funciona correctamente*/
    @Test
    public void testRemoveItem() throws Exception {
        
        System.out.println("RemoveItem");
        
        /*ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        Product p3 = new Product("Teclado", 5.5);
        Product p4 = new Product("Monitor 4K", 550.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        instance.addItem(p3);
        instance.addItem(p4);
        
        try{
            
            instance.removeItem(p1);
            
        } catch(Exception e){
            
            fail("No existe");
            
        }*/
        
        /*---------------------------------------------*/
        
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        
        instance.addItem(p1);
        
        try{
            
            instance.removeItem(p1);
            
        } catch(Exception e){
            
            assertTrue(instance.isEmpty());
            
        }
        
    }
    
    /*Se crea un carrito vacio y se intenta eliminar un producto cuando este no tiene ninguno, debemos obtener un fallo*/
    @Test
    public void  testRemoveItemCarroVacio() {
        
        System.out.println("RemoveItemCarroVacio");
        
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        
        try{
            
            instance.removeItem(p1);
            fail("The test case is a prototype.");
            
        } catch(Exception e){
            
        }
        
    }

    /**
     * Test of getItemCount method, of class ShoppingCart.
     */
    /*Mientras vamos anyadiendo productos, comprobamos si estos se cuentan correctamente estos anyadidos con un assertEquals*/
    @Test
    public void testGetItemCount() {
        
        System.out.println("GetItemCount");
        
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        
        instance.addItem(p1);
        
        assertEquals(instance.getItemCount(), 1, 0.0);
        
        Product p2 = new Product("Raton", 85.6);
        Product p3 = new Product("Teclado", 5.5);
        
        instance.addItem(p2);
        instance.addItem(p3);
        
        assertEquals(instance.getItemCount(), 3, 0.0);
        
        
    }

    /**
     * Test of empty method, of class ShoppingCart.
     */
    /*Comprobamos que la funcion empty funciona correctamente, para ello llenamos el carrito con varios productos 
      y posteriormente lo vaciamos mediante la funcion empty y comprobamos con un assert que es igual a 0*/
    @Test
    public void testEmpty() {
        
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        Product p3 = new Product("Teclado", 5.5);
        Product p4 = new Product("Monitor 4K", 550.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        instance.addItem(p3);
        instance.addItem(p4);
        
        try{
            
            instance.empty();
            
        } catch(Exception e){
            
        }
        
        assertEquals(instance.getItemCount(), 0, 0.0);
        
    }

    /**
     * Test of isEmpty method, of class ShoppingCart.
     */
    /*Comprobamos que el carro esta vacio en 3 casos distintos, cuando se crea un carrito, cuando se llama a la 
      funcion empty, y cuando se vacia mediante la eliminacion de todos sus elementos*/
    @Test
    public void testIsEmpty() {
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        
        assertTrue(instance.isEmpty());
        
        instance.addItem(p1);
        instance.addItem(p2);
        
        instance.empty();
        
        assertTrue(instance.isEmpty());
        
        instance.addItem(p1);
        instance.addItem(p2);
        
        try {
            instance.removeItem(p1);
            instance.removeItem(p2);
        } catch (ProductNotFoundException ex) {
            Logger.getLogger(ShoppingCartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertTrue(instance.isEmpty());
        
       
    }

    /**
     * Test of imprimeFactura method, of class ShoppingCart.
     */
    @Test
    public void testImprimeFactura() throws Exception {
        
    }

    /**
     * Test of findProduct method, of class ShoppingCart.
     */
    @Test
    /*Se anyaden dos productos al carrito y buscamos un producto para ver si funciona correctamente*/
    public void testFindProduct() {
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        
        assertTrue(instance.findProduct("Galletas"));
    }
    /*En el constructor comprobamos si el carrito se crea bien y esta vacio*/
    public void testshoppingCart()
    {
    	ShoppingCart instance = new ShoppingCart();
        
        assertTrue(instance.isEmpty());
    }
}
