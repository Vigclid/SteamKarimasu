package common;

import controller.dto.ProductDTO;
import model.Entity.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;


public class ImageUtils {

    public product saveThumbnail(ProductDTO productDTO, product productEntity) {
        String basePath = "C:\\Users\\Admin\\Documents\\Github\\SteamKarimasu\\web\\assets";
        String entityFolder = "\\images_product\\";
        String path = basePath +  entityFolder + productDTO.getImageProduct();

        // Ensure the entity folder exists; create it if not
        createDirectoryIfNotExists(basePath + entityFolder);

        // Save the image if base64 data is provided
        if (productDTO.getImageBase64() != null) {
//            deleteOldImageIfExists(productDTO.getImageProduct(), basePath);
            saveNewImage(productDTO.getImageBase64(),  path);
            productEntity.setProductImage(path);  // Assuming setImagePath() is used to store the image path
        }
        return  productEntity;
    }

    private void deleteOldImageIfExists(String imagePath, String basePath) {
        if (imagePath != null) {
            File file = new File(basePath + imagePath);
            if (file.exists()) {
                file.delete();  // Delete the old file if it exists
            }
        }
    }

    private void saveNewImage(String imageBase64, String path) {
        try {
            byte[] bytes = Base64.getDecoder().decode(imageBase64);
            writeOrUpdate(path, bytes);
        } catch (Exception e) {
            System.err.println("Error saving new image: " + e.getMessage());
        }
    }

    private void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void writeOrUpdate(String path, byte[] bytes) {
        path = path.replace("\\", "/");
        File file = new File(path);

        // Ensure parent directory exists
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (FileOutputStream fop = new FileOutputStream(file)) {
            fop.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}