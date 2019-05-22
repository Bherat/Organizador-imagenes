package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Foo
 */

/**
 * En esta clase delego todas las acciones correspondientes a la lectura y escritura de imagenes.
 */
public abstract class ImagesActions {
    
    
    /**
     * Recibe un inputstream y lo transforma en una imagen reescalada.
     * @param is InputStream recibido de la db.
     * @param scaledW Ancho que poseera la imagen al reescalarse.
     * @param scaledH Alto que poseera la imagen al reescalarse.
     * @return Image
     */
    public static Image imagenReescalada(InputStream is, int scaledW, int scaledH) {
        Image image = null;
        try {
            BufferedImage buff = ImageIO.read(is);
            image = buff.getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
            
        } catch (IOException ex) {
            Logger.getLogger(ImagesActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return image;
    }
    
        /**
     * Recibe un File y lo transforma en una imagen reescalada.
     * @param f File imagen.
     * @param scaledW Ancho que poseera la imagen al reescalarse.
     * @param scaledH Alto que poseera la imagen al reescalarse.
     * @return Image
     */
    public static Image fileAImagenReescalada(File f, int scaledW, int scaledH) {
        Image image = null;
        try {
            BufferedImage buff = ImageIO.read(f);
            image = buff.getScaledInstance(scaledW, scaledH, Image.SCALE_SMOOTH);
            
        } catch (IOException ex) {
            Logger.getLogger(ImagesActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return image;
    }
    
    public static byte[] fileAImagen(File file) {
        byte[] imageByte = null;
        
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            
            for(int read; (read = is.read(bytes)) != -1;) {
                baos.write(bytes, 0, read);
            }
            
            imageByte = baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(ImagesActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return imageByte;
    }
    
    
    
}
