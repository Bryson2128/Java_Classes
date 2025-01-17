import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for the source file path
        System.out.print("Enter the source file path: ");
        String sourceFilePath = scanner.nextLine();

        // Ask user for the destination file path
        System.out.print("Enter the destination file path: ");
        String destinationFilePath = scanner.nextLine();

        try {
            // Perform file upload (copy the file)
            uploadFile(sourceFilePath, destinationFilePath);
            System.out.println("File uploaded successfully!");
        } catch (IOException e) {
            System.out.println("Failed to upload file: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }

    /**
     * Uploads a file by copying it from the source to the destination.
     *
     * @param sourceFilePath      The path to the source file.
     * @param destinationFilePath The path where the file should be uploaded.
     * @throws IOException If an I/O error occurs during file copy.
     */
    public static void uploadFile(String sourceFilePath, String destinationFilePath) throws IOException {
        // Create File objects for the source and destination
        File sourceFile = new File(sourceFilePath);
        Path destinationPath = Path.of(destinationFilePath);

        // Check if source file exists
        if (!sourceFile.exists()) {
            throw new IOException("Source file does not exist.");
        }

        // Copy the file to the destination path (replace existing file if it exists)
        Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}
