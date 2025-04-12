package javastreams;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import javax.imageio.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\javastreams\\Vachan Shetty_Arc.png"; // Ensure
                                                                                                                              // this
                                                                                                                              // image
                                                                                                                              // exists
        String outputImagePath = "src/javastreams/output.png";

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(inputImagePath);
            System.out.println("Image successfully converted to byte array");
            System.out.println("Byte array size: " + imageBytes.length + " bytes");

            // Convert byte array back to image
            byteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array successfully converted back to image");

            // Verify files are identical
            boolean areIdentical = verifyFiles(inputImagePath, outputImagePath);
            System.out.println("Files are identical: " + areIdentical);

        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static byte[] imageToByteArray(String imagePath) throws IOException {
        // Read the image
        BufferedImage originalImage = ImageIO.read(new File(imagePath));

        // Create a ByteArrayOutputStream to store the image bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Get the image format (extension)
        String format = imagePath.substring(imagePath.lastIndexOf(".") + 1);

        // Write the image to ByteArrayOutputStream
        ImageIO.write(originalImage, format, baos);

        // Convert to byte array
        return baos.toByteArray();
    }

    public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        // Create ByteArrayInputStream from byte array
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
            // Read the image from ByteArrayInputStream
            BufferedImage image = ImageIO.read(bais);

            // Get the image format (extension)
            String format = outputPath.substring(outputPath.lastIndexOf(".") + 1);

            // Write the image to file
            ImageIO.write(image, format, new File(outputPath));
        }
    }

    public static boolean verifyFiles(String file1Path, String file2Path) throws IOException {
        // Read both files as byte arrays
        byte[] file1Bytes = Files.readAllBytes(Paths.get(file1Path));
        byte[] file2Bytes = Files.readAllBytes(Paths.get(file2Path));

        // Compare arrays
        if (file1Bytes.length != file2Bytes.length) {
            return false;
        }

        // Compare each byte
        for (int i = 0; i < file1Bytes.length; i++) {
            if (file1Bytes[i] != file2Bytes[i]) {
                return false;
            }
        }

        return true;
    }
}