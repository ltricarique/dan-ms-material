package ar.edu.utn.frsf.isi.dan.material.rest;

/**
 * @author Leandro Heraldo Tricarique
 * @author Francisco Tomas Gautero
 *
 */
public interface Api
{
	String BASE_PATH = "/api/v1";

	String MATERIAL_BASE_PATH = BASE_PATH + "/material";
	String MATERIAL_ID_GET_PATH = MATERIAL_BASE_PATH + "/{id}";
	String MATERIAL_PUT_ACTUALIZAR_PATH = "/actualizar";
	String MATERIAL_GET_NOMBRE_PATH = "/nombre";
	String MATERIAL_GET_RANGO_STOCK_PATH = "/rangostock";
	String MATERIAL_GET_PRECIO_PATH = "/precio";
}
