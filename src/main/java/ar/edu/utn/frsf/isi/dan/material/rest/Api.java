package ar.edu.utn.frsf.isi.dan.material.rest;

public interface Api {
    String BASE_PATH = "/api/v1";

    String MATERIAL_BASE_PATH = BASE_PATH + "/material";
    String MATERIAL_ID_GET_PATH = MATERIAL_BASE_PATH + "/{id}";
    String MATERIAL_NOMBRE_GET_PATH =  MATERIAL_BASE_PATH + "/{nombre}";
    String MATERIAL_RANGO_GET_PATH =  MATERIAL_BASE_PATH + "/{min}/{max}";
    String MATERIAL_PRECIO_GET_PATH =  MATERIAL_BASE_PATH + "/{precio}";
    String MATERIAL_ID_PUT_PATH = MATERIAL_BASE_PATH + "/{id}";
}
