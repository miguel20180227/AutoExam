package exm.regresion;

import Data.AdminProperties;
import Data.FuenteExcelUtil;
import exm.Test.Actions;
import exm.Test.Test_Belatrix;

public class Test_Belatrix_Run {

	public static String Str_Error;

	FuenteExcelUtil excel;
	Object[][] datos;
	int x_l, y_l, x_c, y_c;
	AdminProperties props;
	Test_Belatrix Test;
	Actions actions;

	public Test_Belatrix_Run() {
		// TODO Auto-generated constructor stub
	}

	public void cargarDatos() {
		try {
			props = new AdminProperties();
			Test = new Test_Belatrix();
			props.cargaPropiedades();
			System.out.println("Inicio Carga Excel");
			excel = new FuenteExcelUtil();
			excel.cargaArchivoExcel(AdminProperties.EXCEL_PATH);
			excel.dimensionExcel(0);
			datos = excel.leerArchivoExcel(0);
			x_l = excel.fila;
			y_l = excel.columna;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Run_Test() {
		try {
			cargarDatos();
			for (int i = 2; i < x_l; i++) {
				if (!datos[i][0].toString().trim().equals("")) {
					Test.cargarDriver();
					Test.ingresarAplicacion();
					Test.busqueda(datos[i][0].toString(), datos[i][1].toString() );
					Test.leerPrecios();
					Test.assertPrecios();
					Test.imprimirProductosAsendente();
					Test.Cerrar_Pagina();
				} else {
					Test.salir();
				}
			}
		} catch (Exception Obj_Excepcion) {
			Str_Error = "Error (00062): Error al ejecutar la clase Run. " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}
