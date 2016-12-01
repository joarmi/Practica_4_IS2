/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author User
 */
@RunWith(value = Parameterized.class)
public class ParamShoppingCartTest {    
    
    /*Creamos la lista de parametros para cada prueba, estos objetos seran los parametros que utilizaran 
      los metodos para utilizar las variables*/
    @Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> obj = new ArrayList<>();
        obj.add(new Object[] {3, 12});
        obj.add(new Object[] {2, 8});
        obj.add(new Object[] {1, 4});
        
        return obj;
    }
    
    private int precio1;
    private int precio2;
    
    /*pasamos las 2 variables al constructor para que las inicialice*/
    public ParamShoppingCartTest(int precio1, int precio2) {
        
        this.precio1 = precio1;
        this.precio2 = precio2; 
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
    @Test
    /*He utilizado los 2 precios, uno para que sea el precio de cada producto y el otro sera la suma total de los precios*/
    public void testGetBalance() {
        System.out.println("getBalance");
        ShoppingCart instance = new ShoppingCart();
        
        Product p1 = new Product("Galletas", precio1);
        Product p2 = new Product("Raton", precio1);
        Product p3 = new Product("Teclado", precio1);
        Product p4 = new Product("Monitor 4K", precio1);
        
        instance.addItem(p1);
        instance.addItem(p2);
        instance.addItem(p3);
        instance.addItem(p4);
        
        double precio_total = precio2;
        
        double result = instance.getBalance();
        assertEquals(precio_total, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class ShoppingCart.
     */
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
    @Test
    public void testIsEmpty() {
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        
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
    public void testFindProduct() {
        ShoppingCart instance = new ShoppingCart();
        Product p1 = new Product("Galletas", 1.2);
        Product p2 = new Product("Raton", 85.6);
        
        instance.addItem(p1);
        instance.addItem(p2);
        
        assertTrue(instance.findProduct("Galletas"));
    }
    
    public void testshoppingCart()
    {
    	ShoppingCart instance = new ShoppingCart();
        
        assertTrue(instance.isEmpty());  
    }
}
