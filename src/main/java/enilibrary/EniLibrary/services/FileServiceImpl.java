package enilibrary.EniLibrary.services;


import enilibrary.EniLibrary.entities.Filee;
import enilibrary.EniLibrary.repositories.IFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class FileServiceImpl {

    @Autowired
    IFileRepository filerep;

    public Filee addfile(MultipartFile file) throws IOException {
        // TODO Auto-generated method stub

        System.out.println("file name"+ file.getOriginalFilename());

        Filee fl= new Filee(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getContentType().getBytes()));

        String path="C:/Users/amena/OneDrive/Bureau/webproj/PI1AINFO/front-camping-admin-/src/assets";

        Path pt = Paths.get(path+"/"+file.getOriginalFilename());

        Files.copy(file.getInputStream(), pt, StandardCopyOption.REPLACE_EXISTING);


        return filerep.save(fl);
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

}
