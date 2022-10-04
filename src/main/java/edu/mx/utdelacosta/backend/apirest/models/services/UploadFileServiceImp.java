package edu.mx.utdelacosta.backend.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImp implements IUploadFileService{

	private final static String DIRECTORIO_UPLOAD = "C:/spring5/temp";
	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImp.class);
	
	
	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {
		Path rutaArchivo = getPath(nombreFoto);
		Resource recurso =  new UrlResource(rutaArchivo.toUri());;
		log.info("Ruta de archivo"+nombreFoto);
		
		if(!recurso.exists() && !recurso.isReadable()) {
			//Agregamos la ruta por default si llegan a eliminar la imagen
			rutaArchivo = Paths.get("src/main/resources/static/img").resolve("not_user_icon.png").toAbsolutePath();
			recurso = new UrlResource(rutaArchivo.toUri());
			log.error("No se pudo cargar la imagen: "+nombreFoto);
			//throw new RuntimeException("No se pudo cargar la imagen: "+nombreFoto);
		}
		return recurso;
	}

	@Override
	public String copiar(MultipartFile archivo) throws IOException {
		String nombreArchivo = UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename().replace(" ", "");
		Path rutaArvhivo = getPath(nombreArchivo);
		
		log.info("Ruta de archivo"+rutaArvhivo.toString());
		Files.copy(archivo.getInputStream(), rutaArvhivo);
		return nombreArchivo;
	}

	@Override
	public boolean eliminar(String nombreFoto) {
		if(nombreFoto!=null && nombreFoto.length()>0) {
			Path rutaFotoanterior = getPath(nombreFoto);
			File archivoFotoAnterior = rutaFotoanterior.toFile();
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String nombreFoto) {
		// TODO Auto-generated method stub
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
	}

}
