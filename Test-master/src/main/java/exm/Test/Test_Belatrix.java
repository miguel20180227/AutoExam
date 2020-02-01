package exm.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.text.View;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Data.AdminProperties;
import Framework.Cls_Cross_Browsing;
import Framework.Cls_Encontrar_Elemento;

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
			str_Price_3 = str_Price_3.substring(15);
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
		assertTrue(dbl_Price_1 < dbl_Price_2);
		assertTrue(dbl_Price_2 < dbl_Price_3);
		assertFalse(dbl_Price_3 < dbl_Price_4);
		assertTrue(dbl_Price_4 < dbl_Price_5);
		System.out.println("Test Passed");  
		} catch (Exception Obj_Excepcion) {
			Obj_Excepcion.printStackTrace();
			Str_Error = "Error (00010): Error en Assert, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	public void imprimirProductosAsendente() {
		String nombre1 = actions.GetTextByXpath(Obj_Driver,str_Txt_Nombre1);
		String nombre2 = actions.GetTextByXpath(Obj_Driver,str_Txt_Nombre2);
		String nombre3 = actions.GetTextByXpath(Obj_Driver,str_Txt_Nombre3);
		String nombre4 = actions.GetTextByXpath(Obj_Driver,str_Txt_Nombre4);
		String nombre5 = actions.GetTextByXpath(Obj_Driver,str_Txt_Nombre5);
		
		System.out.println("Nombre 1: "+nombre1);
		System.out.println("Nombre 2: "+nombre2);
		System.out.println("Nombre 3: "+nombre3);
		System.out.println("Nombre 4: "+nombre4);
		System.out.println("Nombre 5: "+nombre5);
		
		ArrayList<String> stud = new ArrayList<>();
        ArrayList<Double> uspe = new ArrayList<>();
        stud.add(nombre1);
        stud.add(nombre2);
        stud.add(nombre3);
        stud.add(nombre4);
        stud.add(nombre5);
        uspe.add(4.5);
        uspe.add(6.3);
        uspe.add(3.8);
        uspe.add(5.5);
        uspe.add(4.7);

        Collections.sort(stud);
        for(String temp: stud){
            System.out.println(temp);
        }		
	}
	
	private static ArrayList<String> sortA(ArrayList<String> st, ArrayList<Double> us) {
        ArrayList<String> list = new ArrayList<>();
        String s;
        for (int i = 0; i < st.size(); i++) {
            s = st.get(i) + ": " + us.get(i);
            list.add(s);
        }
        HashSet<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }
	
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
