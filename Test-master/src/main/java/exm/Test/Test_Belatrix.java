package exm.Test;

import Data.AdminProperties;
import Data.CompararObjetos;
import Data.Productos;
import Framework.Cls_Cross_Browsing;
import Framework.Cls_Encontrar_Elemento;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.*;

import static org.junit.Assert.assertFalse;

public class Test_Belatrix {

	Cls_Cross_Browsing Obj_Cross_Browsing;
	Cls_Encontrar_Elemento Obj_Encontrar_Elemento;
	Cls_Encontrar_Elemento ATH;
	public static String Str_Error;
	Actions actions;
	WebDriver Obj_Driver;
	String str_Results = "";
	double dbl_Price_1;
	double dbl_Price_2;
	double dbl_Price_3;
	double dbl_Price_4;
	double dbl_Price_5;

	// Variables
	String str_Field_Research = ".//*[@id='gh-ac']";
	String str_Field_Research_Id = "gh-ac";
	String str_Btn_Research = ".//*[@id='gh-btn']";
	String str_Field_Brand = "w4-w2-0[0]";
	String str_Chk_Brand = "//input[@type='checkbox'][@aria-label='PUMA']";
	String str_Chk_Size = "//input[@type='checkbox'][@aria-label='10']";
	String str_Field_Results = "//h1[@class='srp-controls__count-heading']";
	String str_DD_Order = "//span[contains(.,'Precio + Envío: más bajo primero')]";
	String str_DD_Order_Css = "#w9 > .x-flyout__button use";
	String str_DD_Order_Css2 = "#w9 > .x-flyout__button .svg-icon";
	String str_DD_Order_Ascendant_Css = ".btn:nth-child(4) span";
	String str_Shoes_1 = "//*[@id=\"srp-river-results-listing1\"]/div/div[2]/div[3]/div[1]/span[1]";
	String str_Shoes_2 = "//*[@id=\"srp-river-results-listing2\"]/div/div[2]/div[3]/div[1]/span";
	String str_Shoes_3 = "//*[@id=\"srp-river-results-listing3\"]/div/div[2]/div[3]/div[1]/span";
	String str_Shoes_4 = "//*[@id=\"srp-river-results-listing4\"]/div/div[2]/div[3]/div[1]/span[1]";
	String str_Shoes_5 = "//*[@id=\"srp-river-results-listing5\"]/div/div[2]/div[3]/div[1]/span";
	String str_Txt_Nombre1 = "//*[@id=\"srp-river-results-listing1\"]/div/div[2]/a/h3";
	String str_Txt_Nombre2 = "//*[@id=\"srp-river-results-listing2\"]/div/div[2]/a/h3";
	String str_Txt_Nombre3 = "//*[@id=\"srp-river-results-listing3\"]/div/div[2]/a/h3";
	String str_Txt_Nombre4 = "//*[@id=\"srp-river-results-listing4\"]/div/div[2]/a/h3";
	String str_Txt_Nombre5 = "//*[@id=\"srp-river-results-listing5\"]/div/div[2]/a/h3";

	public void cargarDriver() {
		Obj_Cross_Browsing = new Cls_Cross_Browsing();
		Obj_Cross_Browsing.Eleccion_Browser(AdminProperties.BROWSER, AdminProperties.LOG_OPTION);
		Obj_Driver = Obj_Cross_Browsing.get_Obj_Driver();
	}

	public void ingresarAplicacion() {
		try {
			Obj_Cross_Browsing.Abrir_Website(Obj_Driver, "https://www.ebay.com/");
			actions = new Actions(Obj_Cross_Browsing.get_Obj_Driver());
			actions.className = this.getClass().getSimpleName();
		} catch (Exception Obj_Excepcion) {
			Str_Error = "Error (00007): Error inicializando el navegador , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	public void busqueda(String str_Busqueda, String str_Brand) {
		try {
			actions.esperarSegundos(3);
			actions.TypeByID(str_Field_Research_Id, str_Busqueda);
			actions.clickByXpath(str_Btn_Research);
			actions.TypeByID(str_Field_Brand, str_Brand);
			actions.clickByXpath(str_Chk_Brand);
			actions.clickByXpath(str_Chk_Size);
			str_Results = actions.GetTextByXpath(Obj_Driver, str_Field_Results);
			System.out.println("This is the result of shoes: " + str_Results);
		} catch (Exception Obj_Excepcion) {
			Str_Error = "Error (00008): Error en Busqueda , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	public void leerPrecios() {
		try {
			actions.clickByCSS(str_DD_Order_Css);
			actions.clickByCSS(str_DD_Order_Css2);
			actions.clickByCSS(str_DD_Order_Ascendant_Css);
			String str_Price_1 = actions.GetTextByXpath(Obj_Driver, str_Shoes_1);
			str_Price_1 = str_Price_1.replace("COP $", "").replace(" ", "");
			if (str_Price_1.equals(""))
				str_Price_1 = "0";
			System.out.println("The price 1 is: " + str_Price_1);
			String str_Price_2 = actions.GetTextByXpath(Obj_Driver, str_Shoes_2);
			str_Price_2 = str_Price_2.replace("COP $", "").replace(" ", "");
			if (str_Price_2.equals(""))
				str_Price_2 = "0";
			System.out.println("The price 2 is: " + str_Price_2);
			String str_Price_3 = actions.GetTextByXpath(Obj_Driver, str_Shoes_3);
			if (str_Price_3.length()>15) {
				str_Price_3 = str_Price_3.substring(14);
			}
			str_Price_3 = str_Price_3.replace("COP $", "").replace("a", "").replace(" ", "");
			if (str_Price_3.equals(""))
				str_Price_3 = "0";
			System.out.println("The price 3 is: " + str_Price_3);
			String str_Price_4 = actions.GetTextByXpath(Obj_Driver, str_Shoes_4);
			str_Price_4 = str_Price_4.replace("COP $", "").replace(" ", "");
			if (str_Price_4.equals(""))
				str_Price_4 = "0";
			System.out.println("The price 4 is: " + str_Price_4);
			String str_Price_5 = actions.GetTextByXpath(Obj_Driver, str_Shoes_5);
			str_Price_5 = str_Price_5.replace("COP $", "").replace(" ", "");
			if (str_Price_5.equals(""))
				str_Price_5 = "0";
			System.out.println("The price 5 is: " + str_Price_5);

			dbl_Price_1 = Double.parseDouble(str_Price_1);
			dbl_Price_2 = Double.parseDouble(str_Price_2);
			dbl_Price_3 = Double.parseDouble(str_Price_3);
			dbl_Price_4 = Double.parseDouble(str_Price_4);
			dbl_Price_5 = Double.parseDouble(str_Price_5);

			actions.TypeKeysByXpath(Obj_Driver, str_Btn_Research, Keys.PAGE_DOWN);
			actions.TakeScreenshot(Obj_Driver);
		} catch (Exception Obj_Excepcion) {
			Obj_Excepcion.printStackTrace();
			Str_Error = "Error (00009): Error en Comparar Precios, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	@Test
	public void assertPrecios() {
		try {
			assertFalse(dbl_Price_1 < dbl_Price_2);
			assertFalse(dbl_Price_2 < dbl_Price_3);
			assertFalse(dbl_Price_3 < dbl_Price_4);
			assertFalse(dbl_Price_4 < dbl_Price_5);
			System.out.println("Test Passed");
		} catch (Exception Obj_Excepcion) {
			Obj_Excepcion.printStackTrace();
			Str_Error = "Error (00010): Error en Assert, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	public void imprimirProductos() {
		String nombre1 = actions.GetTextByXpath(Obj_Driver, str_Txt_Nombre1);
		String nombre2 = actions.GetTextByXpath(Obj_Driver, str_Txt_Nombre2);
		String nombre3 = actions.GetTextByXpath(Obj_Driver, str_Txt_Nombre3);
		String nombre4 = actions.GetTextByXpath(Obj_Driver, str_Txt_Nombre4);
		String nombre5 = actions.GetTextByXpath(Obj_Driver, str_Txt_Nombre5);

		System.out.println("Nombre 1: " + nombre1);
		System.out.println("Nombre 2: " + nombre2);
		System.out.println("Nombre 3: " + nombre3);
		System.out.println("Nombre 4: " + nombre4);
		System.out.println("Nombre 5: " + nombre5);

		ArrayList<String> nombreProductos = new ArrayList<>();
		ArrayList<Double> precios = new ArrayList<>();
		nombreProductos.add(nombre1);
		nombreProductos.add(nombre2);
		nombreProductos.add(nombre3);
		nombreProductos.add(nombre4);
		nombreProductos.add(nombre5);
		precios.add(dbl_Price_1);
		precios.add(dbl_Price_2);
		precios.add(dbl_Price_3);
		precios.add(dbl_Price_4);
		precios.add(dbl_Price_5);
		System.out.println("*** *** PRODUCTOS EN ORDEN ASCENDENTE *** ***");
		Collections.sort(nombreProductos);
		for (String temp : nombreProductos) {
			System.out.println(temp);
		}
		System.out.println("*** *** PRECIOS EN ORDEN DESCENDENTE *** ***");
		Collections.reverse(precios);
		for (Double temp : precios) {
			System.out.println(temp);
		}

//		Productos producto1 = new Productos(nombre1, dbl_Price_1);
//		Productos producto2 = new Productos(nombre2, dbl_Price_2);
//		Productos producto3 = new Productos(nombre3, dbl_Price_3);
//		Productos producto4 = new Productos(nombre4, dbl_Price_4);
//		Productos producto5 = new Productos(nombre5, dbl_Price_5);

		List<Productos> productos = new ArrayList<>(Arrays.asList(new Productos(nombre1, dbl_Price_1),
				new Productos(nombre2, dbl_Price_2), new Productos(nombre3, dbl_Price_3),
				new Productos(nombre4, dbl_Price_4), new Productos(nombre5, dbl_Price_5)));

		Comparator<Productos> comparador = new Comparator<Productos>() {
			public int compare(Productos a, Productos b) {
				int resultado = Double.compare(a.getPrecio(), b.getPrecio());
				if (resultado != 0) {
					return resultado;
				}

				// resultado = comparaPrioridad( a.prioridad(), b.prioridad() );
				// if ( resultado != 0 ) { return resultado; }

				resultado = a.getNombre().compareTo(b.getNombre());
				if (resultado != 0) {
					return resultado;
				}
				return resultado;
			}
		};
	
	
		System.out.printf("Antes: %s%n\n", productos);
		Collections.sort(productos, comparador);
		System.out.printf("Despues: %s%n\n", productos);
		
		Collections.sort(productos,new CompararObjetos());
        
        for(Productos aux: productos){
            System.out.println(aux);
        }
		
	}

//	private static ArrayList<String> sortA(ArrayList<String> st, ArrayList<Double> us) {
//		ArrayList<String> list = new ArrayList<>();
//		String s;
//		for (int i = 0; i < st.size(); i++) {
//			s = st.get(i) + ": " + us.get(i);
//			list.add(s);
//		}
//		HashSet<String> set = new HashSet<>(list);
//		list.clear();
//		list.addAll(set);
//		return list;
//	}

	public void Cerrar_Pagina() {
		try {
			Obj_Driver.quit();
		} catch (Exception Obj_Excepcion) {
			Str_Error = "Error (000013): Error en cerrar pagina de bancos , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	public void salir() throws InterruptedException {
		Thread.sleep(30000);
		Obj_Driver.quit();
	}
}
