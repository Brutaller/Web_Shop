package ru.kpfu.itis.util;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.model.Book;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Azat Zaripov on 10.04.16.
 */
public class FileSaver {

    public static void save(MultipartFile file, Book book) throws IOException {

        byte[] bytes = file.getBytes();

        String name = file.getOriginalFilename();

        String rootPath = "/resources/image/upload/";

        File uploadedFile = new File(rootPath + name);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
        stream.write(bytes);
        stream.flush();
        stream.close();

        System.out.println("uploaded: " + uploadedFile.getAbsolutePath());

        book.setImagePath(rootPath + name);
    }
}
